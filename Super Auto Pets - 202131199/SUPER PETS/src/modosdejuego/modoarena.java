package modosdejuego;
import recursos.*;
import java.util.Random;

import principal.menu;
public class modoarena extends objetos
{
    Random random = new Random();
    objetos Object = new objetos();
    menubatallas menuBatalla = new menubatallas();
    int estado=0, ronda=0, arenaCJ=0, estado2=0;
    int equipo1[][] = new int [5][10];
    int equipo2[][] = new int [5][10];
    int t1r[][] = new int [5][10];
    int t2r[][] = new int [5][10];
    int equipoAtaque [][] = new int [5][10];
    int equipoDefensa [][] = new int [5][10]; 
    int cont;
    boolean haymuertos=false;

    public void inicio(int arena)
    {
        arenaCJ = arena;
        System.out.println("\n----------------------------------------------------------");
        System.out.println("----------------------   MODO ARENA   ----------------------");
        System.out.println("----------------------------------------------------------\n");

        
        do{
            estado2=0;
            ronda++;
            equipo1 = menuBatalla.irAMenu(equipo1,ronda);
            equipo2 = menuBatalla.generarOp(equipo1,ronda);
            for (int f = 0;f<5;f++)
            {
                for (int c =0;c<10;c++)
                {
                    t1r[f][c] = equipo1 [f][c];
                    t2r[f][c] = equipo2 [f][c];
                }
            } 
            verEquipos();
            inicioRonda();
            batalla();
            //finishround();
        }while (estado==0);
    }

    public void inicioRonda()
    {
        habilidadInicial(1);
        habilidadInicial(2);
        verEquipos();
        do {
            haymuertos=false;
            BuscarSiHayMuertes(1);
            BuscarSiHayMuertes(2);
            revisarMuertes();
        }while(haymuertos);
    }

    public void revisarMuertes()
    {
        for (int f=0;f<5;f++)
        {
            if(t1r[f][0]!=0 && t1r[f][1]<=0)
            haymuertos=true;
            if(t2r[f][0]!=0 && t2r[f][1]<=0)
            haymuertos=true;
        }

    }

    public void verEquipos()
    {
        menuBatalla.verEquipo(t1r, true);
        menuBatalla.verEquipo(t2r, false);
    }

    public void batalla()
    {
        do
        {
            turnos(1);
            turnos(2);
            do {
                haymuertos=false;
                BuscarSiHayMuertes(1);
                BuscarSiHayMuertes(2);
                revisarMuertes();
            }while(haymuertos);
            verEquipos();
            estado();
        }while(estado2==0);
    }

    public void estado()
    {
        boolean ht1=false, ht2=false;
        for (int f=0;f<5;f++)
        {
            if(t1r[f][0]!=0)//todavia tiene jugadores el equipo 1, no ha perdido
            ht1 = true;
            if(t2r[f][0]!=0)//todavia tiene jugadores el equipo 2, no ha ganado
            ht2 = true;
        }
        if (!ht2 && ht1)// si todavia tiene jugadores y el otro no, gano
        estado2=1;
        if (!ht1 && ht2)// si no tiene jugadores y el segundo si, perdio
        estado2=2;
        if (!ht1 && !ht2)// si ninguno tiene, empate
        estado2 =3;
    }

    public void turnos(int turn)
    {
        int attack= equipoAtaque[0][2];
        granturn(turn);
        ordenEquipo(true);
        ataque(0, 0, attack, turn);
        restoreturn(turn);
    }

    public void terminarRonda()
    {

    }

    public void BuscarSiHayMuertes (int turn)
    {
        String nombre ="";
        granturn(turn);
        int cont=0;
        for (int cnt =0;cnt <5;cnt ++)
        {
            if (equipoAtaque[cnt][0]!=0)
            {
                if (equipoAtaque[cnt][1]<=0)
                {
                    if(cont==0)
                    System.out.println("EQUIPO "+turn+": ");
                    nombre = Object.getNombre(equipoAtaque[cnt][0]);
                    System.out.println(nombre + " HA FALLECIDO");
                    danioAmigo(cnt);
                    muerteHabilidad(equipoAtaque[cnt][0],cnt);
                    cont++;
                }
            }
        }
        ordenEquipo(true);
        restoreturn(turn); 
    }

    public void danioAmigo(int posatt)
    {
        if(posatt<4)
        {
            posatt++;
        }
        if(equipoAtaque[posatt][0]==25)
        {
            int level= equipoAtaque[posatt][3];
            level *= 2;
            equipoAtaque[posatt][1] += 20;
            equipoAtaque[posatt][2] += level;
            System.out.println("MEJOR ME PROTEJO: BUEY HA GANADO MELON ARMOUR Y " + level + " DE ATAQUE");
        }
    }

    public void muerteHabilidad (int codigoDeAtaque, int posicionAtaque)
    {
        int level = equipoAtaque[posicionAtaque][3], aliado;
        String nameatt = Object.getNombre(codigoDeAtaque);
        switch (codigoDeAtaque)
        {
            case 1: //hormiga da a aliado
            boolean error=false;
            int cantderror=0;
            do{
                aliado = generarNumAleatorio(4, 0);
                if (aliado == posicionAtaque)
                    error=true;
                if (equipoAtaque[aliado][0]==0 || equipoAtaque[aliado][1]<=0)
                    error= true;
                    cantderror++;
                if (!error)
                {
                    equipoAtaque[aliado][2]+=level *2;
                    equipoAtaque[aliado][1]+=level;
                }
                if (cantderror ==10)
                    error = false;
            }while (error);
                eliminarMascota(posicionAtaque);
                System.out.println("HORMIGA HA DADO A ALIADO" + (level *2) + "/" + level );
            break;
            case 4: // grillo convoca a un grillo zombi
                invocar(codigoDeAtaque,posicionAtaque, level,55);
                break;
            case 12: level = level * 2;
                System.out.println("PUERCO ESPIN  HIZO "+ level + " DE  DAÑO A TODAS LAS MASCOTAS");
                for (int f =0; f<5;f++)
                {
                    //equipo 1
                    if (posicionAtaque!=0)
                    {
                        equipoAtaque[f][1] -= level;
                    }
                    equipoDefensa[f][1] -= level;
                    eliminarMascota(posicionAtaque);
                }
                break;
            case 14: 
            invocar(codigoDeAtaque,posicionAtaque, level,56);
                break;
            case 16: 
            invocar(codigoDeAtaque,posicionAtaque, level,60);
                break;
            case 18:
                int pos1 = posicionAtaque-1, pos2 = posicionAtaque +1;
                if (pos1 >=0)
                {
                    String name = Object.getNombre(equipoAtaque[pos1][0]);
                    equipoAtaque[pos1][2]  += equipoAtaque[pos1][2] * level;
                    System.out.println(" MAPACHE HA DADO "+level+"x  A ALIADO DE ADELANTE");
                }
                if (pos2<=4)
                {
                    String name = Object.getNombre(equipoAtaque[pos1][0]);
                    equipoAtaque[pos2][2]  += equipoAtaque[pos2][2] * level;
                    System.out.println(" MAPACHE HA DADO "+level+"x  A ALIADO DE ATRAS");
                }
                eliminarMascota(posicionAtaque);
                break;
            case 20:
                int f=posicionAtaque+1;
                int cnt=1;
                while(f!=4 && cnt <= level)
                {
                    equipoAtaque[f][1]+=20;
                    f++;
                    cnt++;
                }
                System.out.println("TORTUGA HA DADO ARMADURA DE MELON A "+ (cnt-1)+ " ALIADOS DETRAS");
                eliminarMascota(posicionAtaque);
                break;
            case 22:
            invocar(codigoDeAtaque,posicionAtaque, level,57); break;
            case 28:
            invocar(codigoDeAtaque,posicionAtaque, level,58);  break;
            case 48: 
                level *=2;
                for (f=0;f<5;f++)
                {
                    if (equipoAtaque[f][0] !=0 && equipoAtaque[f][0] != codigoDeAtaque)
                    {
                        equipoAtaque[f][1] += level;
                        equipoAtaque[f][2] += level;
                    }
                }
                System.out.println("MAMUT HA DADO A TODOS SUS AMIGOS " + level+ "/"+level);
                eliminarMascota(posicionAtaque);
                break;
            default: eliminarMascota(posicionAtaque);
        }
    }

    public void eliminarMascota(int posatt)
    {
        equipoAtaque[posatt][0] = 0;
        equipoAtaque[posatt][1] = 0;
        equipoAtaque[posatt][2] = 0;
        equipoAtaque[posatt][3] = 0;
        equipoAtaque[posatt][4] = 0;
        equipoAtaque[posatt][5] = 0;
        equipoAtaque[posatt][6] = 0;
        equipoAtaque[posatt][7] = 0;
        equipoAtaque[posatt][8] = 0;
        equipoAtaque[posatt][9] = 0;
        ordenEquipo(true);
    }

    public void ordenEquipo(boolean positivo)
    {
        if (positivo)
        {
            for (int f =0; f<5;f++)
            {
            if (equipoAtaque[f][0]==0 && f<4)
            {
                
                equipoAtaque[f][0] = equipoAtaque[f+1][0];
                equipoAtaque[f][1] = equipoAtaque[f+1][1];
                equipoAtaque[f][2] = equipoAtaque[f+1][2];
                equipoAtaque[f][3] = equipoAtaque[f+1][3];
                equipoAtaque[f][4] = equipoAtaque[f+1][4];
                equipoAtaque[f][5] = equipoAtaque[f+1][5];
                equipoAtaque[f][6] = equipoAtaque[f+1][6];
                equipoAtaque[f][7] = equipoAtaque[f+1][7];
                equipoAtaque[f][8] = equipoAtaque[f+1][8];
                equipoAtaque[f][9] = equipoAtaque[f+1][9];
                equipoAtaque[f+1][0] = 0;
                equipoAtaque[f+1][1] = 0;
                equipoAtaque[f+1][2] = 0;
                equipoAtaque[f+1][3] = 0;
                equipoAtaque[f+1][4] = 0;
                equipoAtaque[f+1][5] = 0;
                equipoAtaque[f+1][6] = 0;
                equipoAtaque[f+1][7] = 0;
                equipoAtaque[f+1][8] = 0;
                equipoAtaque[f+1][9] = 0;
            }
            }
        }
        else{
            for (int f =4; f>=0;f--)
            {
                if (equipoAtaque[f][0]==0 && f>0)
                {
                    equipoAtaque[f][0] = equipoAtaque[f-1][0];
                    equipoAtaque[f][1] = equipoAtaque[f-1][1];
                    equipoAtaque[f][2] = equipoAtaque[f-1][2];
                    equipoAtaque[f][3] = equipoAtaque[f-1][3];
                    equipoAtaque[f][4] = equipoAtaque[f-1][4];
                    equipoAtaque[f][5] = equipoAtaque[f-1][5];
                    equipoAtaque[f][6] = equipoAtaque[f-1][6];
                    equipoAtaque[f][7] = equipoAtaque[f-1][7];
                    equipoAtaque[f][8] = equipoAtaque[f-1][8];
                    equipoAtaque[f][9] = equipoAtaque[f-1][9];
                    equipoAtaque[f-1][0] = 0;
                    equipoAtaque[f-1][1] = 0;
                    equipoAtaque[f-1][2] = 0;
                    equipoAtaque[f-1][3] = 0;
                    equipoAtaque[f-1][4] = 0;
                    equipoAtaque[f-1][5] = 0;
                    equipoAtaque[f-1][6] = 0;
                    equipoAtaque[f-1][7] = 0;
                    equipoAtaque[f-1][8] = 0;
                    equipoAtaque[f-1][9] = 0;
                }
            }
        }
    }

    public void invocar(int codeatt,int posatt, int level,int codeinv)
    {
        String nameatt = Object.getNombre(codeatt), nameinv = Object.getNombre(codeinv);
        eliminarMascota(posatt);
        ordenEquipo(false);
        if (codeatt==4)
        {
            equipoAtaque[0][0] = codeinv;
            equipoAtaque[0][1] = level;
            equipoAtaque[0][2] = level;
            equipoAtaque[0][3] = 1;
            System.out.println( nameatt +" HA INVOCADO A "+ nameinv);
        }
        if (codeatt == 14)
        {
            int posi=0;
            for(int cant =1;cant <=level;cant++)
            {
                if (equipoAtaque[posi][0]==0)
                {
                    equipoAtaque[posi][0] = codeinv;
                    equipoAtaque[posi][1] =1;
                    equipoAtaque[posi][2] =1;
                    equipoAtaque[posi][3] =1;
                    posi++;
                }
            }
            System.out.println( nameatt +" HA INVOCADO A "+ nameinv);
        }
        if (codeatt == 16)
        {
            equipoAtaque[0][0]= codeinv;
            equipoAtaque[0][1] =1;
            equipoAtaque[0][2] =1;
            equipoAtaque[0][3] = level;
            if (level ==3)
            {
                equipoAtaque[0][1] +=1;
                equipoAtaque[0][2] +=1;
            }
            System.out.println( nameatt +" HA INVOCADO A "+ nameinv);
        }
        if (codeatt == 22)
        {
            int posi=0;
            for(int cant =1;cant <=2;cant++)
            {
                if (equipoAtaque[posi][0]==0)
                {
                    level *=2;
                    equipoAtaque[posi][0] = codeinv;
                    equipoAtaque[posi][1] =level;
                    equipoAtaque[posi][2] =level;
                    equipoAtaque[posi][3] =1;
                    posi++;
                }
            }
            System.out.println( nameatt +" HA INVOCADO A "+ nameinv);
        }
        if (codeatt==28)
        {
            level *=5;
            equipoAtaque[0][0] = codeinv;
            equipoAtaque[0][1] = level;
            equipoAtaque[0][2] = level;
            equipoAtaque[0][3] = 1;
            System.out.println( nameatt +" HA INVOCADO A "+ nameinv);
        }
        ordenEquipo(true);
    }

    public void habilidadInicial(int turno)
    {
        cont=0;
        granturn(turno);
        for(int f =0 ; f <5; f++)
        inicaHabilidad(equipoAtaque [f][0], f,turno);
        restoreturn(turno);
    }

    public void inicaHabilidad(int codigoAtaque, int posicionAtaque, int turno)
    {
        int nivel = equipoAtaque[posicionAtaque][3];
        int vDefensa =0, vAtaque =0, ataque=0, ataqueA=0, ataqueD=0, segundaPosicion=0,vida =0, max=1, min=100;
        String nameattack = getNombre(codigoAtaque);
        switch(codigoAtaque)
        {
            case 3,9,10,11,17,19,31,38,39,41,49,53,54:
            if (cont ==0)
            System.out.println("EQUIPO "+turno+": ");
            cont++;
            break;
        }
        switch (codigoAtaque)
        {
            case 3:
            System.out.println("HABILIDAD INICIAL "+ nameattack) ;
            for (int c = 1;c <= nivel;c++)
                {
                    int posdef = generarNumAleatorio(4, 0);
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    
                    ataque(posicionAtaque, posdef, 1,turno);
                }
            break;
            case 9: //metamorfosis(sapo): copiar vida del aliado con mas vida(no es permanente)
            max=1;
            for(int f=0;f<5;f++){
                if(equipoAtaque[f][1]>max){
                    max = equipoAtaque[f][1];
                    equipoAtaque [posicionAtaque][1]= max;
                }
            }
            System.out.println("HABILIDAD INICIAL "+ nameattack) ;
            System.out.println("HA COPIADO LA VIDA DEL ALIADO MAS FUERTE");
            break;
            case 10: 
            segundaPosicion = posicionAtaque -1;
            if (segundaPosicion>=0)
            {
              ataque = equipoAtaque[segundaPosicion][2];
              ataque =  ataque + ataque * ((50 *nivel)/100); 
              equipoAtaque[segundaPosicion][2] = ataque;
              System.out.println("HABILIDAD INICIAL "+ nameattack) ;
              System.out.println("HA DADO ATAQUE AL DE ADELANTE");
            }
            break;
            case 11:
            segundaPosicion = posicionAtaque + 1;
            for (int c = 1;c <= nivel;c++)
                {
                    if (segundaPosicion<=4)
                    {
                        equipoAtaque[segundaPosicion][1]-=1;
                        segundaPosicion++;
                    }
                }
                System.out.println("HABILIDAD INICIAL "+ nameattack) ;
                System.out.println("HA HECHO 1 DE DAÑO A " + nivel + " ALIADO(S) DE ATRAS");
            break;
            case 17: //Joroba(camello): Dar amigo detrás (+1/+2)/(+2/+4) / (+3/+6) 
            segundaPosicion = posicionAtaque + 1;
            if (segundaPosicion<=4)
            {
                ataque = 1 * nivel;
                vida = 2 * nivel;
                equipoAtaque[segundaPosicion][1]+= vida;
                equipoAtaque[segundaPosicion][2]+= ataque;
                System.out.println("HABILIDAD INICIAL "+ nameattack) ;
                System.out.println("HA COPIADO LA VIDA DEL ALIADO MAS FUERTE");
            }
            break;
            case 19:// Fortaleza aliada(jirafa): Da 1, 2 o 3 amigos por delante +1/+1 al finalizar el turno de compra. 
            segundaPosicion = posicionAtaque - 1;
            for (int c = 1;c <= nivel;c++)
                {
                    if (segundaPosicion>=0)
                    {
                        equipoAtaque[segundaPosicion][1]+= 1;
                        equipoAtaque[segundaPosicion][2]+= 1;
                        segundaPosicion--;
                        
                    }
                }
                System.out.println("HABILIDAD INICIAL "+ nameattack) ;
                System.out.println("HA DADO 1/1 A " + nivel + " ALIADO(S) DE DELANTE");
            break;
            case 31: // Salpicón(delfin): reparte 5/10/15 de daño al enemigo con la salud más baja al comenzar la batalla. 
            for(int f=0;f<5;f++){
                if(equipoDefensa[f][1] < min){
                    min = equipoDefensa[f][1];
                    segundaPosicion = f;
                }
            }
            equipoDefensa[segundaPosicion][1] -= (5*nivel);
            break;
            case 38: //Aguja(escorpion): tiene un attack de veneno innato (el veneno ejecuta a la mascota enemiga sin importar cuánta vida tenga) 
            equipoDefensa[0][1] -= 1000;
            System.out.println("HABILIDAD INICIAL "+ nameattack) ;
            System.out.println("HA EJECUTADO A UN ENEMIGO AL AZAR");
            break;
            case 39: // Estampida(rinoceronte): Inflige 4/8/12 de daño al primer enemigo. 
            equipoDefensa[0][1] -= 4*nivel;
            System.out.println("HABILIDAD INICIAL "+ nameattack) ;
            System.out.println("HA HECHO "+ nivel*4 + " DE DAÑO AL PRIMER ENEMIGO");
            break;
            case 41:// Mordida(cocodrilo): (Comienzo de la batalla) inflige 8/16/24 de daño al último enemigo.  break;
            for(int f =4; f>=0; f--){
                if(equipoDefensa[f][0]!=0){
                    equipoDefensa[f][1] -= 8*nivel;
                }
            }
            System.out.println("HABILIDAD INICIAL "+ nameattack) ;
            System.out.println("HA HECHO "+ nivel*8 + " DE DAÑO AL ULTIMO ENEMIGO");
            case 49: //Zarpazo(leopardo): al iniciar la batalla inflige 50 % de daño ATQ a 1/2/3 enemigos aleatorios .
            for (int c = 1;c <= nivel;c++)
                {
                    int posdef = generarNumAleatorio(4, 0);
                    ataque = (equipoAtaque[posicionAtaque][2]/2);
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    if(equipoDefensa[posdef][0]==0 && posdef >0)
                    {
                        posdef--;
                    }
                    System.out.println("HABILIDAD INICIAL "+ nameattack);
                    ataque(posicionAtaque, posdef, ataque, turno);
                }
            break;
            case 53://  Habilidades por nivel(quetzal): (1) Agrega a su vida la suma de toda la vida de los animales tipos aves. (2) Hace lo del nivel 1 y agrega a su daño la suma de todo el daño del daño de todas las aves. (3) Hace lo del nivel 2 pero con todos los animales.  
            System.out.println("HABILIDAD INICIAL "+ nameattack);
            if(nivel==1){
                for(int f=0;f<5;f++){
                    if(equipoAtaque[f][0]!=53){
                        if(equipoAtaque[f][4]==2 | equipoAtaque[f][5]==2 || equipoAtaque[f][6]==2){
                            vAtaque += equipoAtaque[f][1];
                        }
                    }
                    if(equipoDefensa[f][4]==2 | equipoDefensa[f][5]==2 || equipoDefensa[f][6]==2){
                        vAtaque += equipoDefensa[f][1];
                    }
                }
                equipoAtaque[posicionAtaque][1] += vAtaque+vDefensa;
                System.out.println("Agrega a su vida la suma de toda la vida de los animales tipos aves.");
            }
            if(nivel==2){
                for(int f=0;f<5;f++){
                    if(equipoAtaque[f][0]!=53){
                        if(equipoAtaque[f][4]==2 | equipoAtaque[f][5]==2 || equipoAtaque[f][6]==2){
                            vAtaque += equipoAtaque[f][1];
                            ataqueA += equipoAtaque[f][2];
                        }
                    }
                    if(equipoDefensa[f][4]==2 | equipoDefensa[f][5]==2 || equipoDefensa[f][6]==2){
                        vAtaque += equipoDefensa[f][1];
                        ataqueD += equipoDefensa[f][2];
                    }
                }
                equipoAtaque[posicionAtaque][1] += vAtaque+vDefensa;
                equipoAtaque[posicionAtaque][2] += ataqueA+ataqueD;
                System.out.println("Agrega a su vida la suma de toda la vida de los animales tipos aves y la suma de todo el daño del daño de todas las aves.");
            }
            if(nivel==3){
                for(int f=0;f<5;f++){
                    if(equipoAtaque[f][0]!=53){
                        vAtaque += equipoAtaque[f][1];
                        ataqueD += equipoAtaque[f][2];
                    }
                        vAtaque += equipoDefensa[f][1];
                        ataqueD += equipoDefensa[f][2];
                }
                equipoAtaque[posicionAtaque][1] += vAtaque+vDefensa;
                equipoAtaque[posicionAtaque][2] += ataqueA+ataqueD;
                System.out.println("Agrega a su vida la suma de toda la vida y la suma de todo el daño de todos los animales");
            }
            
            case 54: // Habilidades por nivel(camaleon): (1) Copia la vida del enemigo más fuerte (2) Copia la vida y el daño del enemigo más fuerte  (3) Copia la vida, el daño y la habilidad del enemigo más fuerte break;
            break;

        }

    }

    public void ataque(int posatt, int posdef, int ataque, int turno)
    {
        boolean repeat = false;
        do{
            int codeatt = equipoAtaque[posatt][0], codedef = equipoDefensa[posdef][0];
            String nameatt= Object.getNombre(codeatt), namedef = Object.getNombre(codedef);
            int nivel =equipoDefensa[posdef][3];//exclusivo para panda
            
            if (codeatt == 44)
            {
                if(nivel ==1){
                ataque -= (ataque /2);
                System.out.println("PANDA REDUJO EL ATAQUE UN 50/100");
                }
                else if ( nivel == 2){
                ataque -= ( (3*ataque) /5);
                System.out.println("PANDA REDUJO EL ATAQUE UN 60/100");
                }
                else{
                ataque -=  ( (4*ataque) /5);
                System.out.println("PANDA REDUJO EL ATAQUE UN 80/100");
                }
            }

            
            if (codeatt == 50)
            {
                //ESCUDO DE COCO   
            }
            System.out.println(nameatt +"  HIZO  " +ataque+" DE DAÑO A "+ namedef);
            equipoDefensa [posdef][1] -= ataque;
            
            if (codeatt==30 && equipoDefensa [posdef][1] <=0)
            {
                nivel = equipoAtaque[posatt][3];
                nivel = nivel *2 ;
                equipoAtaque[posatt][1] += nivel;
                equipoAtaque[posatt][2] += nivel;
                System.out.println("HIPOPOTAMO HA DERRIBADO A "+namedef + " Y HA OBTENIDO "+ nivel +"/"+nivel);
            }
            if (codedef == 13)
            {
                equipoDefensa[posdef][2] += ataque /2;
                System.out.println("PAVOREAL HA GANADO 50/100 DE ATAQUE RECIBIDO");
            }
            
            if (posdef!=4)
            codedef = equipoDefensa[posdef+1][0];
            if (codedef == 37)
            {
                repeat = true;
                int mattemp[][] = equipoDefensa;
                equipoDefensa = equipoAtaque;
                equipoAtaque = mattemp;
                codedef = codeatt;
                codeatt = 37;
            }
            
        }while(repeat);
    }

    public void battack(int posatt)
    {

    }

    public void granturn (int turn)
    {
        if(turn==1)
        {
            for(int f=0;f<5;f++)
            {
                for(int c=0;c<10;c++)
                {
                    equipoAtaque[f][c]= t1r[f][c];
                    equipoDefensa[f][c]= t2r[f][c];
                }
            }
        }
        else
        {
            for(int f=0;f<5;f++)
            {
                for(int c=0;c<10;c++)
                {
                    equipoDefensa[f][c]= t1r[f][c];
                    equipoAtaque[f][c]= t2r[f][c];
                }
            }
        }
    }

    public void restoreturn (int turn)
    {
        if(turn==1)
        {
            for(int f=0;f<5;f++)
            {
                for(int c=0;c<10;c++)
                {
                    t1r[f][c] = equipoAtaque[f][c];
                    t2r[f][c] = equipoDefensa[f][c];
                }
            }
        }
        else
        {
            for(int f=0;f<5;f++)
            {
                for(int c=0;c<10;c++)
                {
                    t1r[f][c] = equipoDefensa[f][c];
                    t2r[f][c] = equipoAtaque[f][c];
                }
            }
        }
    }

    public int generarNumAleatorio(int max, int min)
    {
        return random.nextInt(max-(min-1))+1+(min-1);
    }
}
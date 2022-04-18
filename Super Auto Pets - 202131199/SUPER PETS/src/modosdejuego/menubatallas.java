package modosdejuego;
import recursos.*;
import java.util.Random;
import java.util.Scanner;
public class menubatallas {
    Scanner in =new Scanner(System.in);
    Random random = new Random();
    objetos Objeto = new objetos();
    int oro=10, ronda=0, opcion = 1;
    int [] mascotas1 = {0,0,0,0,0};
    boolean back,foodon = false;
    public int [][] irAMenu(int [][] matriz,int round)
    {
        oro=10;
        ronda=round;//convertir en global
        mascotas1 = generarMascota();
        do
        {
            System.out.println(" ORO = " + oro);
            System.out.println("-------------- M E N U  D E  B A T A L L A ---------------");
            System.out.println("1)......................... C O M P R A R  M A S C O T A S");
            System.out.println("2)..............................C O M P R A R  C O M I D A");
            System.out.println("3)......................... O R D E N A R  M A S C O T A S");
            System.out.println("4)............................... U N I R  M A S C O T A S");
            System.out.println("5)........................... V E N D E R  M A S C O T A S");
            System.out.println("6).......................................... B A T A L L A");
            opcion = in.nextInt();
            in.nextLine();
            switch(opcion)
            {
                case 1:  matriz = elegirMascotas(matriz); break;
                case 2:  elegirComida(); break;
                case 3:  matriz = ordenarMascotas(matriz); break;
                case 4:  matriz = unirMascotas(matriz);break;
                case 5:  matriz = venderMascotas(matriz); break;
                case 6:  
                        if(oro>0)
                        {
                            System.out.println("------------ AUN TIENES ORO ----------"); 
                            System.out.println("PRESIONA LA OPCION 6  DE NUEVO PARA IR A LA BATALLA" ); 
                            opcion = in.nextInt();
                            if (opcion==6)
                            System.out.println("------------------- FUEGO ------------------------------");
                            else 
                            System.out.println("----------- INGRESE UNA NUEVA OPCION  ------------");
                        }
                        else
                            System.out.println("------------------- FUEGO ------------------------------");
                        break;
                default:    System.out.println("-- ESTA OPCION NO ESTA DISPONIBLE --"); break;
            }
        }while (opcion != 6);
        
        return matriz;
    }
    public int [][] venderMascotas(int [][] matriz)
    {
        int pet,conpet=0;
        for(int a = 0;a<5;a++)
        if(matriz[a][0]!=0)
        conpet++;
        verEquipo(matriz,true);
        System.out.println("------- INGRESE MASCOTA ----- ");
        pet= in.nextInt();
        pet--;
        if(pet>=0 && pet< conpet)
        {
            oro +=  matriz[pet][3];
            for (int a =0;a<10;a++)
            matriz[pet][a] = 0;
            matriz = ordenEquipo(matriz);

            verEquipo(matriz,true);
        }
        else
        System.out.println(" POSICION INVALIDA ");
        return matriz;
    }
    public int [][] ordenEquipo (int [][] matriz)
    {
        int f=0;
        while(f<4)
        {
            if (matriz[f][0]==0)
            {
                for (int a =0;a<10;a++)
                {
                    matriz[f][a] = matriz[f+1][a];
                    matriz[f+1][a]=0;
                }

            }
            f++;
        }

        return matriz;
    }
    public int [][] unirMascotas(int matriz[][])
    {
        boolean fus=false;
        verEquipo(matriz,true);
        int a1,a2,conMasc=0;
        for(int a = 0;a<5;a++)
        if(matriz[a][0]!=0)
        conMasc++;
        System.out.println("INGRESE LA PRIMER MASCOTA");
        a1= in.nextInt();
        System.out.println("INGRESE LA SEGUNDA MASCOTA ");
        a2= in.nextInt();
        a1--;
        a2--;
        if((a1>=0 && a1 < conMasc) && (a2>=0 && a2 < conMasc))
        {
            if( (matriz[a1][4]!=0) && ( (matriz[a1][4]==matriz[a2][4]) || (matriz[a1][4]==matriz[a2][5]) || (matriz[a1][4]==matriz[a2][6])) )
            fus=true;
            else if( (matriz[a1][5]!=0) && ((matriz[a1][5]==matriz[a2][5]) || (matriz[a1][5]==matriz[a2][6])) )
            fus=true;
            else if( (matriz[a1][6]!=0) && (matriz[a1][6]==matriz[a2][6]))
            fus= true;
            else
            System.out.println("\n ---- UNIDOS XD ----");
            
            
            if(fus)
            {
                matriz[a1][1] += 1;
                matriz[a1][2] += 1;
                matriz[a1][7] += 1; 
                matriz[a1][9] += matriz[a2][9];
            
                matriz[a2][0] =0;
                matriz[a2][1] =0;
                matriz[a2][2] =0;
                matriz[a2][3] =0;
                matriz[a2][4] =0;
                matriz[a2][5] =0;
                matriz[a2][6] =0;
                matriz[a2][7] =0;
                matriz[a2][8] =0;
                matriz[a2][9] =0;
            
                if(matriz[a1][7]>=5)
                {

                    matriz[a1][3]=3;
                }
                else if(matriz[a1][7]>=2)
                {
                    matriz[a1][3]=2;
                }
            
            }
            ordenEquipo(matriz);
            verEquipo(matriz,true);
            }
        else
        {
            System.out.println(" POSICION INVALIDA ");
            
        }
        
        
        return matriz;
    }
    public int [][] elegirMascotas(int [][] matriz)
    {
        int codepet,codearray;
        
        do
        {
            back = false;
            ordenArreglo();
            for (int c=0;c<5;c++)
            {
                if (mascotas1[c]!=0)
                back=true;
            }
            if (back)
            {
                verMascota(mascotas1);
                System.out.println("----------  Ingrese el codigo de la mascota para agregarlo al equipo -------");
                System.out.println("---- Ingrese 0 para regresar al menu anterior----");
                codearray = in.nextInt();
                in.nextLine();
                codearray--;
                if (codearray>=0&&codearray<=4)
                {
                    if (mascotas1[codearray]!=0)
                    {
                        codepet = mascotas1[codearray];
                        matriz = agregarMascota(matriz, codepet,codearray,true);
                        verEquipo(matriz,true);
                        
                    }
                    else{
                        System.out.println("---------- LA MASCOTA NO FUE ENCONTRADA ---------");
                    }
                }
                else if(codearray<0)
                {
                    back=false;
                }
                else
                {
                    System.out.println("---------- LA MASCOTA NO FUE ENCONTRADA ---------");
                }
            }
            else{
                System.out.println("\n----------------------------------------------------------");
                System.out.println("------------- NINGUNA MASCOTA DISPONIBLE ------------");
                System.out.println("----------------------------------------------------------\n");
            }
            
        }while ((oro>0) && (back));
        return matriz;
    }
    public void verEquipo (int matriz[][],boolean team)
    {
        if(team)
        {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("------------------ TU EQUIPO ES -----------------");
            System.out.println("----------------------------------------------------------\n");
        }
        else{
            System.out.println("\n----------------------------------------------------------");
            System.out.println("--------------- EL EQUIPO DE TU OPONENTE ES --------------");
            System.out.println("----------------------------------------------------------\n");
        }
        for (int c=0;c<5;c++)
        {
            if (matriz[c][0]!=0)
            {
                verDatosE(matriz[c][0], c,matriz[c][9],matriz[c][1],matriz[c][2],matriz[c][3],false);
            }
        }
        System.out.println("\n----------------------------------------------------------"); 
        System.out.println("----------------------------------------------------------\n");
    }
    public void verMascota(int pets [])
    {
        System.out.println("---------------- MASCOTAS DISPONIBLES --------------");
        for (int cont = 0; cont <5; cont++)
        {
            if (pets[cont] != 0)
            {
                verDatosE(pets[cont],cont,0,0,0,0,true);
            }
        }

    }
    public void verDatosE(int codigo, int num, int exp, int life, int att, int level, boolean pet)
    {
        int Ndates [] = Objeto.getNdates(codigo);//{getDefensa(), getAtaque(), getVida()};
        String Sdates [] = Objeto.getSdates(codigo);//{getNombre(),getTipo1(),getTipo2(),getTipo3()};
        num++;
        if (pet)
        {
            System.out.println("No.   Nombre     Ataque    VIDA  EXP   TIPO1     TIPO2     TIPO3");
            System.out.println(num+ "  " +Sdates[0] + "      " + Ndates[1] + "         " + Ndates[2] + "   " +exp +"   "+ Sdates[1] + " " + Sdates[2] + " " + Sdates[3]);
        }
        else
        {
            System.out.println("No.   Nombre     Ataque    VIDA  EXP   TIPO1     TIPO2     TIPO3");
            System.out.println(num+ "  " +Sdates[0] + "      " + att+ "         " + life + "   " +exp +"   "+ Sdates[1] + " " + Sdates[2] + " " + Sdates[3]);
        }
    }
    public int [][] agregarMascota(int matriz [][], int codepet, int codearray,boolean team)
    {
         boolean exito = false;
        if (team)
        {
           
            if (oro>=2)
            {
                for (int f=0;f<5;f++)
                {
                    if (matriz[f][0]==0 && exito==false)
                    {//{getDefensa(), getAtaque(), getVida()}; {getNombre(),getTipo1(),getTipo2(),getTipo3()};
                        int []Ndates = Objeto.getNdates(codepet);
                        String []Sdates = Objeto.getSdates(codepet);
                        matriz[f][0]= codepet;
                        matriz[f][1] = Ndates [2];
                        matriz[f][2] = Ndates [1];
                        matriz[f][3] = 1;
                        matriz[f][4] = convertir(Sdates[1]);
                        matriz[f][5] = convertir(Sdates[2]);
                        matriz[f][6] = convertir(Sdates[3]);
                        matriz[f][7] = 1; 
                        matriz[f][8] = 0;
                        matriz[f][9] = 0;
                        /*if (foodon)
                        sumar*/
                        oro-=2;
                        mascotas1[codearray]=0;
                        exito=true;
                    }
                }
            }
            else
            {
                System.out.println("\n------------- EL ORO ES ESCAZO-----------");
                back = false;
            }
            if(!exito)
            {
                System.out.println("\n- NO SE PUEDEN AGREGAR MAS MASCOTAS -");
                back = false;
            }
        }
        else{
            for (int f=0;f<5;f++)
                {
                    if (matriz[f][0]==0 && !exito)
                    {//{getDefensa(), getAtaque(), getVida()}; {getNombre(),getTipo1(),getTipo2(),getTipo3()};
                        int []Ndates = Objeto.getNdates(codepet);
                        String []Sdates = Objeto.getSdates(codepet);
                        matriz[f][0]= codepet;
                        matriz[f][1] = Ndates [2];
                        matriz[f][2] = Ndates [1];
                        matriz[f][3] = 1;
                        matriz[f][4] = convertir(Sdates[1]);
                        matriz[f][5] = convertir(Sdates[2]);
                        matriz[f][6] = convertir(Sdates[3]);
                        matriz[f][7] = 1; 
                        matriz[f][8] = 0;
                        matriz[f][9] = 0;
                        /*if (foodon)
                        sumar*/
                        mascotas1[0]=0;
                        exito=true;
                    }
                }
        }
        return matriz;
    } 
    public void ordenArreglo()
    {
        int f=0;
        while(f<4)
        {
            if (mascotas1[f]==0)
            {
                mascotas1[f] = mascotas1[f+1];
                mascotas1[f+1]=0;
            }
            f++;
        }
    }
    public int convertir (String ty)
    {
        int n=0;
        switch(ty)
        {
        case "Insecto" :   n=1; break;
        case "Volador" :   n=2; break;
        case "Acuatico" :   n=3; break;
        case "Terrestre" :   n=4; break;
        case "Reptil" :   n=5; break;
        case "Mamifero" :   n=6; break;
        case "Domestico" :   n=7; break;
        case "Solitario" :   n=8; break;
        case "Desertico" :   n=9; break;
        default: n=0; break;
        }

        return n;
    }
    public void elegirComida()
    {

    }
    public int [][] ordenarMascotas(int matriz[][])
    {
        int [][] matriz2 = new int [5][10];
        verEquipo(matriz,true);
        int [] posicion=new int [5];
        int numP,contMasc=0,error=0;
        for(int a = 0;a<5;a++)
        if(matriz[a][0]!=0)
        contMasc++;

        for (int f =0;f<contMasc ; f++)
        {   
            System.out.println("---- INGRESE NUEVA POSICION DE MASCOTA "+ (f+1)+ " ---");
            numP = in.nextInt();
            numP--;
            if(numP>=0 && numP < contMasc)
            {
                error=0;
                if(f!=0)
                {
                    for(int fr = f;fr>0;fr--)
                    {
                        if(numP==posicion[fr-1])
                        {
                            error++;
                        }
                    }
                    if(error==0)
                    {
                        posicion[f]=numP;
                    }
                    else
                    {
                        System.out.println("------------ POSICION DUPLICADA ----------");
                        f--;
                    }
                }
                else
                {
                    posicion[f]=numP;
                }
            }
            else
            {
                System.out.println("------------ POSICION INVALIDA --------------");
                f--;
            }
        }
        matriz2 = cambiarOrden(matriz, matriz2, posicion, contMasc);
        verEquipo(matriz2,true);
        return matriz2;
    }
    public int [][] cambiarOrden(int [][] matriz1, int [][]matriz2,int order[],int cantmasc)
    {
        for (int f=0;f<cantmasc;f++)
        {
            matriz2[order[f]][0]=matriz1[f][0];
            matriz2[order[f]][1]=matriz1[f][1];
            matriz2[order[f]][2]=matriz1[f][2];
            matriz2[order[f]][3]=matriz1[f][3];
            matriz2[order[f]][4]=matriz1[f][4];
            matriz2[order[f]][5]=matriz1[f][5];
            matriz2[order[f]][6]=matriz1[f][6];
            matriz2[order[f]][7]=matriz1[f][7];
            matriz2[order[f]][8]=matriz1[f][8];
            matriz2[order[f]][9]=matriz1[f][9];

        }

        return matriz2;
    }
    public int [][] generarOp(int [][]matriz,int round) 
    {
        ronda=round;
        int matrizop[][] = new int[5][10];
        int petres[]={0,0,0,0,0};
        int conpet = 0;
        for(int a = 0;a<5;a++)
        {
            matrizop[a][0]=0;
            if(matriz[a][0]!=0)
            conpet++;
        }
        mascotas1 = generarMascota();
        petres = generarMascota();
        mascotas1 [3] = petres [1];
        mascotas1 [4] = petres [2];
        if (conpet==5)
        conpet--;
        for(int f = 0;f<=conpet;f++) 
        {
            ordenArreglo();
            int codepet = mascotas1[0];
            matrizop = agregarMascota(matrizop, codepet, 0, false);
        }
        return matrizop;
    }
    public int [] generarMascota()
    {
        int n1=0,n2=0,n3=0,n4=0,n5=0;
        switch(ronda)
        {
            case 1,2,3:
                if (ronda==1)//tier 1
                {
                    n1=random.nextInt(8-1)+1;
                    n2=random.nextInt(8-1)+1;
                    n3=random.nextInt(8-1)+1;
                }
                else{//tier2
                    n1=random.nextInt(16-1)+1;
                    n2=random.nextInt(16-1)+1;
                    n3=random.nextInt(16-1)+1;
                }
                break;
            case 4,5,6://4animales, 4 y 5 tier 3, 6 tier 4 
                if (ronda==6) //tier 4
                {
                    n1=random.nextInt(35-20)+20;
                    n2=random.nextInt(35-20)+20;
                    n3=random.nextInt(35-20)+20;
                    n4=random.nextInt(35-20)+20;
                }
                else{//tier 3
                    n1=random.nextInt(27-1)+1;
                    n2=random.nextInt(27-1)+1;
                    n3=random.nextInt(27-1)+1;
                    n4=random.nextInt(27-1)+1;
                }
                break;
            case 7:
            default : //5animales
                if (ronda==7)//tierr 4
                {
                    n1=random.nextInt(35-20)+20;
                    n2=random.nextInt(35-20)+20;
                    n3=random.nextInt(35-20)+20;
                    n4=random.nextInt(35-20)+20;
                    n5=random.nextInt(35-20)+20;
                }
                else if(ronda <=9)//tier 5
                {
                    n1=random.nextInt(43-30)+30;
                    n2=random.nextInt(43-30)+30;
                    n3=random.nextInt(43-30)+30;
                    n4=random.nextInt(43-30)+30;
                    n5=random.nextInt(43-30)+30;
                }
                else if (ronda<=11)//tier 6
                {
                    n1=random.nextInt(52-40)+40;
                    n2=random.nextInt(52-40)+40;
                    n3=random.nextInt(52-40)+40;
                    n4=random.nextInt(52-40)+40;
                    n5=random.nextInt(52-40)+40;
                }
                else //tier 7
                {
                    n1=random.nextInt(54-1)+1;
                    n2=random.nextInt(54-1)+1;
                    n3=random.nextInt(54-1)+1;
                    n4=random.nextInt(54-1)+1;
                    n5=random.nextInt(54-1)+1;
                }
            
        }

        return new int [] {n1,n2,n3,n4,n5};
    }
    public int [] generarComida()
    {
        int n1=0,n2=0;
        switch(ronda)
        {
            case 1,2,3:
                if (ronda==1)//tier 1
                {
                    n1=in.nextInt(3-1)+1;
                    n2=in.nextInt(3-1)+1;
                }
                else{//tier2
                    n1=in.nextInt(6-1)+1;
                    n2=in.nextInt(6-1)+1;
                }
                break;
            case 4,5,6:
                if (ronda==6) //tier 4
                {
                    n1=in.nextInt(13-1)+1;
                    n2=in.nextInt(13-1)+1;
                }
                else{//tier 3
                    n1=in.nextInt(10-1)+1;
                    n2=in.nextInt(10-1)+1;
                }
                break;
            case 7:
            default:
                if (ronda==7)//tierr 4
                {
                    n1=in.nextInt(13-1)+1;
                    n2=in.nextInt(13-1)+1;
                }
                else if(ronda <=9)//tier 5
                {
                    n1=in.nextInt(15-1)+1;
                    n2=in.nextInt(15-1)+1;
                }
                else if (ronda<=11)//tier 6
                {
                    n1=in.nextInt(17-1)+1;
                    n2=in.nextInt(17-1)+1;
                }
                else //tier 7
                {
                    n1=in.nextInt(18-1)+1;
                    n2=in.nextInt(18-1)+1;
                }
            
        }

        return new int [] {n1,n2};
    }
}
 
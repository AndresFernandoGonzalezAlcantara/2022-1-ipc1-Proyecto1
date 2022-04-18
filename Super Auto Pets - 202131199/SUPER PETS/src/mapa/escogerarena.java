package mapa;
import java.util.Scanner;
import modosdejuego.*;
public class escogerarena{
    public void elegirArena(String nombre, int codigo){

        //RECIBIREMOS EL TIPO DE MODO
        int numero;
        modoarena arena = new modoarena();
        modoversus versus = new modoversus();
        modocreativo creative = new modocreativo();
        Scanner scanner1 = new Scanner(System.in);
        boolean error = false;

        do{
        System.out.println("Jugador: "+ nombre ); //SALUDOS JEJE
        System.out.println("\n-----------------------------------------------------");
        System.out.println("                 Arena de Batallas                   ");
        System.out.println("-----------------------------------------------------");
        System.out.println("1) Pantano");
        System.out.println("2) Nubes ");
        System.out.println("3) Mar ");
        System.out.println("4) Bosque ");
        System.out.println("5) Granja ");
        System.out.println("6) (sin campo)");
        System.out.println("7) Sabana ");
        System.out.println("8) Salir ");
        System.out.println("---------------Escoja el numero de mapa----------------");
        numero = scanner1.nextInt();
        scanner1.nextLine();

        switch(numero){            
            case 1:
                System.out.println("Bienvenido a Arena Pantano");
                break;
            case 2:
                System.out.println("Bienvenido a Arena Nubes");
                break;
            case 3:
                System.out.println("Bienvenido a Arena Mar");
                break;
            case 4:
                System.out.println("Bienvenido a Arena Bosque");
                break;
            case 5:
                System.out.println("Bienvenido a Arena Granja");
                break;
            case 6:
                System.out.println("Bienvenido a Arena sin Campo");
                break;
            case 7:
                System.out.println("Bienvenido a Arena Sabana");
                break;
            case 8:
            System.out.println("Volviendo al menu principal");
            error = false;
            break;
            default:
                System.out.println("Este mapa no existe");
                error = true;
            break;
        }
        
    }while(error);
        if(numero !=8)
            {
                //leer tipo batalla
                //iniciar Switch
                // case 1 ir modo arena
                // case 2 ir modo versus
                switch(codigo){
                    case 1:
                        arena.inicio(numero);
                        break;
                    case 2:
                        versus.inicio();
                        break;
                    case 3:
                        creative.inicio();
                        break;
                }

            }
        }
}


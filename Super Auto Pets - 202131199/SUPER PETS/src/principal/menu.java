package principal;
import java.util.Scanner;
import mapa.*;
import recursos.*;
public class menu {
    public static void main(String[] args) throws Exception {    

        escogerarena tipoar = new escogerarena();
        int opcion;
        String nombre;
        Scanner scan = new Scanner(System.in);
        boolean hayerror = false;
        System.out.println("\nIngrese su nombre: ");
        nombre = scan.nextLine();

        do{
        System.out.println("\n----------------------------------------------------------");
        System.out.println("|   <3    S  U  P  E  R    A  U  T  O    P  E  T  S    <3  |");
        System.out.println("------------------------------------------------------------");
        System.out.println("\n------------------- Escoja una opcion : ------------------");
        System.out.println("1) ..................................... M O D O  A R E N A ");
        System.out.println("2) ................................... M O D O  V E R S U S ");
        System.out.println("3) ............................... M O D O  C R E A T I V O ");
        System.out.println("4) ........................................ R E P O R T E S ");
        System.out.println("5) ............................ S A L I R  D E L  J U E G O ");
        System.out.println("\n--------------- Ingrese una opcion --------------");
        opcion = scan.nextInt();
        scan.nextLine();

        switch(opcion){
            case 1:
                tipoar.elegirArena(nombre, opcion);
                //mandar tipo batalla a ARENA 
                hayerror = true;
            break;
            case 2:
                tipoar.elegirArena(nombre, opcion);
                hayerror = true;
            break;
            case 3:
                tipoar.elegirArena(nombre, opcion);
                hayerror = true;
            break;
            case 4:
                System.out.println("---------REPORTES---------");
                hayerror = true;
            break;
            case 5:
                System.out.println("Saliendo del juego. Esperamos su pronto regreso a esta aventura");
                hayerror = false;
            break;
            default:
                System.out.println("Esta opcion no existe. Por favor ingrese una opcion valida");
                hayerror = true;
            break;
        }
    }while(hayerror);
}
}

  
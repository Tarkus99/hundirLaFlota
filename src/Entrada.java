import java.util.Scanner;
public class Entrada {
    public static String entradaTexto() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
    public static int entradaInt() {
        int input;
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Eso no es un número entero...");
            sc.next();
        }
        input = sc.nextInt();
        return input;
    }

    public static void enter(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void limpiar(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

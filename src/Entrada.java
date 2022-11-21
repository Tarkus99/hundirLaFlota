import java.util.Scanner;
public class Entrada {
    public static String entradaTexto() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
    public static int entradaInt() {
        /*boolean isInt= false;*/
        int input = 0;
        Scanner sc = new Scanner(System.in);
        /*do {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isInt = true;
            } else {
                System.out.println("Eso no es un número entero...");
                sc.next();
            }
        } while (!isInt);*/
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
}

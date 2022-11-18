import java.util.Scanner;

public class CoordenadasPlayer {
    public static int[] coordenadasPlayer(int[] barcos, int indice, String message) {

        int[] cordNum = new int[2];

        Scanner sc = new Scanner(System.in);

        String input;

        int longitudInput;
        int cordX;
        int cordY;
        boolean formato = false;
        boolean bounds = false;

        do {
            do {
                System.out.println(message);
                input = Entrada.entrada();
                longitudInput = input.length();

                if (longitudInput!=2) {
                    System.out.println("Incorrect format");
                }else if (Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1)) && longitudInput==2){
                    formato = true;
                }else{
                    System.out.println("Incorrect format");
                }
            } while (!formato); //primero determino que el formato sea correcto

                cordY = (Character.toLowerCase(input.charAt(0))) - 'a';
                cordX = Character.getNumericValue(input.charAt(1));


            if (cordY >= 0 && cordY <= 9 && cordX >= 0 && cordX <= 9) {
                bounds = true;
            }else {
                System.out.println("Coordinates out of bounds");
                formato = false;
            }

        } while (!bounds); //luego que la coordenada esté dentro del tablero

        return new int[]{cordY,cordX};
    }
}
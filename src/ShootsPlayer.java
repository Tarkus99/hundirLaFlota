import java.util.Scanner;

public class ShootsPlayer {
    public static int[] shootsPlayer(int[] barcos, int indice) {

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
                System.out.println("Enter a coordinate to shoot as follows [A9]");
                input = sc.nextLine();
                longitudInput = input.length();

                if (longitudInput!=2) {
                    System.out.println("Incorrect format");
                }else if (Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1)) && longitudInput==2){
                    formato = true;
                }else{
                    System.out.println("Incorrect format");
                }
            } while (!formato);

            cordY = (input.charAt(0)) - 'a';
            cordX = Character.getNumericValue(input.charAt(1));


            if (cordY >= 0 && cordY <= 9 && cordX >= 0 && cordX <= 9) {
                bounds = true;
            }else {
                System.out.println("Coordinates out of bounds");
                formato = false;
            }

        } while (!bounds);

        return new int[]{cordY,cordX};
    }
}
import java.util.Scanner;

public class ShootsPlayer {
    public static boolean shootsPlayer(char[][] tableroPC, char[][] disparosPlayer, int shoots) {

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
                System.out.println(Messages.shoot());
                input = sc.nextLine();
                longitudInput = input.length();

                if (longitudInput != 2) {
                    System.out.println("Incorrect format");
                } else if (Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1)) && longitudInput == 2) {
                    formato = true;
                } else {
                    System.out.println("Incorrect format");
                }
            } while (!formato);

            cordY = Character.toLowerCase(input.charAt(0)) - 'a';
            cordX = Character.getNumericValue(input.charAt(1));


            if (cordY >= 0 && cordY <= 9 && cordX >= 0 && cordX <= 9) {
                bounds = true;
            } else {
                System.out.println("Coordinates out of bounds");
                formato = false;
            }

            if (tableroPC[cordY][cordX] == 'B' && disparosPlayer[cordY][cordX] == 'X') {
                System.out.println("You've already hit that position");
                bounds = false;
            }

        } while (!bounds);


         if (tableroPC[cordY][cordX] == 'B') {
            System.out.println("YOU HIT A SHIP" + "\n");
            disparosPlayer[cordY][cordX] = 'H';
            tableroPC[cordY][cordX] = 'X';
            return true;
        } else {
            System.out.println("There's no ship on that coordinate" + "\n");
            disparosPlayer[cordY][cordX] = 'W';
            return false;
        }
    }
}
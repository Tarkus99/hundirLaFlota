public class ShootPC {
    public static boolean shoot(char[][] tableroPlayer, char[][] disparosPC) {
        int cordY;
        int cordX;
        char letra = ' ';

        cordY = random.random();
        cordX = random.random();

        switch (cordY) {
            case 0:
                letra = 'A';
                break;
            case 1:
                letra = 'B';
                break;
            case 2:
                letra = 'C';
                break;
            case 3:
                letra = 'D';
                break;
            case 4:
                letra = 'E';
                break;
            case 5:
                letra = 'F';
                break;
            case 6:
                letra = 'G';
                break;
            case 7:
                letra = 'H';
                break;
            case 8:
                letra = 'I';
                break;
            case 9:
                letra = 'J';
                break;
        }

        System.out.println("The opponent shooted " + letra + "" + cordX + ".");

        if (tableroPlayer[cordY][cordX] == 'B') {
            System.out.println(ANSI_RED + "You've been hit" + "\n");
            disparosPC[cordY][cordX] = 'H';
            tableroPlayer[cordY][cordX] = 'X';
            return true;
        } else {
            System.out.println("The opponent hit water" + "\n");
            disparosPC[cordY][cordX] = 'W';
            return false;
        }
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}

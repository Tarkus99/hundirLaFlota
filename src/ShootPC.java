public class ShootPC {
    public static boolean shoot(char[][] tableroPlayer, char[][] disparosPC, int cordY, int cordX) {
        char letra = (char)('A' + cordY);

        System.out.println("Tu oponente disparó " + letra + "" + cordX + ".");

        if (tableroPlayer[cordY][cordX] == 'B') {
            System.out.println(ANSI_RED + "¡TE HAN TOCADO UN BARCO!" + ANSI_RESET + "\n");
            disparosPC[cordY][cordX] = 'H';
            tableroPlayer[cordY][cordX] = 'X';
            return true;
        } else {
            System.out.println("El oponente disparó al agua" + "\n");
            disparosPC[cordY][cordX] = 'W';

            return false;
        }
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}

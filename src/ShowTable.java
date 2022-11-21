public class ShowTable {
    public static void showTable(char[][] tableroPlayer, char[][] disparosPlayer, char[][] tableroPC, char[][] disparosPC,
                                 int puntuacion, int aciertosPlayer, int aciertosPC, boolean verTablero) {

        char letra = 'A';
        System.out.println("\t\t\t\t" + "PUNTUACIÓN PARA GANAR: " + puntuacion + " puntos.");
        System.out.println("PUNTUACIÓN DEL JUGADOR:" + aciertosPlayer);
        System.out.println("FLOTA DEL JUGADOR" + "\t\t\t\t\t\t" + "DISPAROS DEL JUGADOR");

        for (int y = 0; y < tableroPlayer.length; y++) {
            System.out.print(ANSI_YELLOW + letra + "  ");
            for (int x = 0; x < tableroPlayer.length; x++) {
                if (tableroPlayer[y][x] == 'B') System.out.print(ANSI_RESET + tableroPlayer[y][x] + "  ");
                else if (tableroPlayer[y][x] == 'X') System.out.print(ANSI_RED + tableroPlayer[y][x] + "  ");
                else System.out.print(ANSI_BLUE + tableroPlayer[y][x] + "  " + ANSI_RESET);
            }

            System.out.print("\t\t\t");
            System.out.print(ANSI_YELLOW + letra + "  " + ANSI_RESET);
            for (int x = 0; x < disparosPlayer.length; x++) {
                if (disparosPlayer[y][x] == 'H') System.out.print(ANSI_GREEN + disparosPlayer[y][x] + "  ");
                else if (disparosPlayer[y][x] == 'W') System.out.print(ANSI_RESET + disparosPlayer[y][x] + "  ");
                else System.out.print(ANSI_BLUE + disparosPlayer[y][x] + "  " + ANSI_RESET);
            }
            letra++;
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 10; j++) {
                if (j == -1)
                    System.out.print("   ");
                else
                    System.out.print(ANSI_YELLOW + j + "  " + ANSI_RESET);
            }
            System.out.print("\t\t\t");
        }
        System.out.println("\n\n");

        if (verTablero) {
            letra = 'A';
            System.out.println("PUNTUACIÓN DEL PC:" + aciertosPC);
            System.out.println("FLOTA DEL PC" + "\t\t\t\t\t\t\t" + "DISPAROS DEL PC");

            for (int y = 0; y < tableroPC.length; y++) {

                System.out.print(ANSI_YELLOW + letra + "  " + ANSI_RESET);
                for (int x = 0; x < tableroPC[0].length; x++) {
                    if (tableroPC[y][x] == 'B') System.out.print(ANSI_RESET + tableroPC[y][x] + "  ");
                    else if (tableroPC[y][x] == 'X') System.out.print(ANSI_RED + tableroPC[y][x] + "  " + ANSI_RESET);
                    else System.out.print(ANSI_BLUE + tableroPC[y][x] + "  " + ANSI_RESET);
                }

                System.out.print("\t\t\t");
                System.out.print(ANSI_YELLOW + letra + "  " + ANSI_RESET);
                for (int x = 0; x < disparosPC.length; x++) {
                    if (disparosPC[y][x] == 'H') System.out.print(ANSI_GREEN + disparosPC[y][x] + "  " + ANSI_RESET);
                    else if (disparosPC[y][x] == 'W') System.out.print(ANSI_RESET + disparosPC[y][x] + "  " + ANSI_RESET);
                    else System.out.print(ANSI_BLUE + disparosPC[y][x] + "  " + ANSI_RESET);
                }
                letra++;
                System.out.println();
            }
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j < 10; j++) {
                    if (j == -1) System.out.print("   ");
                    else System.out.print(ANSI_YELLOW + j + "  " + ANSI_RESET);
                }
                System.out.print("\t\t\t");
            }
            System.out.println("\n" + "\n");
        }else{
            System.out.println("PUNTUACIÓN DEL PC:" + aciertosPC + "\n");
        }
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[96m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
}

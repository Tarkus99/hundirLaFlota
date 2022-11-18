import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class ShowTable {
    public static void showTable(char[][] tableroPlayer, char[][] disparosPlayer, char[][] tableroPC, char[][] disparosPC) {

        char letra = 'A';
        for (int y = 0; y < tableroPlayer.length; y++) {
            System.out.print("TABLERO DEL JUGADOR" + "\t\t\t" + "DISPAROS DEL JUGADOR");
            System.out.print(colorize(letra + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
            for (int x = 0; x < tableroPlayer.length; x++) {
                if (tableroPlayer[y][x] == 'B') System.out.print(ANSI_RESET + tableroPlayer[y][x] + "  ");
                else if (tableroPlayer[y][x] == 'X') System.out.println(ANSI_RED + tableroPlayer[y][x]);
                else System.out.print(ANSI_BLUE + tableroPlayer[y][x] + "  ");
            }

        System.out.print("\t\t\t");
        System.out.print(colorize(letra + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
        for (int x = 0; x < disparosPlayer.length; x++) {
            if (disparosPlayer[y][x] == 'H') System.out.print(ANSI_GREEN + disparosPlayer[y][x] + "  ");
             else if (disparosPlayer[y][x] == 'W') System.out.print(ANSI_RESET + disparosPlayer[y][x] + "  ");
             else  System.out.print(ANSI_BLUE + disparosPlayer[y][x] + "  ");
            }
        letra++;
        System.out.println();
    }
        for(int i = 0;i< 2;i++){
        for (int j = -1; j < 10; j++) {
            if (j == -1)
                System.out.print("   ");
            else
                System.out.print(colorize(j + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
        }
        System.out.print("\t\t\t");
    }
        System.out.println("\n"+"\n");
        letra ='A';
        for(int y = 0;y<tableroPC.length;y++){
        System.out.print(colorize(letra + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
        for (int x = 0; x < tableroPC.length; x++) {
            if (tableroPC[y][x] == 'B') System.out.print(ANSI_RESET + tableroPC[y][x] + "  ");
            else if (tableroPC[y][x] == 'X') System.out.println(ANSI_RED + tableroPC[y][x] + "  ");
            else System.out.print(ANSI_BLUE + tableroPC[y][x] + "  ");
            }

        System.out.print("\t\t\t");
        System.out.print(colorize(letra + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
        for (int x = 0; x < disparosPC.length; x++) {
            if (disparosPC[y][x] == 'H') System.out.print(ANSI_GREEN + disparosPC[y][x] + "  ");
             else if (disparosPC[y][x] == 'W') System.out.print(ANSI_RESET + disparosPC[y][x] + "  ");
             else System.out.print(ANSI_BLUE + disparosPC[y][x] + "  ");
        }
        letra++;
        System.out.println();
    }
        for(int i = 0;i< 2;i++){
            for (int j = -1; j < 10; j++) {
                if (j == -1) System.out.print("   ");
                else System.out.print(colorize(j + "  ", Attribute.TEXT_COLOR(232, 238, 22)));
            }
        System.out.print("        ");
    }
        System.out.println(ANSI_RESET +"\n"+"\n");
}

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
}

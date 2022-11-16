public class ShowTable {
    public static void showTable(char[][] tableroPlayer, char[][] disparosPlayer, char[][] tableroPC, char[][] disparosPC) {

        char letra = 'A';
        for (int y = 0; y < tableroPlayer.length; y++) {

            System.out.print(letra + "  ");
            for (int x = 0; x < tableroPlayer.length; x++) {
                System.out.print(tableroPlayer[y][x] + "  ");
            }
            System.out.print("        ");
            System.out.print(letra + "  ");
            for (int x = 0; x < disparosPlayer.length; x++) {
                System.out.print(disparosPlayer[y][x] + "  ");
            }
            letra++;
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 10; j++) {
                if (j == -1)
                    System.out.print("   ");
                else
                    System.out.print(j + "  ");
            }
            System.out.print("        ");
        }
        System.out.println("\n" + "\n");


        letra = 'A';
        for (int y = 0; y < tableroPC.length; y++) {

            System.out.print(letra + "  ");
            for (int x = 0; x < tableroPC.length; x++) {
                System.out.print(tableroPC[y][x] + "  ");
            }
            System.out.print("        ");
            System.out.print(letra + "  ");
            for (int x = 0; x < disparosPC.length; x++) {
                System.out.print(disparosPC[y][x] + "  ");
            }
            letra++;
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 10; j++) {
                if (j == -1)
                    System.out.print("   ");
                else
                    System.out.print(j + "  ");
            }
            System.out.print("        ");
        }
        System.out.println("\n"+"\n");
    }
}

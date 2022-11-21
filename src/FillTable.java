public class FillTable {
    public static void fillTable(char[][] tableroPlayer, char[][] disparosPlayer, char[][] tableroPC, char[][] disparosPC){

        for (int y = 0; y < tableroPlayer.length; y++){
            for (int x = 0; x < tableroPlayer[0].length; x++){
                tableroPlayer[y][x] = '~';
            }
        }
        for (int y = 0; y < disparosPlayer.length; y++){
            for (int x = 0; x < disparosPlayer[0].length; x++){
                disparosPlayer[y][x] = '~';
            }
        }
        for (int y = 0; y < tableroPC.length; y++){
            for (int x = 0; x < tableroPC[0].length; x++){
                tableroPC[y][x] = '~';
            }
        }
        for (int y = 0; y < disparosPC.length; y++){
            for (int x = 0; x < disparosPC[0].length; x++){
                disparosPC[y][x] = '~';
            }
        }
    }
}

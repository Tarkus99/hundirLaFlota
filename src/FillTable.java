public class FillTable {
    // un método que llena los arryas de "~" y otro los llena de barcos,
    //poco que contar aquí
    public static void fillWater(char[][] tableroPlayer, char[][] disparosPlayer, char[][] tableroPC, char[][] disparosPC){

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

    public static void fillShips(char[][] tablero, int cordY, int cordX, int[] barcos, int indice, char direction){
        if (direction == 'v') {
            for (int i = 0, y = cordY; i < barcos[indice]; i++, y++) {
                tablero[y][cordX] = '\u25A0';
            }
        } else {
            for (int i = 0, x = cordX; i < barcos[indice]; i++, x++) {
                tablero[cordY][x] = '\u25A0';
            }
        }
    }
}

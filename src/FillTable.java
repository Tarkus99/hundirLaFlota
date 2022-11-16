public class FillTable {
    public static void fillTable(char[][] tablero){
        for (int y = 0; y < tablero.length; y++){
            for (int x = 0; x < tablero[0].length; x++){
                tablero[y][x] = '~';
            }
        }
    }
}

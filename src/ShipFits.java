public class shipFits{
    public static boolean shipFits(char[][] tablero, int[] barcos, int cordY, int cordX, char direction, int indice) {

        if (direction == 'v') {
            if ((cordY + (barcos[indice] - 1)) < tablero.length)
                return true;
            else
                return false;
        } else {
            if ((cordX + ((barcos[indice]) - 1)) < tablero[0].length)
                return true;
            else
                return false;
        }
    }
}

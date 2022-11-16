public class ShipFits {
    public static boolean shipFits(char[][] tablero, int[] barcos, int[] rightCords, char direction, int indice) {

        if (direction=='v') {
            if ((rightCords[0] + (barcos[indice] - 1)) <= tablero.length)
                return true;
            else
                return false;
        }else{
            if ((rightCords[1] + ((barcos[indice]) - 1)) < tablero[0].length)
                return true;
            else
                return false;
        }
    }
}

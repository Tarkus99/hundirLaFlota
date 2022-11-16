public class IsEmpty {
    public static boolean isEmpty(char[][] tablero, int[] rightCords, char direction, int indice, int[] barcos) {

        boolean colision = false;

        int i = 0;
        int j;
        if (direction == 'v') {
            j = rightCords[0];
            while (!colision && i < barcos[indice]) {
                if (tablero[j][rightCords[1]] == 'b') {
                    colision = true;
                }
                i++;
                j++;
            }
        } else {
            j = rightCords[1];
            while (!colision && i < barcos[indice]) {
                if (tablero[rightCords[0]][j] == 'b') {
                    colision = true;
                }
                i++;
                j++;
            }
        }
        if (colision)
            return false;
        else
            return true;
    }
}

public class filtroPC {
    public static void filtro(char[][] tableroPC, int[] barcos, int indice) {

        boolean pass = false;
        int[] filtro = new int[2];
        char direction;

        do {
            filtro = CoordenadasPC.coordenadasPC();
            direction = DirectionPC.directionPC();

            if (shipFits.shipFits(tableroPC, barcos, filtro, direction, indice)) {
                pass = true;
            }
            if (pass)
                if (!IsEmptyv2.isEmpty(tableroPC, filtro, direction, indice, barcos)) {
                    pass = false;
                }
        } while (!pass);

        if (direction == 'v') {
            for (int i = 0, j = filtro[0]; i < barcos[indice]; i++, j++) {
                tableroPC[j][filtro[1]] = 'B';
            }
        } else {
            for (int i = 0, j = filtro[1]; i < barcos[indice]; i++, j++) {
                tableroPC[filtro[0]][j] = 'B';
            }
        }
    }
}

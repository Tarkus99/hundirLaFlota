public class filtroPC {
    public static void filtro(char[][] tableroPC, int[] barcos, int indice) {

        boolean pass = false;
        boolean message = false;
        int min = 0;
        int max = 9;
        int cordY;
        int cordX;
        char direction;

        do {
            cordY = Coordenadas.random(max, min);
            cordX = Coordenadas.random(max, min);
            direction = Direction.directionPC();

            if (shipFits.shipFits(tableroPC, barcos, cordY, cordX, direction, indice)) {
                pass = true;
            }
            if (pass)
                if (!IsEmptyv2.isEmpty(tableroPC, cordY, cordX, direction, indice, barcos, message)) {
                    pass = false;
                }
        } while (!pass);

        if (direction == 'v') {
            for (int i = 0, j = cordY; i < barcos[indice]; i++, j++) {
                tableroPC[j][cordX] = 'B';
            }
        } else {
            for (int i = 0, j = cordX; i < barcos[indice]; i++, j++) {
                tableroPC[cordY][j] = 'B';
            }
        }
    }
}

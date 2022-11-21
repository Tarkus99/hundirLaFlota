public class FiltroPlayer {
    public static void filtro(char[][] tableroPlayer, int[] barcos, int indice) {
        boolean pass = false;
        boolean message = true;
        int[] filtro = new int[2];
        char direction;

        do {
            filtro = Coordenadas.coordenadasPlayer(Messages.messageHowToCords(barcos, indice));
            direction = Direction.directionPlayer();
            if (shipFits.shipFits(tableroPlayer, barcos, filtro[0], filtro[1], direction, indice)) {
                pass = true;
            } else {
                System.out.println("El barco NO cabe");
            }
            if (pass)
                if (!IsEmptyv2.isEmpty(tableroPlayer, filtro[0], filtro[1], direction, indice, barcos, message)) {
                    pass = false;
                }
        } while (!pass);

        if (direction == 'v') {
            for (int i = 0, j = filtro[0]; i < barcos[indice]; i++, j++) {
                tableroPlayer[j][filtro[1]] = 'B';
            }
        } else {
            for (int i = 0, j = filtro[1]; i < barcos[indice]; i++, j++) {
                tableroPlayer[filtro[0]][j] = 'B';
            }
        }
    }
}


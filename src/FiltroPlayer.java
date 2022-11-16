public class FiltroPlayer {
    public static void filtro(char[][] tableroPlayer, int[] barcos, int indice) {
        boolean pass = false;
        int[] filtro = new int[2];
        char direction;

        do {
            filtro = CoordenadasPlayer.coordenadasPlayer(barcos, indice);
            direction = DirectionPlayer.direction();
            if (ShipFits.shipFits(tableroPlayer, barcos, filtro, direction, indice)) {
                System.out.print("El barco SÍ cabe ");
                pass = true;
            } else {
                System.out.println("El barco NO cabe");
            }
            if (pass)
                if (!IsEmpty.isEmpty(tableroPlayer, filtro, direction, indice, barcos)) {
                    System.out.println("YA hay barcos en esa posición");
                    pass = false;
                } else {
                    System.out.println("y esa posición está LIBRE");
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


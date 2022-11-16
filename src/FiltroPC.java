public class FiltroPC {
    public static void filtro(char[][] tableroPC, int[] barcos, int indice) {

        boolean pass = false;
        int[] filtro = new int[2];
        char direction;

        do {
            filtro = CoordenadasPC.coordenadasPC();
            direction = DirectionPC.directionPC();

            if (ShipFits.shipFits(tableroPC, barcos, filtro, direction, indice)) {
                System.out.print("El barco SÍ cabe ");
                pass = true;
            } else {
                System.out.println("El barco NO cabe");
            }
            if (pass)
                if (!IsEmpty.isEmpty(tableroPC, filtro, direction, indice, barcos)) {
                    System.out.println("YA hay barcos en esa posición");
                    pass = false;
                } else {
                    System.out.println("y esa posición está LIBRE");
                }
        } while (!pass);

        System.out.println(filtro[0] + " " + filtro[1]);

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
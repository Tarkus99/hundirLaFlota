public class ShootsPlayer {

    public static boolean shootsPlayer(char[][] tableroPC, char[][] disparosPlayer) {

        boolean cleanShoot = true;
        int[] filtro;

        do {
            filtro=Coordenadas.coordenadasPlayer(Messages.messageHowToShoot());

            if (disparosPlayer[filtro[0]][filtro[1]]=='H' || disparosPlayer[filtro[0]][filtro[1]]=='W') {
                System.out.println("Ya has disparado ahí anteriormente, ¡espabila!");
                cleanShoot = false;
            }

        } while (!cleanShoot);


        if (tableroPC[filtro[0]][filtro[1]] == 'B') {
            System.out.println(ANSI_GREEN + "¡HAS TOCADO UN BARCO!" + "\n" + ANSI_RESET);
            disparosPlayer[filtro[0]][filtro[1]] = 'H';
            tableroPC[filtro[0]][filtro[1]] = 'X';
            return true;
        } else {
            System.out.println("Mira que eres malo...Agua." + "\n");
            disparosPlayer[filtro[0]][filtro[1]] = 'W';
            return false;
        }
    }
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_RESET = "\u001B[0m";
}
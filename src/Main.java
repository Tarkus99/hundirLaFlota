public class Main {
    public static void main(String[] args) {

        char[][] tableroPlayer = new char[10][10];
        char[][] disparosPlayer = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] disparosPC = new char[10][10];

        String reglas = Reglas.reglas();
        int[] barcos = new int[]{4, 4, 3, 2};
        int puntuacion = barcos[0] + barcos[1] + barcos[2] + barcos[3];
        int indice;
        int shootsPlayer = 0;
        int shootsPC = 0;

        limparPantalla.limpiar();
        System.out.println(reglas);

        FillTable.fillTable(tableroPlayer);
        FillTable.fillTable(disparosPlayer);
        FillTable.fillTable(tableroPC);
        FillTable.fillTable(disparosPC);

        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);

        indice = 0;
        for (int i = 1; i <= barcos.length; i++, indice++) {
            FiltroPlayer.filtro(tableroPlayer, barcos, indice);
            limparPantalla.limpiar();
            ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);
        }
        indice = 0;
        for (int i = 0; i < barcos.length; i++, indice++) {
            filtroPC.filtro(tableroPC, barcos, indice);
        }

        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);

        while (shootsPC < puntuacion && shootsPlayer < puntuacion) {

            if (ShootsPlayer.shootsPlayer(tableroPC, disparosPlayer, shootsPlayer)) {
                shootsPlayer++;
            }

            if (ShootPC.shoot(tableroPlayer, disparosPC)) {
                shootsPC++;
            }
            ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);
        }

        if (shootsPC == puntuacion)
            System.out.println(ANSI_RED + "YOU LOST");
        else
            System.out.println(ANSI_GREEN + "YOU WON");
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
}
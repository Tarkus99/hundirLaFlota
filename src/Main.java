public class Main {
    public static void main(String[] args) {

        int indice = 0;
        int aciertosPlayer = 0;
        int aciertosPC = 0;

        char[][] tableroPlayer = new char[10][10];
        char[][] disparosPlayer = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] disparosPC = new char[10][10];

        FillTable.fillTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);
        LimpiarPantalla.limpiar();
        System.out.println(Messages.reglas1());

        int[] barcos = Barcos.cuantosDeCadaTipo();
        int puntuacion = Barcos.puntuacion(barcos);

        boolean verTablero = VerTableroPC.yesOrNot();

        Entrada.enter(Messages.enterComenzar());

        LimpiarPantalla.limpiar();
        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacion, aciertosPlayer, aciertosPC, verTablero);

        for (int i = 0; i < barcos.length; i++, indice++) {
            FiltroPlayer.filtro(tableroPlayer, barcos, indice);
            LimpiarPantalla.limpiar();
            ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacion, aciertosPlayer, aciertosPC, verTablero);
        }
        indice = 0;
        for (int i = 0; i < barcos.length; i++, indice++) {
            filtroPC.filtro(tableroPC, barcos, indice);
        }
        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacion, aciertosPlayer, aciertosPC,verTablero);

        Jugar.jugar(tableroPlayer, disparosPlayer, tableroPC, disparosPC, aciertosPlayer,aciertosPC,puntuacion, verTablero);

    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
}
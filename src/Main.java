public class Main {
    public static void main(String[] args) {
        char[][] tableroPlayer = new char[10][10];
        char[][] disparosPlayer = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] disparosPC = new char[10][10];

        int[] barcos = new int[]{4, 4, 3, 2};
        int indice;

        FillTable.fillTable(tableroPlayer);
        FillTable.fillTable(disparosPlayer);
        FillTable.fillTable(tableroPC);
        FillTable.fillTable(disparosPC);

        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);

        indice = 0;

        for (int i = 1; i <= barcos.length; i++,indice++) {
            filtro.filtro(tableroPlayer, barcos, indice);
        }
        indice = 0;
        for (int i = 1; i <= barcos.length; i++,indice++) {
            FiltroPC.filtro(tableroPC, barcos, indice);
        }

        ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC);

    }
}
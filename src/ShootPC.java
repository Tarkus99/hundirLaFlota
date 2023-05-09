public class ShootPC {
    public static int[] shoot(char[][] disparosPC, boolean anteriorAcierto, int[] aux, int contadorDisparos) {
        int cordY , cordX ;
        int[] filtroIA;
        int desatascarIA;

        if (!anteriorAcierto && contadorDisparos <= 0) { //si no ha acertado, la proóxima tirada será aleatoria
            do {
                cordY = Coordenadas.random(9, 0);
                cordX = Coordenadas.random(9, 0);
            } while (disparoRepetido(cordY, cordX, disparosPC));
            return new int[]{cordY, cordX};
        }else{
            desatascarIA = 10; //esto lo he puesto porque a veces el PC puede quedarse atascado en una coordenada...
            //...aún tengo que mejorar cosas de la IA
            do {
                if (desatascarIA>0) { // si ha acertado, entrará en el método IA
                    filtroIA = IA.ia(disparosPC, aux);
                    cordY = filtroIA[0];
                    cordX = filtroIA[1];
                    desatascarIA--;
                }else{
                    cordY = Coordenadas.random(9, 0);
                    cordX = Coordenadas.random(9, 0);
                }
            }while ((disparoRepetido(cordY, cordX, disparosPC))); // se repetirá mientras el disparo no haya sido realizado antes
            return new int[]{cordY,cordX};
        }
    }
    public static boolean pcAcierta(int cordY, int cordX, char[][] disparosPC, char[][] tableroPlayer){
        if (tableroPlayer[cordY][cordX] == '\u25A0') {
            System.out.println(ANSI_RED + "¡TE HAN TOCADO UN BARCO!" + ANSI_RESET + "\n");
            disparosPC[cordY][cordX] = 'H';
            tableroPlayer[cordY][cordX] = 'X';
            return true;
        } else {
            System.out.println("El oponente disparó al agua" + "\n");
            disparosPC[cordY][cordX] = 'W';
            return false;
        }
    }
    public static boolean disparoRepetido(int cordY, int cordX, char[][] disparosPC){
        return disparosPC[cordY][cordX]=='H' || disparosPC[cordY][cordX]=='W';
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}

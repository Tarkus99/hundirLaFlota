public class Empty {
    //este método verifica que alrededor de el futuro barco sólo haya agua, empezando desde la misma coordenada.
    public static boolean empty(char[][] tablero, int cordY, int cordX) {

        boolean pasa;

        pasa = tablero[cordY][cordX] == '~';

        if (pasa) {
            if (cordY + 1 < tablero.length) {
                pasa = tablero[cordY + 1][cordX] == '~';
            }
        }

        if (pasa) {
            if (cordY - 1 >= 0) {
                pasa = tablero[cordY - 1][cordX] == '~';
            }
        }

        if (pasa) {
            if (cordX + 1 < tablero[0].length) {
                pasa = tablero[cordY][cordX + 1] == '~';
            }
        }

        if (pasa) {
            if (cordX - 1 >= 0) {
                pasa = tablero[cordY][cordX - 1] == '~';
            }
        }

        return pasa;

    }
}


public class AcotarCoordenadasPC {

    //estos métodos me dicen si la coordenada no está atrapada entre dos "W" o una pared y una "W".
    public static boolean vertical(int cordY, int cordX, char[][] tablero){
        if ((cordY == tablero.length-1) && tablero[cordY-1][cordX] == 'W') return false;
        else if ((cordY == 0) && tablero[cordY+1][cordX] == 'W') return false;
        else if (cordY != 0 && tablero[cordY-1][cordX] == 'W' && cordY !=9 && tablero[cordY+1][cordX] == 'W') return false;
        else return true;
    }

    public static boolean horizontal(int cordY, int cordX, char[][] tablero){
        if ((cordX == tablero[0].length-1) && tablero[cordY][cordX-1] == 'W') return false;
        else if ((cordX == 0) && tablero[cordY][cordX+1] == 'W') return false;
        else if (cordX > 0 && tablero[cordY][cordX-1] == 'W' && cordX < 9 && tablero[cordY][cordX+1] == 'W') return false;
        else return true;
    }
}

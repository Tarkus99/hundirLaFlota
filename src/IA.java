public class IA {
    public static int[] ia(char[][] tablero, int[] aux) {

        int cordY = aux[0];
        int cordX = aux[1];
        int auxY = cordY;
        int auxX = cordX;

        int aboveWater = 0; //indica si arriba del la coordenada hay agualimpia ([0] no, [1] sí)
        int beneathWater = 0;//indica si abajo del la coordenada hay agua ([0] no, [1] sí)
        int aboveHit = 0;//indica si arriba del la coordenada hay un acierto ([0] no, [1] sí)
        int beneathHit = 0;//indica si abajo del la coordenada hay un acierto ([0] no, [1] sí)
        int rigthWater = 0;//idem
        int leftWater = 0;
        int rigthHit = 0;
        int leftHit = 0;//idem

        //si no hay agua limpia ni acierto, es que hay pared o "W";

        boolean vertical;
        boolean horizontal;
        boolean exit = false;

        vertical = AcotarCoordenadasPC.vertical(cordY, cordX, tablero);
        //verifico que el barco pudiera ser vertical(lo será siempre que no esté encerrado entre dos "W"...
        //...o entre una pared y una "W". En ese caso sé seguro que NO es vertical.
        horizontal = AcotarCoordenadasPC.horizontal(cordY, cordX, tablero);
        //ídem con horizontal

        /////////////////////////////////////////////////////////////////////////////////

        //en estos cuatro métodos verifico si puedo avanzar hacia las 4 direcciones.
        //en principio lo hice con booleanos pero con números tengo la opción de que
        //si el acierto está rodeado de agua, elija la dirección con más probabilidades. Por ejemplo:
        //si acierto en F0, el barco puede ser igualmente vertical u horizontal, no lo sabemos,
        //pero en ese caso tengo un hueco por arriba y otro por abajo (2), y sólo uno por la derecha
        //en esa situación el programa elegirá cualquiera o bien arriba o abajo.
        //(0) significa ausencia de la variable a la que alude, y (1) siginifica presencia.

        if (aboveY(cordY)) {
            if (tablero[cordY - 1][cordX] == '~') aboveWater = 1;
            if (tablero[cordY - 1][cordX] == 'H') aboveHit = 1;
        }
        if (beneathY(cordY)) {
            if (tablero[cordY + 1][cordX] == '~') beneathWater = 1;
            if (tablero[cordY + 1][cordX] == 'H') beneathHit = 1;
        }
        if (leftX(cordX)) {
            if (tablero[cordY][cordX - 1] == '~') leftWater = 1;
            if (tablero[cordY][cordX - 1] == 'H') leftHit = 1;
        }
        if (rigthX(cordX)) {
            if (tablero[cordY][cordX + 1] == '~') rigthWater = 1;
            if (tablero[cordY][cordX + 1] == 'H') rigthHit = 1;
        }
        ////////////////////////////////////////////////////////////////////////////////

        if (!horizontal && !vertical) { // si no es horizontal o vertical, es que está atascado entre "W" o pared.
            auxY = Coordenadas.random(9, 0);
            auxX = Coordenadas.random(9, 0);
        }

        if (vertical) {
            if (aboveHit == 1 && beneathWater == 1) { // si encuentro un acierto bien una fila más arriba o más abajo...
                horizontal = false;
                auxY = cordY + 1;
            } else if (beneathHit == 1 && aboveWater == 1) {//...sé con certeza que NO es horizontal, y devuelvo la misma fila +1 ó -1
                horizontal = false;
                auxY = cordY - 1;

                //si el acierto está entre dós aciertos, lo mejor que se me ha ocurrido es salir de ahí.
            } else if (beneathHit == 1 && aboveHit == 1) {
                exit = true;

                //si estoy entre la pared y un acierto, intentaré saltar dos posiciones hacia arriba o hacia abajo.
            } else if (aboveWater == 0 && aboveHit == 0 && beneathHit == 1) {
                horizontal = false;
                if (((cordY + 2) <= 9) && tablero[cordY + 2][cordX] == '~') auxY = cordY + 2;
                else exit = true;
            } else if (beneathWater == 0 && beneathHit == 0 && aboveHit == 1) {
                horizontal = false;
                if ((cordY - 2) >= 0 && tablero[cordY - 2][cordX] == '~') auxY = cordY - 2;
                else exit = true;
            } else if (!horizontal) {
                if (aboveWater == 1) auxY = cordY - 1;
                else auxY = cordY + 1;
                //si no encuentro indicios de que sea vertical, pero sé que NO es horizontal, devuelvo una fila de diferencia.
            }
        }


        //aquí sólo entrará sí ninguna de las anteriores condiciones se ha cumplido
        //y por tanto aún puede ser vertical
        if (horizontal && !exit) {
            if (leftHit == 1 && rigthWater == 1) {
                vertical = false;
                auxX = cordX + 1;
            } else if (rigthHit == 1 && leftWater == 1) {
                vertical = true;
                auxX = cordX - 1;
            } else if (rigthHit == 1 && leftHit == 1) {
                exit = true;
            } else if (leftWater == 0 && leftHit == 0 && rigthHit == 1) {
                vertical = false;
                if (((cordX + 2) <= 9) && tablero[cordY][cordX + 2] == '~') auxX = cordX + 2;
                else exit = true;
            } else if (rigthWater == 0 && rigthHit == 0 && leftHit == 1) {
                vertical = false;
                if (((cordX - 2) >= 0) && tablero[cordY][cordX - 2] == '~') auxX = cordX - 2;
                else exit = true;
            } else if (!vertical) {
                if (leftWater == 1) auxX = cordX - 1;
                else auxX = cordX + 1;
            }
        }


            if (exit) {
                auxY = Coordenadas.random(9, 0);
                auxX = Coordenadas.random(9, 0);
            } else if (vertical && horizontal) {
                //sí tras verificar el entorno de la coordenada, el posible barco...
                //...aún pudiera ser vertical y horizontal
                if ((aboveWater + beneathWater) > (leftWater + rigthWater)) { //calculo por cuál dirección tiene más salidas
                    if (aboveWater == 1) auxY = cordY - 1;
                    else auxY = cordY + 1;
                } else if ((aboveWater + beneathWater) < (leftWater + rigthWater)) {
                    if (leftWater == 1) auxX = cordX - 1;
                    else auxX = cordX + 1;
                } else { //si tiene las mismas salidas en ambas direcciones, se la juega a cara(vertical) o cruz.
                    if (Coordenadas.caraCruz() == 1) {
                        if (aboveWater == 1) auxY = cordY - 1;
                        else auxY = cordY + 1;
                        auxX = cordX;
                    } else {
                        if (leftWater == 1) auxX = cordX - 1;
                        else auxX = cordX + 1;
                        auxY = cordY;
                    }
                }
            }

        return new int[]{auxY, auxX};
    }


    public static boolean aboveY(int cordY) {
        return cordY - 1 >= 0;
    }
    public static boolean beneathY(int cordY) {
        return cordY + 1 <= 9;
    }
    public static boolean leftX(int cordX) {
        return cordX - 1 >= 0;
    }
    public static boolean rigthX(int cordX) {
        return cordX + 1 <= 9;
    }
    public static int ladosPosibles(char[][] tablero, int cordY, int cordX){
        int sum = 0;

        if (aboveY(cordY)) {
            if (tablero[cordY - 1][cordX] == '~') sum+= 1;

        }
        if (beneathY(cordY)) {
            if (tablero[cordY + 1][cordX] == '~') sum+= 1;
        }
        if (leftX(cordX)) {
            if (tablero[cordY][cordX - 1] == '~') sum+= 1;
        }
        if (rigthX(cordX)) {
            if (tablero[cordY][cordX + 1] == '~') sum+= 1;
        }
        return sum;
    }
}

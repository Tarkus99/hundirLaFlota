public class Barcos {
    public static int numeroBarcos() {
        int numBarcos;
        boolean correct = false;
        do {
            System.out.println("Elige cuántos barcos quieres poner en tu flota entre 1 y 7:");
            numBarcos = Entrada.entradaInt();

            if (numBarcos > 0 && numBarcos <= 7) correct = true;
            else if (numBarcos > 7) System.out.println("Eso no va a ser posible.");
            else System.out.println("¿Es que eres tonto?");

        } while (!correct);

        return numBarcos;
    }

    public static int puntuacion(int[] barcos) {
        int puntuacion = 0;
        for (int i = 0; i < barcos.length; i++) {
            puntuacion += barcos[i];
        }
        return puntuacion;
    }

    public static int[] cuantosDeCadaTipo() {

        int[] barcos = new int[Barcos.numeroBarcos()];
        int longitudFlota = barcos.length;
        int cuantosDeCadaTipo;
        int[] aux = new int[]{0, 0, 0, 0};
        int posicionArrayAux = 0;
        int leftLimit = 0;
        int rigthLimit;
        boolean pasa;

        System.out.println(Messages.reglas2());

          //ACORAZADOS

        do {
            System.out.println("¿Cuántos acorazados quieres en tu flota?");
            cuantosDeCadaTipo = Entrada.entradaInt();
            if (cuantosDeCadaTipo > longitudFlota) {
                System.out.println(Messages.limiteFlota());
                pasa = false;
            } else if (cuantosDeCadaTipo < 0) {
                System.out.println("¿Es que eres tonto?");
                pasa = false;
            } else if (cuantosDeCadaTipo > (longitudFlota / 2) && longitudFlota >= 3) {
                //no dejo poner más de la mitad de los acorazados si el total de barcos es mayor a 3
                System.out.println(Messages.limitePortaviones());
                pasa = false;
            } else {
                pasa = true;
            }
        } while (!pasa);

        rigthLimit = cuantosDeCadaTipo;
        aux[posicionArrayAux++] = cuantosDeCadaTipo;
        //el array aux me servirá para poder enumerar la flota más abajo.
        //guarda la cantidad de cada tipo en orden decreciente de longitud.

        for (int i = leftLimit; i < rigthLimit; i++) {
            barcos[i] = 4;
        }

          //PORTAVIONES

        if (cuantosDeCadaTipo < longitudFlota) {
            leftLimit = rigthLimit;
            longitudFlota -= cuantosDeCadaTipo;

            do {
                System.out.println("¿Cuántos portaviones quieres en tu flota?");
                cuantosDeCadaTipo = Entrada.entradaInt();
                if (cuantosDeCadaTipo > longitudFlota) {
                    System.out.println(Messages.limiteFlota());
                    pasa = false;
                } else if (cuantosDeCadaTipo < 0) {
                    System.out.println("¿Es que eres tonto?");
                    pasa = false;
                } else {
                    pasa = true;
                }
            } while (!pasa);

            rigthLimit += cuantosDeCadaTipo;
            aux[posicionArrayAux++] = cuantosDeCadaTipo;

            for (int i = leftLimit; i < rigthLimit; i++) {
                barcos[i] = 3;
            }

              //BUQUES

            if (cuantosDeCadaTipo < longitudFlota) {
                leftLimit = rigthLimit;
                longitudFlota -= cuantosDeCadaTipo;

                do {
                    System.out.println("¿Cuántos buques quieres en tu flota?");
                    cuantosDeCadaTipo = Entrada.entradaInt();
                    if (cuantosDeCadaTipo > longitudFlota) {
                        System.out.println(Messages.limiteFlota());
                        pasa = false;
                    } else if (cuantosDeCadaTipo < 0) {
                        System.out.println("¿Es que eres tonto?");
                        pasa = false;
                    } else {
                        pasa = true;
                    }
                } while (!pasa);

                rigthLimit += cuantosDeCadaTipo;
                aux[posicionArrayAux++] = cuantosDeCadaTipo;

                for (int i = leftLimit; i < rigthLimit; i++) {
                    barcos[i] = 2;
                }

                  //LANCHAS

                if (cuantosDeCadaTipo < longitudFlota) {
                    leftLimit = rigthLimit;
                    aux[posicionArrayAux] = barcos.length - rigthLimit;
                    System.out.println("Los barcos restantes se asignarán como lanchas.");
                    for (int i = leftLimit; i < barcos.length; i++) {
                        barcos[i] = 1;
                    }
                }
            }
        }

        System.out.println("Tu flota queda así: ");
        for (int i = 0; i < aux.length; i++)
            System.out.println("-" + aux[i] + " " + Messages.tiposBarco(i, false));

        return barcos;
    }
}



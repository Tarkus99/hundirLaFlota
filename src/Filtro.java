public class Filtro {
    public static void filtro(char[][] tablero, int[] barcos, int indice, boolean isPLayer) {
        boolean pasa;
        int[] filtro;
        char direction = ' ';
        int cordY, cordX;
        int z, j;

        if (isPLayer) ShowTable.showPlayerOnly(tablero);
        for (int k = 0; k < barcos.length; k++, indice++) {
            pasa = false;
            do {
                if (isPLayer) { //si player es cierto, coordenadas manual, si no, automáticas con Mathrandom
                    filtro = Coordenadas.coordenadasPlayer(Messages.messageHowToCords(barcos, indice));
                    cordY = filtro[0];
                    cordX = filtro[1];
                    if(barcos[indice]!=1) direction = Direction.directionPlayer();
                }else{
                    cordY = Coordenadas.random(9, 0);
                    cordX = Coordenadas.random(9, 0);
                    direction = Direction.directionPC();
                }
                if (ShipFits.shipFits(tablero, barcos, cordY, cordX, direction, indice)) {
                    pasa = true;
                } else {
                    if (isPLayer){System.out.println(Messages.noCabe());}
                }
                if (pasa) {
                    z = 0;
                    if (direction == 'v'){ //verifico que hay agua alrededor para la dirección vertical
                        j = cordY;
                        while (z<barcos[indice] && pasa){
                            if (Empty.empty(tablero, j, cordX)) {
                                z++;
                                j++;
                            }else{
                                if (isPLayer){System.out.println(Messages.barcosSeTocan());}
                                pasa = false;
                            }
                        }
                    }else{ //ídem para la horizontal
                        j = cordX;
                        while (z<barcos[indice] && pasa){
                            if (Empty.empty(tablero, cordY, j)) {
                                z++;
                                j++;
                            }else{
                                if (isPLayer){System.out.println(Messages.barcosSeTocan());}
                                pasa = false;
                            }
                        }
                    }
                }
            } while (!pasa);
            //si sale del bucle, es que ttodo está correcto y llena con cuadrados blancos las posiciones correspondientes
            //del tablero
            FillTable.fillShips(tablero, cordY, cordX, barcos, indice, direction);
            if (isPLayer)Entrada.limpiar();
            if (isPLayer) ShowTable.showPlayerOnly(tablero);
        }
    }
}


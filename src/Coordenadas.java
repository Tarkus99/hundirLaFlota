public class Coordenadas {
    public static int[] coordenadasPlayer(String message) {

        String input;
        int longitudInput;
        int cordX;
        int cordY;
        boolean formato;
        boolean bounds = false;

        do {
            formato = false;
            do {
                System.out.println(message);
                input = Entrada.entradaTexto();
                longitudInput = input.length();

                if (longitudInput != 2) { //primero determino que el formato [A0] sea correcto.
                    System.out.println(Messages.coordenadaIncorrecta());
                } else if (Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1))) {
                    formato = true;
                } else {
                    System.out.println(Messages.coordenadaIncorrecta());
                }
            } while (!formato);

            cordY = (Character.toLowerCase(input.charAt(0))) - 'a'; //convierto la letra en números.
            cordX = Character.getNumericValue(input.charAt(1));

            if (dentroTablero(cordY, cordX)) bounds = true;
            else System.out.println("Te has salido del tablero...");
        } while (!bounds);

        return new int[]{cordY, cordX}; //la posición 0 es eje Y, posición 1 es eje X.
    }
    public static boolean dentroTablero(int cordY, int cordX) {
        return cordY >= 0 && cordY <= 9 && cordX >= 0 && cordX <= 9;
    }

    public static int random(int max, int min) {
        return (int) (Math.random() * ((max + 1) - min) + min);
    }

    public static int caraCruz(){
        return (int) (Math.random() * ((2 + 1) - 1) + 1);
    }
}
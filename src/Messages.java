import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Messages {

    //aquí guardo todos los mensajes te texto recurrentes que se usan en el juego
    public static String contento(){
        return "¿Estás contento con cómo ha quedado la flota? [S|N]";
    }

    public static String rellenarAuto(){
        return "¿Quieres que se rellene automáticamente tu tablero? [S|N]";
    }

    public static String disparoPC(int cordY, int cordX){
        char letra = (char) ('A' + cordY);
        return "Tu oponente disparó " + letra + cordX + ".";
    }
    public static String preocupas(){
        return ANSI_RED + "Me preocupas...¿cómo puedes ser tan torpe?" + ANSI_RESET;
    }

    public static String messageHowToCords(int[] barcos, int indice){
        return "Introduce una coordenada para poner " + tiposBarco(barcos[indice], true) + " con el siguiente formato [A9]";
    }

    public static String noCabe(){
        return ANSI_RED + "Ese barco ahí NO cabe." + ANSI_RESET;
    }
    public static String tanDificil() {
        return ANSI_RED + "¿Tan difícil es poner una 'S' o una 'N'?" + ANSI_RESET;
    }
    public static String tiposBarco(int indice, boolean resumenFlota){
        String barco = " ";
        if (resumenFlota) {
            switch (indice) {
                case 4 : barco = "un acorazado";
                break;
                case 3 : barco = "un portaviones";
                    break;
                case 2 : barco = "un buque";
                    break;
                case 1 : barco = "una lancha";
                    break;
            }
        }else{
             switch (indice) {
                 case 0 : barco = "acorazado(s)";
                     break;
                 case 1 : barco ="portaviones";
                     break;
                 case 2 : barco ="buque(s)";
                     break;
                 case 3 : barco ="lancha(s)";
                     break;
            }
        }
        return barco;
    }
    public static String barcosSeTocan(){
        return ANSI_RED + "Los barcos no pueden tocarse ni cruzarse" + ANSI_RESET;
    }
    public static String enterComenzar(){
        return "Pulsa \"Enter\" para comenzar...";
    }
    public static String enterSalir(){
        return "Pulsa \"Enter\" para salir...";
    }
    public static String enterContinuar(){
        return "Pulsa \"Enter\" para continuar...";
    }
    public static String messageHowToShoot(){
        return "Introduce una coordenada con el siguiente formato [A9]";
    }

    public static String coordenadaIncorrecta(){
        return ANSI_RED + "¿Es que no sabes leer? Ese formato es incorrecto" + ANSI_RESET;
    }

    public static String verTableroPC(){
        return "Por último, quieres ver los tableros del PC? [S/N]";
    }

    public static String limitePortaviones(){
        return "Por motivos logísticos no puedes poner toda tu flota de portaviones";
    }

    public static String limiteFlota(){
        return "¡No puedes poner más barcos que el límite que has establecido!";
    }

    public static String reglas1(){
        String reglas1 = ("\n" + ANSI_GREEN + "¡Bienvenido al juego de hundir la flota!" + ANSI_RESET + "\n" + "Para ganar, deberás llegar " +
                "a la puntuación indicada antes que el PC." + "\n" + "Para colocar un barco, deberás indicar una letra " +
                "correspondiente a la fila, y un número correspondiente a la columna, como 'A7'." + "\n" + "Cualquier otro formato " +
                "será inválido." + "\n" + "Cuando elijas la posición vertical, el barco se posicionará hacia abajo a partir " +
                "de la coordenada introducida." + "\n" + "Cuando elijas la posición horizontal, el barco se posicionará " +
                "hacia la derecha a partir de la coordenada introducida." + "\n");
        return reglas1;
    }

    public static String reglas2(){
        String reglas2 = "Los barcos pueden ser de 4 tipos: " + "\n" +
                "-Los acorazados ocuparán 4 casillas." + "\n"+
                "-Los portaviones ocuparán 3 casillas." + "\n" +
                "-Los buques ocuparán 2 casillas" + "\n" +
                "-Las lanchas ocuparán 1 casilla";
        return reglas2;
    }

    public static void resultado(boolean ganaUsuario) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (!ganaUsuario) {
            Music.died();
            System.out.println(ANSI_RED +
                    "   ****     **   *****     ****    ***     *******    ***   ****** *******       \n" +
                    "      *    *  **       *   **      *       *      **   *    *      *      **    \n" +
                    "       *  *   *         *  **      *       *       **  *    *      *       **   \n" +
                    "        **   **         *  **      *       *        *  *    *+***  *        *   \n" +
                    "        **    *         *  **      *       *       **  *    *      *       **   \n" +
                    "        **     *       *    *      *       *      **   *    *      *      **    \n" +
                    "       ****      /***,        ***/        *******     ***/  ***** *******    " + "\n" + ANSI_RESET);
            Entrada.enter(Messages.enterSalir());

        }else {
            Music.fanfare();
            System.out.println(ANSI_GREEN + "¡BUEN TRABAJO!" + "\n" + ANSI_RESET);
            Entrada.enter(Messages.enterSalir());
        }
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_RESET = "\u001B[0m";
}

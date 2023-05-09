import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ShootsPlayer {
    public static boolean shootsPlayer(char[][] tableroPC, char[][] disparosPlayer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        boolean cleanShoot; //cleanshoot es un disparo nuevo, que no se ha hecho antes
        int[] filtro;

        do {
            cleanShoot = true;
            filtro = Coordenadas.coordenadasPlayer(Messages.messageHowToShoot());

            if (disparoRepetido(disparosPlayer, filtro[0], filtro[1])) {
                System.out.println("Ya has disparado ahí anteriormente, ¡espabila!");
                cleanShoot = false;
            }
        } while (!cleanShoot);

        Music.shot();
        try {
            Thread.sleep(3800);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (tableroPC[filtro[0]][filtro[1]] == '\u25A0') {
            System.out.println("\n" + ANSI_GREEN + "¡HAS TOCADO UN BARCO!" + ANSI_RESET);
            disparosPlayer[filtro[0]][filtro[1]] = 'H';
            tableroPC[filtro[0]][filtro[1]] = 'X';
            return true;
        } else {
            System.out.println("\n" + "Mira que eres malo..." + BLUE_BRIGHT + "Agua." + ANSI_RESET);
            disparosPlayer[filtro[0]][filtro[1]] = 'W';
            return false;
        }
    }

    public static boolean disparoRepetido(char[][] tablero, int cordY, int cordX){
        return tablero[cordY][cordX]=='H' || tablero[cordY][cordX]=='W';
    }
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static final String ANSI_RESET = "\u001B[0m";
}
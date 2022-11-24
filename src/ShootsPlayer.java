import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ShootsPlayer {
    public static boolean shootsPlayer(char[][] tableroPC, char[][] disparosPlayer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        boolean cleanShoot;
        int[] filtro;

        do {
            cleanShoot = true;
            filtro = Coordenadas.coordenadasPlayer(Messages.messageHowToShoot());

            if (disparosPlayer[filtro[0]][filtro[1]] == 'H' || disparosPlayer[filtro[0]][filtro[1]] == 'W') {
                System.out.println("Ya has disparado ahí anteriormente, ¡espabila!");
                cleanShoot = false;
            }

        } while (!cleanShoot);

        Music.shot();
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (tableroPC[filtro[0]][filtro[1]] == 'B') {
            System.out.println("\n" + ANSI_GREEN + "¡HAS TOCADO UN BARCO!" + ANSI_RESET);
            disparosPlayer[filtro[0]][filtro[1]] = 'H';
            tableroPC[filtro[0]][filtro[1]] = 'X';
            return true;
        } else {
            System.out.println("\n" + "Mira que eres malo...Agua.");
            disparosPlayer[filtro[0]][filtro[1]] = 'W';
            return false;
        }
    }

    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_RESET = "\u001B[0m";
}
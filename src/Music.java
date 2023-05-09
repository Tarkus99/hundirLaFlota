import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Music {

    public static void shot() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("./Rifle Shot Echo.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);

        clip.loop(0);
    }

    public static void menu() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("./FFX menu.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void died() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        File file = new File("./you died.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }


    public static void fanfare() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        File file = new File("./FFX fanfare.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.loop(0);
    }
}

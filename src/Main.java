import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        /////////////////////////////
        File battlefile = new File("./FFX_battletheme.wav");
        AudioInputStream audioStreamBattle = AudioSystem.getAudioInputStream(battlefile);
        Clip battle = AudioSystem.getClip();
        battle.open(audioStreamBattle);
        FloatControl gainControlBattle = (FloatControl) battle.getControl(FloatControl.Type.MASTER_GAIN);
        gainControlBattle.setValue(-7.0f);

        File prepfile = new File("./FFX Hurry.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(prepfile);
        Clip prep = AudioSystem.getClip();
        prep.open(audioStream);
        FloatControl gainControl = (FloatControl) prep.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        ////////////////////////////

        int[] barcos;
        int aciertosPlayer = 0;
        int aciertosPC = 0;
        int puntuacionTotal;
        int cordYPC, cordXPC;
        boolean verTablero;
        boolean pasa = false;


        char[][] tableroPlayer = new char[10][10];
        char[][] disparosPlayer = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] disparosPC = new char[10][10];

        FillTable.fillWater(tableroPlayer, disparosPlayer, tableroPC, disparosPC);
        Entrada.limpiar();


        prep.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println(Messages.reglas1());
        barcos = Barcos.cuantosDeCadaTipo();
        puntuacionTotal = Barcos.puntuacion(barcos);
        Entrada.enter(Messages.enterContinuar());

        Entrada.limpiar();

        Filtro.filtro(tableroPlayer, disparosPlayer, barcos, 0, true);
        Filtro.filtro(tableroPC, disparosPC, barcos, 0, false);

        verTablero = VerTableroPC.yesOrNot();
        Entrada.enter(Messages.enterComenzar());
        Music.menu();
        try {
            Thread.sleep(2*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        prep.stop();
        battle.loop(Clip.LOOP_CONTINUOUSLY);

        int[] disparosPc;
        int[] aux = new int[]{0,0};
        boolean PChit = false;
        int contadorPc = 0;
       /* ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacionTotal, aciertosPlayer, aciertosPC, verTablero);*/
            while (aciertosPC < puntuacionTotal && aciertosPlayer < puntuacionTotal) {
                Entrada.limpiar();
                ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacionTotal, aciertosPlayer, aciertosPC, verTablero);
               /* if (!PChit) {
                    if (ShootsPlayer.shootsPlayer(tableroPC, disparosPlayer))
                        aciertosPlayer++;
                }*/
                if (PChit) System.out.println("El PC repite turno");
                disparosPc = ShootPC.shoot(tableroPlayer, disparosPC, PChit, aux, contadorPc);
                System.out.println(Messages.disparoPC(disparosPc[0], disparosPc[1]));
                if (ShootPC.pcAcierta(disparosPc[0], disparosPc[1], disparosPC, tableroPC, tableroPlayer)) {
                    aciertosPC++;
                    contadorPc = 4;
                    aux[0] = disparosPc[0];
                    aux[1] = disparosPc[1];
                    PChit = true;
                }else{
                    contadorPc--;
                    PChit = false;
                    /*aux[0] = disparosPc[0];
                    aux[1] = disparosPc[1];*/
                }
                Entrada.enter(Messages.enterContinuar());
            }
            battle.stop();

        Messages.resultado(aciertosPlayer == puntuacionTotal);

    }
}
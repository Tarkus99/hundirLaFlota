import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //los archivos de música de fondo he tenido que ponerlos en el Main porque no conseguía parar la reproducción
        //a través de los métodos. Lo del audio en java me supera.
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
        boolean verTablero;
        boolean isPlayer;


        char[][] tableroPlayer = new char[10][10];
        char[][] disparosPlayer = new char[10][10];
        char[][] tableroPC = new char[10][10];
        char[][] disparosPC = new char[10][10];

        FillTable.fillWater(tableroPlayer, disparosPlayer, tableroPC, disparosPC);
        Entrada.limpiar();


        prep.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println(Messages.reglas1());
        do {
            barcos = Barcos.cuantosDeCadaTipo();
            puntuacionTotal = Barcos.puntuacion(barcos);
        }while(!PreguntasYesOrNot.yesornot(Messages.contento()));

        Entrada.enter(Messages.enterContinuar());
        Entrada.limpiar();

        if (PreguntasYesOrNot.yesornot(Messages.rellenarAuto())) isPlayer = false;
        else isPlayer = true;
        //Si el usuario SÍ quiere rellenar el tablero automáticamente, isPLayer es false
        //y el método Filtro se gestionará como si fuese el PC (sin mensajes).

        Filtro.filtro(tableroPlayer, barcos, 0, isPlayer);
        Filtro.filtro(tableroPC, barcos, 0, false);

        verTablero = PreguntasYesOrNot.yesornot(Messages.verTableroPC());
        Entrada.enter(Messages.enterComenzar());
        Music.menu();
        try {
            Thread.sleep(2600);
        } catch (Exception e) {
            System.out.println(e);
        }
        prep.stop();
        battle.loop(Clip.LOOP_CONTINUOUSLY);

        int[] disparosPc;
        int[] aux = new int[]{0,0}; //el array aux, me guardará las coordenadas en caso de acierto.
        boolean PChit = false;
        int contadorPc = 0;
            while (aciertosPC < puntuacionTotal && aciertosPlayer < puntuacionTotal) {
                Entrada.limpiar();
                ShowTable.showTable(tableroPlayer, disparosPlayer, tableroPC, disparosPC, puntuacionTotal, aciertosPlayer, aciertosPC, verTablero);
                if (!PChit) { //si el PC ha acertado, botará el turno del usuario.
                    if (ShootsPlayer.shootsPlayer(tableroPC, disparosPlayer))
                        aciertosPlayer++;
                }
                if (PChit) System.out.println("El PC repite turno");
                disparosPc = ShootPC.shoot(disparosPC, PChit, aux, contadorPc);
                System.out.println(Messages.disparoPC(disparosPc[0], disparosPc[1]));
                if (ShootPC.pcAcierta(disparosPc[0], disparosPc[1], disparosPC, tableroPlayer)) {
                    aciertosPC++;
                    // el contadorPc lo pongo porque en un primer acierto, no sabes hacia donde tirar...
                    //entonces vas a rodear el acierto por los todos los lados posibles hasta que encuentres el siguiente.
                    contadorPc = IA.ladosPosibles(disparosPC, disparosPc[0], disparosPc[1]);

                    aux[0] = disparosPc[0]; //si el PC acierta, me guardo las coordenadaspara enviarlas.
                    aux[1] = disparosPc[1];
                    PChit = true;
                }else{
                    contadorPc--;
                    PChit = false;
                }
                Entrada.enter(Messages.enterContinuar());
            }
            battle.stop();

        Messages.resultado(aciertosPlayer == puntuacionTotal);

    }
}
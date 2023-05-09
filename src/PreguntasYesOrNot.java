
public class PreguntasYesOrNot {
    public static boolean yesornot(String message) {
        String x;
        boolean format = false;

        do {
            System.out.println(message);
            x = Entrada.entradaTexto();
            if (x.equalsIgnoreCase("s") || x.equalsIgnoreCase("n")) {
                format = true;
            }else{
                System.out.println(Messages.tanDificil());
            }
        } while (!format);

        return x.toLowerCase().charAt(0) == 's';

    }
}

public class Direction {
    public static char directionPlayer(){

        String input;
        char direction;
        boolean directionFormat = false;

            do {
                System.out.println("¿Quieres el barco en dirección vertical u horizontal? [V|H]");
                input = Entrada.entradaTexto();
                if (input.toLowerCase().compareTo("v")==0 || input.toLowerCase().compareTo("h")==0) {
                    directionFormat=true;
                }else {
                    System.out.println(Messages.preocupas());
                }
            } while (!directionFormat);//primero que el formato sea correcto

            direction = input.charAt(0);

        return Character.toLowerCase(direction);
    }

    public static char directionPC(){
        char direction;
        int letra = (int)(Math.random()*2) + 1 ;
        if (letra==1){
            direction = 'v';
        }else{
            direction = 'h';
        }
        return direction;
    }
}

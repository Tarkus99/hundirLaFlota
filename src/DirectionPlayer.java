public class DirectionPlayer {
    public static char direction(){

        String input;
        char direction;
        boolean directionFormat = false;
        boolean correctDirection = false;

        do {
            do {
                System.out.println("Do you want the ship horizontal[H] or vertical[V]?");
                input = Entrada.entrada();
                if (input.length() != 1) {
                    System.out.println("Not valid format");
                }else {
                    directionFormat = true;
                }
            } while (!directionFormat);//primero que le formato sea correcto

            direction = input.charAt(0);

            if (Character.toLowerCase(direction)=='v' || Character.toLowerCase(direction)=='h')
                correctDirection = true;
            else
                System.out.println("Incorrect direction");

        }while(!correctDirection);//luego que el valor sea válido ('v' o 'h')

        return Character.toLowerCase(direction);
    }
}

import java.util.Scanner;
public class DirectionPlayer {
    public static char direction(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        char direction;
        boolean directionFormat = false;
        boolean correctDirection = false;

        do {
            do {
                System.out.println("Do you want the ship horizontal[H] or vertical[V]?");
                input = sc.nextLine();
                if (input.length() != 1) {
                    System.out.println("Not valid format");
                }else {
                    directionFormat = true;
                }
            } while (!directionFormat);

            direction = input.charAt(0);

            if (Character.toLowerCase(direction)=='v' || Character.toLowerCase(direction)=='h')
                correctDirection = true;
            else
                System.out.println("Incorrect direction");
                directionFormat = false;

        }while(!correctDirection);

        return Character.toLowerCase(direction);
    }
}

public class DirectionPC {
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

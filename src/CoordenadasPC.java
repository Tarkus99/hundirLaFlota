public class CoordenadasPC {
    public static int[] coordenadasPC(){
        int[] cordNum = new int[2];
        for (int i = 0; i<cordNum.length; i++)
            cordNum[i]= Random.random();
        return cordNum;
    }
}

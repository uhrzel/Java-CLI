public class SpeedingPenalty_22033701{
    private static final int[] excess_speed = {0,10,20,30,40,45};
    private static final int[] demerit_points = {0,1,2,3,4,6};
    private static final int[] fine = {0,369,473,585,819,1356};
    private static final boolean[] automatic_suspension = {false,false,false,false,false,true};

    public static int findPeanltyIndex(int excessSpeed){
        int index = -1;

        for(int x = 0; x < excess_speed.length; x++){
            if(excessSpeed <= excess_speed[x]){
                index = x;
                break;
            }
        }
        return index;
    }

    public static int getDemeritPoints(int excessSpeed){
        int index = findPeanltyIndex(excessSpeed);
        return (index != -1 ) ? demerit_points[index] : 0;
    }
    public static int getFine(int excessSpeed){
        int index = findPeanltyIndex(excessSpeed);
        return (index != -1 ) ? fine[index] : 0;
    }
    public static boolean requiresAutomaticSuspension(int excessSpeed){
        int index = findPeanltyIndex(excessSpeed);
        return (index != -1 ) && automatic_suspension[index];
    }
}
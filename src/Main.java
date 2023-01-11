public class Main {

    private static final int n = 6;
    private final static int[] sequence = {5,4,1,5,6,8};
    private static int k = n;

    private static int[] numbersAlreadyInArray = new int[n];

    private static boolean wasElementChecked(int number) {
        boolean flag = false;
        if(numbersAlreadyInArray.length > 0) {
            for (int i = 0; i < numbersAlreadyInArray.length; i++) {
                if (number == numbersAlreadyInArray[i])
                    flag = true;
            }
        }
        return flag;
    }
    private static void algorithm() {
        for(int i = 0; i < sequence.length; i++) {
            for(int j = 1; j <= n; j++) {
                if (sequence[i] == j && !wasElementChecked(j)) {
                    numbersAlreadyInArray[i] = j;
                    k--;
                }
            }
        }
        System.out.println(k);
    }

    
    public static void main(String[] args) {
        algorithm();
    }
}
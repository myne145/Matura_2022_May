import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

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


    //FROM NOW ON ALL FUNCTIONS ARE REFERENCING EXERCISES FROM THE SECOND PART OF MATURA
    private static void zad4Part1() throws IOException {
        File wyniki4 = new File("wyniki4.txt");
        File liczby = new File("liczby.txt");
        if(!wyniki4.exists())
            wyniki4.createNewFile();
        ArrayList<String> content = (ArrayList<String>) Files.readAllLines(liczby.toPath());
        ArrayList<Integer> contentOfLiczbyFile = new ArrayList<>();
        for(String s : content)
            contentOfLiczbyFile.add(Integer.parseInt(s));
        //actuall algorithm here
        int firstNumber = -1;
        int counter = 0;
        for(int i : contentOfLiczbyFile) {
            String s = String.valueOf(i);
            if(s.charAt(0) == s.charAt(s.length() - 1)) {
                if(counter == 0) {
                    firstNumber = i;
                }
                counter++;
            }
        }
        FileWriter fileWriter = new FileWriter(wyniki4);
        fileWriter.write("Pierwsza taka liczba: " + firstNumber + "\nIlość takich liczb: " + counter);
        fileWriter.close();

    }

    private static boolean isPrimeNumber(int n) {
        boolean isPrime = true;
        if(n != 1) {
            for(int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    private static ArrayList<Integer> getPrimeDividers(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0 && isPrimeNumber(i)) {
                arr.add(i);
            }
        }
        return arr;
    }

    private static int howManyTimesWasNumberDivided = 0;
    private static int rozklad(int n) {
        if(!isPrimeNumber(n)) {
            int temp = n / getPrimeDividers(n).get(0);
            howManyTimesWasNumberDivided++;
            rozklad(temp);
        }
        return howManyTimesWasNumberDivided;
    }

    private static void zad4Part2() throws IOException {
        File wyniki4 = new File("wyniki4_2.txt");
        File liczby = new File("przyklad.txt");
        if(!wyniki4.exists())
            wyniki4.createNewFile();
        ArrayList<String> content = (ArrayList<String>) Files.readAllLines(liczby.toPath());
        ArrayList<Integer> contentOfLiczbyFile = new ArrayList<>();
        ArrayList<Integer> howManyDividersForEachNum = new ArrayList<>();
        for(String s : content)
            contentOfLiczbyFile.add(Integer.parseInt(s));
        //algorithm here
        for(Integer i : contentOfLiczbyFile) {
            if(isPrimeNumber(i)) {
                howManyDividersForEachNum.add(1);
            }
            else {
                howManyDividersForEachNum.add(rozklad(i));
            }
        }
        for(int i : howManyDividersForEachNum)
            System.out.println(i);
    }
    public static void main(String[] args) throws IOException {
        zad4Part2();
    }
}
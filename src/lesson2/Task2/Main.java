package lesson2.Task2;

import java.util.Arrays;
public class Main {


    public static void main(String[] args) {
        new Main().returnPairNumbers(new int[]{3, 4, 2, 7},10);
        new Main().returnPairNumbers(new int[]{3, 5, 2, 7},12);
        new Main().returnPairNumbers(new int[]{3, 4, 4, 7},8);
        new Main().returnPairNumbers(new int[]{3, 8, 2, 7},15);
        new Main().returnPairNumbers(new int[]{3, 6, 2, 7},13);
    }

    private void returnPairNumbers(int[] arr, int sumOfTwoNumbers){
        int returnArr[] = new int[2];

        for (int n = 0; n < arr.length; n++) {
            int finalN = n;
            if (Arrays.stream(arr).anyMatch(x->x==sumOfTwoNumbers-arr[finalN])){
                returnArr= new int[]{arr[n],sumOfTwoNumbers-arr[n]};
            }
        }System.out.println("["+returnArr[0]+","+returnArr[1]+"]");

    }
}
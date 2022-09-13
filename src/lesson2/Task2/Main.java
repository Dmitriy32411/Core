package lesson2.Task2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().returnPairNumbers(new int[]{3, 4, 2, 7},10);
        new Main().returnPairNumbers(new int[]{3, 5, 2, 7},12);
        new Main().returnPairNumbers(new int[]{3, 4, 4, 7},8);
        new Main().returnPairNumbers(new int[]{3, 8, 2, 7},15);
        new Main().returnPairNumbers(new int[]{3, 6, 2, 7},13);

        new Main().returnPairNumbers(new int[]{5, 4, 2, 9},10);


    }

    private void returnPairNumbers(int[] arr, int sumOfTwo){

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(sumOfTwo - arr[i])){
                System.out.println("["+arr[map.get(sumOfTwo - arr[i])]+","+arr[i]+"]");
            }
            map.put(arr[i], i);
        }

    }

}
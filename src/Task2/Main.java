package Task2;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] array = new int[]{5,6,3,2,5,1,4,9};
        int[] array2 = new int[]{5,6,3,2,5,1,4,9,2,2,2,2,2,1,1,13,4,5,52,2,23,5,23,122,321,12,2332,1,1,1,1,1,1};
        int[] array3 = main.getArray(new int[45]);


        main.insertSort(array);
        System.out.println("\n *** \n");
        main.insertSort(array2);
        System.out.println("\n *** \n");
        main.insertSort(array3);
    }
    void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    void testSortArray(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]){
                System.out.println("The array is not sorted.");
                temp++;
                break;
            }
        }
        if (temp==0){
            System.out.println("The array is sorted.");
        }
    }
    void insertSort(int[] array) {
        Main main = new Main();
        main.printArray(array);
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int right = i - 1;
            while (right >= 0){
                if (value < array[right]) {
                    array[right + 1] = array[right];
                    right--;
                } else {
                    break;
                }
            }
            array[right + 1] = value;
        }
        assert isSorted(array):"Assert: its array not sorted.";
        main.testSortArray(array);
        main.printArray(array);
        main.countDoubleElementInSortedArray(array);
    }
    void countDoubleElementInSortedArray(int[] array){
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if (count>1){
                System.out.println("Duplicates for "+array[i]+" = "+ count);
                i+=count-3;
                count=0;
            }
            for (int j = i+1; j < array.length; j++) {

                if (array[i]==array[j]){
                    count+=1;

                }
            }

        }

    }
    private int[] getArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]= (int) (new Date().getTime()%(17+(i)));
        }

        return array;

    }
    private boolean isSorted(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]){
                return false;
            }
        }

        return true;
    }
}
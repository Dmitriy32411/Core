package Task1;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] array = new int[11][11];
        array=main.getQuadArray(array);

        System.out.println("Максимальное значение: "+(char) 27 + "[34m" + main.getMaxValue(array)+ (char)27+ "[39m" );
        System.out.println("Минимальное значение: "+(char) 27 + "[35m" + main.getMinValue(array)+ (char)27 + "[39m");
        System.out.println("Среднее значение: "+(char) 27 + "[36m" + main.getMidlValue(array)+ (char)27 + "[39m");
    }
    private int[][] getQuadArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]= (int) (new Date().getTime()%(17+(j+i*2)));
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print((char) 27 + "[37m" + array[i][j]+" "+ (char)27 + "[39m");
            }
        }
        System.out.println("");

        return array;

    }

    private int getMaxValue(int[][] array){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max<array[i][j]){
                    max=array[i][j];
                }
            }
        }
        return max;
    }
    private int getMinValue(int[][] array){
        int min = 2147483647;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (min>array[i][j]){
                    min=array[i][j];
                }
            }
        }
        return min;
    }
    private int getMidlValue(int[][] array){
        int mid = 0;
        int count=0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                mid = mid+array[i][j];
                count++;
                if (count==array.length*array.length){
                    mid = mid/count;
                }
            }
        }
        return mid;
    }

}
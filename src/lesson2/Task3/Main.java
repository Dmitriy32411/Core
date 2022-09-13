package lesson2.Task3;
public class Main {


    public static void main(String[] args) {
        System.out.println(new Main().fuzzySearch("ca6$$#_rtwheel","car"));
        System.out.println(new Main().fuzzySearch("cartwheel","cwhl"));
        System.out.println(new Main().fuzzySearch("cartwheel","cartwheel"));
        System.out.println(new Main().fuzzySearch("cartwheel","cwhee"));
        System.out.println(new Main().fuzzySearch("cartwheel","cwheeel"));
        System.out.println(new Main().fuzzySearch("cartwheel","lw"));

    }
    private boolean fuzzySearch (String mapSearch, String search){

        char[] searchMass = search.toCharArray();
        int[] counter = new int[search.length()];

        for (int i = 0; i < search.length(); i++) {
            if (mapSearch.contains(String.valueOf(searchMass[i]))){
                counter[i]=mapSearch.indexOf(searchMass[i]);
                mapSearch=mapSearch.replaceFirst(String.valueOf(searchMass[i]), "");
            }
        }
        if (testSortArray(counter)){
            return true;
        }
        return false;
    }
    boolean testSortArray(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]){
                return false;
            }
        }
        if (temp==0){
            return true;
        }
        return false;
    }
}
import java.util.Arrays;


public class BinarySearch {

    public static void main(String[] args) {
        int[] whitelist = {2, 3, 5, 5, 6, 9, 9, 9, 11};


        Arrays.sort(whitelist);
        
        int[] uniqueWhitelist = removeDuplicates(whitelist);

        for (int num : uniqueWhitelist) {
            System.out.println(num);
        }
    
       
    }

    public static int[] removeDuplicates(int[] sortedArray) {
   
    

        if (sortedArray.length == 0) return new int[0];

        if (sortedArray.length == 1) return sortedArray;

        int uniqueCount = 1;
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[i - 1]) {
                uniqueCount++;
            }
        }

        int[] uniqueArray = new int[uniqueCount];
        uniqueArray[0] = sortedArray[0];
        int index = 1;

        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[i - 1]) {
                uniqueArray[index++] = sortedArray[i];
            }
        }

        return uniqueArray;
    }
}


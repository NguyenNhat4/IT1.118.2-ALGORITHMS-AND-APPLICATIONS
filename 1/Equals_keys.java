import java.util.Arrays;

// Equal keys. Add to BinarySearch a static method rank() that takes a key and 
// a sorted array of int values (some of which may be equal) as arguments and returns the 
// number of elements that are smaller than the key and a similar method count() that 
// returns the number of elements equal to the key. Note : If i and j are the values returned 
// by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in 
// the array that are equal to key.

public class BinarySearch {

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 2, 3, 3, 3, 4, 5, 5};

        Arrays.sort(whitelist);

        int key = 3;
        System.out.println("Rank of " + key + ": " + rank(key, whitelist));  
        System.out.println("Count of " + key + ": " + count(key, whitelist)); 
    }

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static int count(int key, int[] a) {
        int rank = rank(key, a);
        int count = 0;
        for (int i = rank; i < a.length && a[i] == key; i++) {
            count++;
        }
        return count;
    }
}

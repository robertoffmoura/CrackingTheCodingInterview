/*
Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string.
EXAMPLE
Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
Output: 4
*/

public class SparseSearch {
    static int next(String[] array, int i) {
        int j;
        for (j=i+1; j<array.length; j++) {
            if (array[j].length() != 0) return j;
        }
        return j;
    }

    static int previous(String[] array, int i) {
        int j;
        for (j=i-1; j>=0; j--) {
            if (array[j].length() != 0) return j;
        }
        return j;
    }

    static int modifiedBinarySearch(String[] array, String string) {
        return modifiedBinarySearch(array, string, 0, array.length - 1);
    }

    static int modifiedBinarySearch(String[] array, String string, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right)/2;
        if (array[mid].length() == 0) mid = next(array, mid);
        if (array[mid].compareToIgnoreCase(string) > 0) return modifiedBinarySearch(array, string, left, previous(array, mid));
        else if (array[mid].compareToIgnoreCase(string) < 0) return modifiedBinarySearch(array, string, next(array, mid), right);
        else return mid;
    }

    public static void main(String[] args) {
        String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(modifiedBinarySearch(array, "ball"));
    }
}

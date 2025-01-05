import java.util.Scanner;

public class majorityElement {
    static int[] scanArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    static int findMajorityElement(int[] array) {
        int n = array.length;

        for (int i=0; i<n; i++) {
            int matching = 0;
            int nonMatching = 0;
            for (int j=i+1; j<n; j++) {
                if (array[j] == array[i]) matching++;
                else nonMatching++;
                if (nonMatching > matching) break;
            }
            if (nonMatching > matching) continue;
            for (int j=0; j<i+1; j++) {
                
            }
        }

    }

    public static void main(String[] args) {
        int[] array = scanArray();

        int result = findMajorityElement(array);

        System.out.println(result);
    }
}

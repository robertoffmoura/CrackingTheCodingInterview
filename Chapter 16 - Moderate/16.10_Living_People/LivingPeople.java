import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/*
Given a list of people with their birth and death years, implement a method to compute the year with the most number of people alive. You may assume that all people were born between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should be included in that year's count. For example, Person (birth = 1908, death = 1909) is included in the counts for both 1908 and 1909.
*/

public class LivingPeople {
    static int[] years = new int[101];
    static void saveDates(int birth, int death) {
        for (int i=birth; i<= death; i++) {
            years[i-1900]++;
        }
    }
    static int getYear() {
        int max = 1900;
        for (int i=1900; i<=2000; i++) {
            if (years[i-1900] > years[max-1900]) max = i;
        }
        return max;
    }

    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    static void saveDates2(int birth, int death) {
        if (!arrayList.contains(birth)) arrayList.add(birth);
        if (hash.containsKey(birth)) hash.replace(birth, hash.get(birth) + 1);
        else hash.put(birth, 1);
        if (!arrayList.contains(death+1)) arrayList.add(death+1);
        if (hash.containsKey(death+1)) hash.replace(death+1, hash.get(death+1) - 1);
        else hash.put(death+1, -1);
    }
    static int getYear2() {
        Collections.sort(arrayList);
        int max = 0;
        int aliveCount = 0;
        int year = 1900;
        for (int i=0; i<arrayList.size(); i++) {
            aliveCount += hash.get(arrayList.get(i));
            if (aliveCount > max) {
                max = aliveCount;
                year = arrayList.get(i);
            }
        }
        return year;
    }

    static int[] year = new int[102]; //My solution + book's optimization
    static void saveDates3(int birth, int death) {
        year[birth-1900]++;
        year[death+1-1900]--;
    }
    static int getYear3() {
        int yearMax = 1900;
        int max = 0;
        int count = 0;
        for (int i=1900; i<=2000; i++) {
            count += year[i-1900];
            if (count > max) {
                max = count;
                yearMax = i;
            }
        }
        return yearMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int birth = sc.nextInt();
            int death = sc.nextInt();
            saveDates3(birth, death);
        }
        int year = getYear3();
        System.out.println(year);
    }
}

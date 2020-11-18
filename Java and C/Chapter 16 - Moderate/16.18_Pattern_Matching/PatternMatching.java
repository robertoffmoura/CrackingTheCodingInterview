import java.util.Scanner;

/*
You are given two strings, pattern and value. The pattern string consists of just the letters a and b, describing a pattern within a string. For example, the string catcatgocatgo matches the pattern aabab (where cat is a and go is b). It also matches patterns like a, ab, and b. Write a method to determine if value matches pattern.
*/

public class PatternMatching {
    static boolean allStringsMatch(String pattern, String value, int aCount, int bCount, int aSize, int bSize, int aFirstOccurence, int bFirstOccurence) {
        String a = value.substring(aFirstOccurence * bSize, aFirstOccurence * bSize + aSize);
        String b = value.substring(bFirstOccurence * aSize, bFirstOccurence * aSize + bSize);
        int valueIndex = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                if (!a.equals(value.substring(valueIndex, valueIndex + aSize))) return false;
                valueIndex += aSize;
            } else {
                if (!b.equals(value.substring(valueIndex, valueIndex + bSize))) return false;
                valueIndex += bSize;
            }
        }
        return true;
    }

    static boolean allStringsMatch(String value, int bCount) {
        int bSize = value.length()/bCount;
        if (bSize * bCount != value.length()) return false;
        String b = value.substring(0, bSize);
        for (int i=bSize; i<value.length(); i+=bSize) {
            if (!b.equals(value.substring(i, i + bSize))) return false;
        }
        return true;
    }

    static boolean patternMatches(String pattern, String value) {
        if (pattern.length() == 1) return true;

        int aCount = 0;
        int bCount = 0;
        int aFirstOccurence = -1;
        int bFirstOccurence = -1;
        for (int i=0; i<pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
                if (aFirstOccurence == -1) aFirstOccurence = i;
            }
            else if (pattern.charAt(i) == 'b') {
                bCount++;
                if (bFirstOccurence == -1) bFirstOccurence = i;
            }
        }

        if (aCount == 0) return allStringsMatch(value, bCount);
        if (bCount == 0) return allStringsMatch(value, aCount);

        for (int aSize = 1; aSize * aCount <= value.length(); aSize++) {
            for (int bSize = 1; aSize * aCount + bSize * bCount <= value.length(); bSize++) {
                if (aSize * aCount + bSize * bCount < value.length()) continue;
                if (allStringsMatch(pattern, value, aCount, bCount, aSize, bSize, aFirstOccurence, bFirstOccurence)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.next();
        String value = sc.next();
        System.out.println(patternMatches(pattern, value));
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/*
Each year, the government releases a list of the 10000 most common baby names and their frequencies (the number of babies with that name). The only problem with this is that some names have multiple spellings. For example, "John" and "Jon" are essentially the same name but would be listed separately in the list. Given two lists, one of names/frequencies and the other of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each name. Note that if John and jon are synonyms, and Jon and Johnny are synonyms, then John and Johnny are synonyms. (It is both transitive and symmetric.) In the final list, any name can be used as the "real" name.
EXAMPLE
Input:
    Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
    Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
Output: John (27), Kris (36)
*/

public class BabyNames {
    ArrayList<Name> roots = new ArrayList<Name>();
    HashMap<String, Name> names = new HashMap<String, Name>();
    Scanner sc = new Scanner(System.in);

    class Name {
        String text;
        Name parent;
        int frequency;
        public Name(String text, int frequency) {
            this.text = text;
            this.frequency = frequency;
        }

        public void union(Name otherName) {
            Name root = this;
            while (root.parent != null) root = root.parent;
            Name otherRoot = otherName;
            while (otherRoot.parent != null) otherRoot = otherRoot.parent;
            roots.remove(otherRoot);
            otherRoot.parent = root;
            root.frequency += otherRoot.frequency;
            otherRoot.frequency = 0;
        }

        @Override
        public String toString() {
            return text + " (" + frequency + ")";
        }
    }

    public Name getName(String text) {
        Name name = names.get(text);
        if (name == null) name = addName(text, 0);
        return name;
    }

    public Name addName(String text, int frequency) {
        Name name = new Name(text, frequency);
        roots.add(name);
        names.put(text, name);
        return name;
    }

    public void scanFrequency() {
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String text = sc.next();
            int frequency = sc.nextInt();
            addName(text, frequency);
        }
    }

    public void scanEquivalences() {
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String text1 = sc.next();
            String text2 = sc.next();
            Name name1 = getName(text1);
            Name name2 = getName(text2);
            name1.union(name2);
        }
    }

    public void printResults() {
        for (int i=0; i<roots.size()-1; i++) {
            Name name = roots.get(i);
            System.out.print(name + ", ");
        }
        Name name = roots.get(roots.size()-1);
        System.out.println(name);
    }



    public static void main(String[] args) {
        BabyNames b = new BabyNames();
        b.scanFrequency();
        b.scanEquivalences();
        b.printResults();
    }

}

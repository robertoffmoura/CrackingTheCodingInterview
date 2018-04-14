import java.util.EmptyStackException;

/*
Describe how you could use a single array to implement three stacks.
*/

public class ThreeInOne {
    //Let's assume arraySize is a multiple of partitions
    public int arraySize = 12;
    public int partitions = 3;
    int index[] = new int[partitions];
    int array[] = new int[arraySize];

    public ThreeInOne() {
        for (int i=0; i<partitions; i++) {
            index[i] = 0;
        }
    }

    int getArrayIndex(int i) {
        return i*(arraySize/partitions)+index[i];
    }

    void pushToIthStack(int i, int value) {
        if (index[i] < arraySize/partitions) {
            array[getArrayIndex(i)] = value;
            index[i]++;
        } else {
            System.out.println("Stack " + i + " is full");
        }
    }

    int popFromIthStack(int i) {
        if (index[i] > 0) {
            index[i]--;
            int value = array[getArrayIndex(i)];
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args) {
        ThreeInOne t = new ThreeInOne();
        t.pushToIthStack(0,1);
        t.pushToIthStack(0,2);
        t.pushToIthStack(0,3);
        t.pushToIthStack(0,4);
        t.pushToIthStack(0,5);
        t.pushToIthStack(1,5);
        t.pushToIthStack(1,6);
        t.pushToIthStack(1,7);
        t.pushToIthStack(1,8);
        t.pushToIthStack(1,9);
        t.pushToIthStack(2,10);
        t.pushToIthStack(2,11);
        t.pushToIthStack(2,12);
        t.pushToIthStack(2,13);
        t.pushToIthStack(2,14);
        System.out.println(t.popFromIthStack(0));
        System.out.println(t.popFromIthStack(0));
        System.out.println(t.popFromIthStack(1));
        System.out.println(t.popFromIthStack(1));
        System.out.println(t.popFromIthStack(2));
        System.out.println(t.popFromIthStack(2));
    }
}

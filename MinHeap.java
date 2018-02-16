public class MinHeap {
    int array[] = new int[255];
    int index = 0;

    int left(int i) {
        return 2*i+1;
    }
    int right(int i) {
        return 2*i+2;
    }
    int parent(int i) {
        return (i-1)/2;
    }

    void add(int value) {
        int i = index;
        array[i] = value;
        while (array[i] < array[parent(i)]) {
            int temp = array[i];
            array[i] = array[parent(i)];
            array[parent(i)] = temp;
            i = parent(i);
        }
        index++;
    }

    int getMin() {
        int value = array[0];
        index--;
        array[0] = array[index];
        array[index] = 0;
        int i = 0;
        while ((array[left(i)] < array[i] || array[right(i)] < array[i])) {
            if (left(i) >= index) break;
            if (right(i) >= index) {
                if (array[left(i)] < array[i]) {
                    int temp = array[i];
                    array[i] = array[left(i)];
                    array[left(i)] = temp;
                    i = left(i);
                }
                break;
            }
            if (array[left(i)] < array[right(i)]) {
                int temp = array[i];
                array[i] = array[left(i)];
                array[left(i)] = temp;
                i = left(i);
            } else {
                int temp = array[i];
                array[i] = array[right(i)];
                array[right(i)] = temp;
                i = right(i);
            }
        }
        return value;
    }

    void print() {
        int n = 1;
        for (int i=0; i<Math.pow(2,3)-1; i++) {
            System.out.print(array[i]);
            if (i == Math.pow(2, n) - 2) {
                System.out.println("");
                n++;
            }
        }
    }

    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        m.add(5);
        m.print();
        m.add(3);
        m.print();
        m.add(4);
        m.print();
        m.add(6);
        m.print();
        m.add(2);
        m.print();
        System.out.println("min = " + m.getMin());
        m.print();
        System.out.println("min = " + m.getMin());
        m.print();
        System.out.println("min = " + m.getMin());
        m.print();
        System.out.println("min = " + m.getMin());
        m.print();
        System.out.println("min = " + m.getMin());
        m.print();

    }
}

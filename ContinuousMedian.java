import java.util.Scanner;

public class ContinuousMedian {
    static int count = 0;
    static BinarySearchTree.Node left = 0;
    static BinarySearchTree.Node right = 0;
    static BinarySearchTree.Node center = 0;

    BinarySearchTree tree = new BinarySearchTree();

    static double updateMedian(double v) {
        BinarySearchTree.Node value = tree.add(v);
        count++;
        if (count%2 == 1) {
            if (left.value <= value.value && value.value <= right.value) {
                center = value;
            } else if (value.value < left.value) {
                center = left;
                left = center.getLeft();
            } else if (right.value < value.value) {
                center = right;
                right = center.getRight();
            }
            return center.value;
        }
        if (value.value < left.value) {
            right = center;
        } else if (left.value <= value.value && value.value < center.value) {
            left = value;
            right = center;
        } else if (center.value <= value.value && value.value <= right.value) {
            right = value;
            left = center;
        } else if (right.value < value.value) {
            left = center;
        }
        return (left.value + right.value)/2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double d = sc.nextDouble();
            System.out.println(updateMedian(d));
        }
    }
}



public class Cheat {
    public class myClass {
        int property1;
        int property2;
        public myClass(int property1, int property2) {
            this.property1 = property1;
            this.property2 = property2;
            //You can omit the "this." if the property name is different from the argument of the constructor
        }
        public String toString() {
            return "(" + property1 + ", " + property2 + ")";
        }
    }

    public static void main(String[] args) {

    }
}

import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
String string = sc.next();
String string = sc.nextLine();

char c = string.charAt(3);

String string = "cheat";
string.substring(0, 2); //"ch"
string.substring(2); //"eat"

import java.util.Stack;
Stack<Integer> integers = new Stack<Integers>();

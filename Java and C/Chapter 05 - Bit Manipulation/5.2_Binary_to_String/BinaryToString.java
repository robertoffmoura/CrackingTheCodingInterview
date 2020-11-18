import java.lang.StringBuilder;

/*
Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
*/

public class BinaryToString {
    static String binaryRepresentation(double d) {
        if (d < 0 || d > 1) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        d *= 2;
        for (int i=0; i<32; i++) {
            if (d >= 1) {
                sb.append("1");
                d -= 1.0;
            } else {
                sb.append("0");
            }
            if (d == 0) return sb.toString();
            d *= 2;
        }
        return "ERROR";
    }
    public static void main(String[] args) {
        System.out.println(binaryRepresentation(0.875));
        System.out.println(binaryRepresentation(0.72));
    }
}

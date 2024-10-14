public class Task115 {
    public static void main(String[] args) {
        String a = "Wow";                         // Change from String a = new String("Wow");
        String b = "Wow";
        String c = a;
        String d = "Wow!";                        // Change from String d = c; to make the line 9 true.

        boolean b1 = a == b;
        boolean b2 = d.equals(b + "!");
        boolean b3 = !c.equals("SomethingElse");  // Change from boolean b3 = !c.equals(a);

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }
    }

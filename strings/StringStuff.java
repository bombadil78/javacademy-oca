public class StringStuff {

    public static void convert() {
        // String => primitive
        // primitive => String
        int i1 = Integer.parseInt("1");
        String s = "" + i1; // OR
        Integer.toString(i1);

        // primitive => wrapper
        // Wrapper => primitive
        Integer i2 = Integer.valueOf(2);
        int i3 = i2.intValue();

        // String => Wrapper
        // Wrapper => String
        Integer i4 = Integer.valueOf("4");
        String s2 = i4.toString();
    }

    public static void compare() {
        String s1 = "Hello World";
        String s2 = "orl";
        System.out.println(s1.startsWith(s2, 7));

        String s3 = "Good Night";
        System.out.println(s1.regionMatches(5, s3, 4, 1));
    }

    public static void manipulate() {
        String s = "Hello World";

        // EXTRACTION
        System.out.println(s.substring(1)); // to the end
        System.out.println(s.substring(2, 3)); // in-between (start inclusive, to exclusive)
        // System.out.println(s.substring(3, -2)); // negative indices not allowed, e.g. from three to the second last

        // SEARCH
        System.out.println(s.indexOf('o')); // find from beginning
        System.out.println(s.lastIndexOf('o'));  // find from end
        System.out.println(s.indexOf('o', 5)); // find from position
        StringBuilder sb = new StringBuilder("ll");
        System.out.println(s.contains(sb)); // Contains works on any CharSequence (!)

        // REPLACE
        String tt, t = s;
        do {
            tt = t;
            t = t.replaceFirst("o", "");
        } while (!t.equals(tt));
        System.out.println(t);
    }

    public static void main(String args[]) {
        convert();
        compare();
        manipulate();
    }
}

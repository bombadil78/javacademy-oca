public class StaticInnerStuff {

    private int foo;
    private static final int BAR = 0;

    private static class Inside implements Barable {

        @Override
        public void bar() {
            // Can access outer stuff
            System.out.println(StaticInnerStuff.BAR);
        }

        public static class Inside2 {
            public static class Inside3 {

            }
        }
    }
}

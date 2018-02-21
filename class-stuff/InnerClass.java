public class InnerClass {

    private final int someValue = 99;

    public void foo() {
        // #2: From within => like normal class
        Inner inner = new Inner();
    }

    class Inner {

        public void bar() {
            // #3: Inside-to-outside => use <OuterClass>.this
            System.out.println(InnerClass.this.someValue);
        }
    }

    public static void main(String[] args) {
        InnerClass in = new InnerClass();

        // #1: From outside => use <someReference>.new
        // obj.new => use in as the context for the new class
        InnerClass.Inner inside = in.new InnerClass.Inner();
    }
}

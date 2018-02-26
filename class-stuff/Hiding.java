public class Hiding {
    int x  = 100;
    static int y = 100;

    static void foo() {
        System.out.println("Hiding");
    }

    void bar() {
        System.out.println("Hiding");
    }

    public static void main(String[] args) {
        // #1 member field (non-static)
        Hiding h1 = new Hiding();
        System.out.println(h1.x);
        Hiding h2 = new HidingChild();
        System.out.println(h2.x);  // Fields are statically bound - this will emit Hiding's x
        HidingChild h3 = new HidingChild();
        System.out.println(h3.x);  // Fields are statically bound - this will emit HidingChild's x

        // #2 class field (static)
        Hiding h4 = new Hiding();
        System.out.println(h4.y);
        Hiding h5 = new HidingChild();
        System.out.println(h5.y);  // Fields are statically bound - this will emit Hiding's x
        HidingChild h6 = new HidingChild();
        System.out.println(h6.y);  // Fields are statically bound - this will emit HidingChild's x

        // #3 member method (non-static) => dynamic binding
        Hiding h7 = new Hiding();
        h7.bar();
        Hiding h8 = new HidingChild();
        h8.bar();
        HidingChild h9 = new HidingChild();
        h9.bar();

        // #4 class method (static)
        Hiding h10 = new Hiding();
        h10.foo();
        Hiding h11 = new HidingChild();
        h11.foo();
        HidingChild h12 = new HidingChild();
        h12.foo();
    }
}

class HidingChild extends Hiding {
    int x = 200;
    static int y = 200;

    static void foo() {
        System.out.println("HidingChild");
    }

    void bar() {
        System.out.println("HidingChild");
    }
}

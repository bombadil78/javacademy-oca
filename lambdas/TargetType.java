public class TargetType {

    public void foo(A a) {
        System.out.println("A");
    }

    public void foo(B b) {
        System.out.println("B");
    }

    public void foo(C c) {
        System.out.println("C");
    }

    static interface A {
        void accept(int i);
    }

    static interface B {
        void accept(int i);
    }

    static interface C {
        void accept(int x, int y);
    }

    public static void main(String[] args) {
        TargetType tt = new TargetType();
        // tt.foo((x) -> {});  Will not compile, ambiguous
        tt.foo((x, y) -> {}); // Compiles, only C applies
    }
}


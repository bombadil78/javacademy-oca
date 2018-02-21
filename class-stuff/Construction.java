public class Construction {

    public static void main(String args[]) {
        A a = new A(1,1 );
    }
}

class A {
    public A(int i, int j) {}
}

class B extends A {

    public B(int i) {
        // System.out.println(); not allowed
        // Must call super before anything else...
        super(i, i);
    }
}

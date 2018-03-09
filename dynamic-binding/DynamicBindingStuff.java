public class DynamicBindingStuff {

}

class A {
    protected void foo() {
	System.out.println("A");
    }

    public static void main(String[] args) {
	B b = new B();
	A a = b;
	a.foo();
    }
}

class B extends A {
    protected void foo() {
	System.out.println("B");
    }
}

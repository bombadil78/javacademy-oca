public class MyClass {

    private static void myPrivateStatic() {}

    private String myPrivate() {
        return new String("s");
    }

    protected String myProtected() {
        return "";
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        MyClass.myPrivateStatic();
        mc.myPrivate();
        mc.myProtected();
    }
}

class Daddy {
    protected Object foo() throws RuntimeException { return null; }
    protected String bar() { return null; }
    protected String fooBar() { return null; }

    protected static void fooBaz() {}
}


class Son extends Daddy {

    @Override
    protected String foo() throws RuntimeException { return null; }

    // Will not compile: Same method signature, but not an override
    // protected Object bar() { return null; }

    // Will not compile: Same method signature, but not an override
    // protected String fooBar() throw Exception { return null; }

    // Will not compile: Same method signature, but not an override
    // protected void fooBaz() {}

    // hiding
    // protected static void fooBaz() {}
}

interface MyDog {
    String RACE = "";

    static String foobar() { return ""; }

    String bark();

    default void eat() {
        System.out.println("");
    }
}

interface MySchaefer extends MyDog {

    default void eat() {
        System.out.println();
    }
}

interface Human {
    default void speak() {}
    void walk();
}

interface Robot {
    default void speak() {}
    void walk();
}

class Android implements Human, Robot {
    // Compiler enforces override of speak() to choose an implementation
    // public void speak() {}
    // public void walk() {}
}

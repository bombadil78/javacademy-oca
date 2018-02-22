public class Exceptional {

    // error => no catch-or-specify
    public void foo() {
        throw new MyError();
    }

    // unchecked => no catch-or-specify
    public void fooBar() throws MyUncheckedException {
        throw new MyUncheckedException();
    }

    // checked => DO catch-or-specify
    public void bar() throws MyCheckedException {
        throw new MyCheckedException();
    }

    // checked => DO catch-or-specify
    public void barBar() throws MyOtherCheckedException {
        throw new MyOtherCheckedException();
    }

    class MyCheckedException extends Exception {}
    class MyOtherCheckedException extends Throwable {}

    class MyError extends Error {}

    class MyUncheckedException extends RuntimeException {}

    public static void main(String[] args) {
        Exceptional e = new Exceptional();
        e.fooBar();
    }
}

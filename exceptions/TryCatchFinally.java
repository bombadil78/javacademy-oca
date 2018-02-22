public class TryCatchFinally {

    private void foo() throws MyCheckedException {}
    private void bar() throws MyOtherCheckedException {
        throw new MyOtherCheckedException();
    }

    public static final void main(String[] args) throws MyCheckedException {
        try {
            TryCatchFinally tcf = new TryCatchFinally();
            tcf.foo();
            tcf.bar();
        } catch(MyCheckedException | MyOtherCheckedException ex) {
            System.out.println(ex);
        }


        try {
            throw new MyCheckedException();
        } catch (MyCheckedException ex) {
            System.out.println(ex);
            throw ex;
        } finally {
            System.out.println("Finally is always executed, no matter whether an exception passed up the call stack or not ...");
        }
        // Is a compile-time error
        // System.out.println("Never here...");
    }
}

class MyCheckedException extends Exception {}
class MyOtherCheckedException extends Exception {}
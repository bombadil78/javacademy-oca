public class Varargs {

    public void callMe(Object... objects) {
        // Used like an array
        Object[] objs = objects;
        System.out.println(objs.length);
    }

    public static void main(String[] args) {
        Varargs varargs = new Varargs();
        varargs.callMe();
        varargs.callMe(new Object());
        varargs.callMe(new Object(), new Object(), new Object());
    }
}

import java.util.Iterator;

public class InnerStuff {

    public static void main(String[] args) {
        class X {
            public int foo;
            public void bar() {
                System.out.println("bar()");
            }
        }

        X x = new X();
        x.bar();

        Iterable<Integer> it = new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };

        // Lambda can be used to implements single
        Iterable<Integer> it2 = () -> null;
    }

}

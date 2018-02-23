import java.util.function.Consumer;

public class Scope {

    private Consumer<Integer> anonymousChangeInside() {
        int x = 1;

        return new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                // x++; Will not compile
            }
        };
    }

    private Consumer<Integer> anonymousChangeOutside() {
        int x = 1;

        Consumer<Integer> consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println(x);
            }
        };

        // x++; Will not compile

        return consumer;
    }

    public static void main(String[] args) {
        Scope scope = new Scope();
        scope.anonymousChangeInside();
        scope.anonymousChangeOutside();
    }
}

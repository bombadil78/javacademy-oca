import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Scope {

    int x = 0;

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

    private Consumer<Integer> lambdaInside() {
        int x = 1;

        return (i) -> {
            // System.out.println(x++); Will not compile
        };
    }

    private Consumer<Integer> lambdaOutside() {
        int x = 1;

        Consumer<Integer> consumer = (i) -> {
            System.out.println(x);
        };

        // x++; Will not compile

        return consumer;

    }

    private void blockVsLambda() {
        int y = 0;

        IntConsumer lambda = (i) -> {
            // int y = 100;  // Lambdas do NOT introduce a new scope -> y is already defined
            System.out.println(this.x);
            System.out.println(y); // You can access local fields from outside ...
            // System.out.println(y++); // ... but you cannot change them -> must be effectively final
        };
        IntConsumer anonymous = new IntConsumer() {
            int x = 999;  // Anonymous classes create an own scope -> they have their own this
            int y = 888; // Anonymous classes create an own scope -> like in block scope

            @Override
            public void accept(int value) {
                System.out.println(this.x);
            }
        };
        lambda.accept(0);
        anonymous.accept(0);
    }

    public static void main(String[] args) {
        Scope scope = new Scope();
        scope.anonymousChangeInside();
        scope.anonymousChangeOutside();
        scope.lambdaInside();
        scope.lambdaOutside();

        scope.blockVsLambda();
    }
}

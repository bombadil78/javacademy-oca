import java.util.Arrays;
import java.util.List;

public class ListStuff {

    private static void creation() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        // Remark: Arrays.asList calls the private ArrayList(someArr) constructor

        // array is captured

        // no leaking ...
        System.out.println(ints);
        Object[] data = ints.toArray();
        data[0] = 999;
        System.out.println(ints);
    }

    private static void positionalAccess() {

    }

    private static void iteration() {

    }

    private static void rangeViews() {

    }

    private static void api() {

    }

    public static final void main(String[] args) {
        creation();
    }
}

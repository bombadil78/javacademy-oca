import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStuff {

    private static void positionalAccess() {
        List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        l.get(0);  // #1 get
        Integer newValue = 99;
        Integer oldValue = l.set(0, 99); // #2 set
        System.out.println(String.format("Replacing %d with %d", oldValue, newValue));

        System.out.println(String.format("Removed %d", l.remove(4))); // #3 remove
    }

    private static void search() {
        List<Integer> l = Stream.iterate(0, x -> x + 1).limit(100).collect(Collectors.toList());
        System.out.println(l.indexOf(99));
        Collections.shuffle(l);
        System.out.println(l.indexOf(99));
    }

    private static void rangeViews() {
        List<Integer> l = Stream.iterate(0, x -> x + 1).limit(10).collect(Collectors.toList());

        while (l.size() > 0) {
            List<Integer> part = l.subList(0, 2);
            System.out.println(part);
            part.clear();
        }

        List<Integer> ll = Stream.iterate(0, x -> x + 1).limit(10).collect(Collectors.toList());
        List<Integer> lll = ll.subList(0, ll.size());
        List<Integer> llll = lll.subList(0, lll.size());
    }

    private static void api() {

    }

    public static final void main(String[] args) {
        positionalAccess();
        search();
        rangeViews();
    }
}

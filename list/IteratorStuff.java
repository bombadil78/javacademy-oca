import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IteratorStuff {

    private static void iterate() {
        Collection<Integer> c = Arrays.asList(1, 2, 3);
        for (Iterator<Integer> it = c.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        for (Integer i : c) {
            System.out.println(i);
        }

        c.forEach(System.out::println);

        c.iterator().forEachRemaining(x -> System.out.println(x));
    }

    private static void iterateMore() {
        List<Integer> l = Arrays.asList(1, 2, 3);
        ListIterator<Integer> li = l.listIterator();

        System.out.println(li.next());
        System.out.println(li.previous());

        System.out.println(li.next());
        System.out.println(li.previous());

        System.out.println(li.next());
        System.out.println(li.previous());
    }

    private static void listIterate() {
        List<Integer> l = new ArrayList(Arrays.asList(1, 2, 3));
        ListIterator<Integer> li = l.listIterator();

        while (li.hasNext()) {
            System.out.println(String.format("Element at %d: %d", li.nextIndex(), li.next()));
        }

        while (li.hasPrevious()) {
            System.out.println(String.format("Element at %d: %d", li.previousIndex(), li.previous()));
        }
    }

    private static void listIterateAndAdd() {
        List<Integer> l = Stream.iterate(0, x -> x + 1).limit(10).collect(Collectors.toList());
        ListIterator<Integer> li = l.listIterator();
        System.out.println(l);

        while (li.hasNext()) {
            Integer i = li.next();
            if (i.intValue() % 2 == 0) {
                li.add(i);  // adds element before the element that would be returned by next()
                li.next();
            }
        }

        System.out.println(l);
    }

    private static void listIterateAndRemove() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        Collections.reverse(l);
        ListIterator<Integer> li = l.listIterator(3);

        while (li.hasNext()) {
            Integer i = li.next();
            System.out.println(i);
            if (i == 4) {
                li.remove();
            }
        }

        System.out.println(l);
    }

    public static void main(String[] args) {
        iterate();
        iterateMore();
        listIterate();
        listIterateAndAdd();
        listIterateAndRemove();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionStuff {

    private static void addDoesAppend() {
        Collection<Boolean> c = new ArrayList<>();
        c.add(Boolean.FALSE);
        c.add(Boolean.TRUE);
        System.out.println(c);

        Collection<Integer> d1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collection<Integer> d2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        d1.addAll(d2);
        System.out.println(d1);
    }

    private static void removeVsRemoveAll() {
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(null);
        c.add(null);
        c.add(null);
        c.add(null);
        c.add(null);
        c.add(2);

        c.remove(null); // only removes first null
        System.out.println(c);

        Collection<Integer> d = new ArrayList<>();
        d.add(null);
        c.removeAll(d); // removes all nulls
        System.out.println(c);
    }

    private static void toArrayOptions() {
        Collection<String> c = Arrays.asList("a", "b", "c");

        Object[] arr1 = c.toArray();
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = new String[c.size()];
        c.toArray(arr2);  // to get some type-safety
        System.out.println(Arrays.toString(arr2));
    }

    private static void retainAllForIntersection() {
        Collection<Integer> i = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collection<Integer> j = new ArrayList<>(Arrays.asList(2, 3, 4));
        i.retainAll(j);
        System.out.println(i);
    }

    public static void main(String[] args) {
        addDoesAppend();
        removeVsRemoveAll();
        toArrayOptions();
        retainAllForIntersection();
    }
}

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListImplementations {

    private static void races() {
        Race appendArrayList = new Append(new ArrayList<>());
        appendArrayList.race(200 * 1000);

        // Faster for insert at front
        Race enqueueArrayList = new Enqueue(new ArrayList<>());
        enqueueArrayList.race(200 * 1000);

        Race appendLinkedList = new Append(new LinkedList<>());
        appendLinkedList.race(200 * 1000);

        // Slow for insert at front
        Race enqueueLinkedList = new Enqueue(new LinkedList<>());
        enqueueLinkedList.race(200 * 1000);

        // Prevent array copies with appropriate initial capacity
        Race enqueueArrayListBetter = new Append(new ArrayList<>(200 * 1000));
        enqueueArrayListBetter.race(200 * 1000);
    }

    private static void copyOnWrite() {
        List<Integer> list = Stream.iterate(0, x -> x + 1).limit(10000).collect(Collectors.toList());
        List<Integer> copyOnWrite = new CopyOnWriteArrayList<>(list);

        for (int i = 0; i < copyOnWrite.size(); i++) {
            copyOnWrite.set(i, i + 1);
        }
    }

    public static void main(String[] args) {
        races();
        copyOnWrite();
    }

    private static abstract class Race {

        protected final List<Integer> list;

        public Race(List<Integer> list) {
            this.list = list;
        }

        protected abstract void doIt(int index);

        public void race(int times) {
            Instant before = Instant.now();
            for (int i = 0; i < times; i++) {
                doIt(i);
            }
            Instant after = Instant.now();
            Duration duration = Duration.between(before, after);
            System.out.println(duration.getNano() / (1000 * 1000));
        }

    }

    private static class Enqueue extends Race {

        public Enqueue(List<Integer> list) {
            super(list);
        }

        @Override
        protected void doIt(int index) {
            this.list.add(0, index);
        }
    }

    private static class Append extends Race {

        public Append(List<Integer> list) {
            super(list);
        }

        @Override
        protected void doIt(int index) {
            this.list.add(index);
        }
    }
}

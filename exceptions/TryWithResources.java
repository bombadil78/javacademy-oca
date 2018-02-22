import java.io.Closeable;

public class TryWithResources {

    public static void main(String[] args) throws Exception {

        try (MyResource m = new MyResource()) {
            System.out.println(m.toString());
        }

        try (MyOtherResource mor = new MyOtherResource()) {
            System.out.println(mor);
        }

        try (MyResource m = new MyResource()) {
            System.out.println(m.toString());
            throw new Exception();
        }
    }
}

class MyResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing my resource now...");
    }
}

class MyOtherResource implements Closeable {

    @Override
    public void close() {
        System.out.println("Closing my other resource now...");
    }
}

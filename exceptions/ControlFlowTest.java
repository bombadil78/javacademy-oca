public class ControlFlowTest {

    public static void main(String[] args) throws Exception {
        try {
            throw new Exception();
        } catch (RuntimeException ex) {

        } finally {
            System.out.println("here");
        }
        System.out.println("here #2");
    }
}

public class NullString {

    public static void main(String[] args) {
        System.out.println("A " + null + null + null);
        System.out.println("A ".concat(null));
    }
}

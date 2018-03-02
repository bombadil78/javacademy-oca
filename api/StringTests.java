public class StringTests {

    public static void main(String[] args) {
        String s = "aef";
        StringBuilder t = new StringBuilder("AEF");

        System.out.println("abcdefghijklmnopqrstuvwxyz".replace(s, t));
    }
}

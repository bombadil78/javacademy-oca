public class SwitchCase {

    public static void main(String[] args) {
        // String, char, Enum (string stuff) PLUS "BSI" (byte-short-int; alles überhalb byte)
        char a = 'a';
        switch (a) {
            case 'a':
            default:
        }

        byte b = 10;
        switch (b) {
            case 99: // is ok; byte is from -128 bis +127
            // case 999: nok; byte range exceeded
            default:
        }
    }
}

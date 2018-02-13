public class Bitwise {

    public static void main(String[] args) {
	int x = 0b111;
	System.out.println(x);

	// byte: 0..127, -128..-1
	
	byte b = 7; // 00000111 
	int i = ~b; // 00000111 => (flip plus 1) => 11111001 => (as unsigned) => 1111001=121 => -128 + (121 - 1) = -7
	System.out.println(b);
	System.out.println(i);
    }
}

    

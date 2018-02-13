public class Precedence {

    public static void main(String[] args) {
	int i = 7;
	boolean b;
	
	b = (boolean) (i + 1 * 10 == 17) || false;
	
	System.out.println(b);
    }
}

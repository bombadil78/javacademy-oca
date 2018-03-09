public class Errors {

    private static final Object[] objs;
    
    static {
	objs = new Object[10];
	objs[-1] = new Object();
    }
    
    public static void main(String[] args) {
	
    }
    
}

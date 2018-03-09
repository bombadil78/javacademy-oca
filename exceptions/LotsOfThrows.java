public class LotsOfThrows {

    private static void allThrow() throws Exception {
	try {
	    throw new RuntimeException("A");
	} catch (RuntimeException ex) {
	    throw new RuntimeException("B");
	} finally {
	    throw new Exception("C");
	}
    }

    private static void doNotMaskInnerException() {
	try {
	    throw new RuntimeException("A");
	} catch (RuntimeException ex) {
	    throw new RuntimeException("B");
	} finally {
	    try {
		throw new Exception("C");
	    } catch (Exception ex) {
		
	    }
	}
    }
    
    public static void main(String[] args) throws Exception {
	// allThrow(); this one masks the exception thrown in the catch-block
	doNotMaskInnerException(); // this one does not
    }
}

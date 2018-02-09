public class MoreInit{

    int i; // Will compile; field initialization is optional

    long l1 = 10;
    long l2 = 10000000000L;
    long l3 = 2147483647; // last valid integer
    long l4 = 2147483648; // Will not compile, bigger than 2^31 - 1
    // int l5 = 10L; Will not compile; possible loss in precision
    
    public void foo() {
	int j;
	int jj = 0;
	// System.out.println(i); Will not compile; local variables must be initialized
	System.out.println(jj);
    }
}

public class MoreInit{

    int i; // Will compile; field initialization is optional

     public void foo() {
	int j;
	int jj = 0;
	// System.out.println(i); Will not compile; local variables must be initialized
	System.out.println(jj);
    }
}

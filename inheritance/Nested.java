public class Nested {

    private int mine;

    public class Inside {

	public void foo() {
	    System.out.println(mine);
	}
    }

    // Static class is not bound to an instance, hence no access to its non-static fields
    public static class StaticInside {

	public void foo() {
	    // System.out.println(mine);
	}
    }
}

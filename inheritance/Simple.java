import other.*;

class Foo {
    protected int mine;
    
    private void priv() {}
    void packPriv() {}
    protected void prot() {}
    public void pub() {}

    public static int stat() {}
}

class FooBar extends Foo {
    // hides parent's mine field
    protected int mine;

    // overrides parent's prot() <= NOK
    protected void prot() {}

    // hides parent's stat() <= NOK
    public static int stat() {}
}

public class Simple {

    public static void main(String[] args) {
	Foo foo = new Foo();
	FooBar fooBar = new FooBar();
	// fooBar.priv();  <= static binding
	fooBar.packPriv();
	fooBar.prot();
	fooBar.pub();

	BarBar barBar = new BarBar();
	barBar.iCanAccess();
	// barBar.iCannotAccess(); 
    }
}

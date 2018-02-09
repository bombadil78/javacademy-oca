import foo.Foo;
import static bar.Bar.BAR;
import static bar.Bar.bar;

public class Test {

    public static void main(String[] args) {
	Foo f1 = new Foo();
	bar.Foo f2 = new bar.Foo(); // must use fully-qualified name

	/* We do not want this redundanct Bar => use static import 
	String s = Bar.BAR;
	Bar.bar();
	*/

	// Now we can use BAR and bar() without type prefix
	String s = BAR;
	bar();
    }

}

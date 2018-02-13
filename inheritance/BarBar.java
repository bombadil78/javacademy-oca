import other.Bar;

public class BarBar extends Bar {

    public void iCanAccess() {
	this.prot();
    }

    public void iCannotAccess() {
	// this.packPriv();
    }
}

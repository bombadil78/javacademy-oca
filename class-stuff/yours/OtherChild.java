package yours;

public class OtherChild extends Parent {

    public void bar() {
        System.out.println(this.i);
        System.out.println(this.j);  // Access only because we are in the same PACKAGE
    }
}

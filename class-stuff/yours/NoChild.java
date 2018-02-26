package yours;

public class NoChild {

    private Parent parent = new Parent();

    public void foo() {
        System.out.println(parent.i); // Access to package-private member
        System.out.println(parent.j); // Access to package-private member
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.i);
        System.out.println(p.j);
    }
}

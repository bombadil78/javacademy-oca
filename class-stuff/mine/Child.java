package mine;

import yours.Parent;

public class Child extends Parent {

    public void foo() {
        System.out.println(this.i);
        // System.out.println(this.j); No access of package-private fields
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        // System.out.println(p.i);  Only access to public members of another package
        // System.out.println(p.j);  Only access to public members of another package
        System.out.println(p.k);
    }
}

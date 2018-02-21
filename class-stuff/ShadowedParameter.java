public class ShadowedParameter {

    private String shadow = "x";

    // Parameter shadows field
    public void foo(String shadow) {
        // Who am i?
        System.out.println(shadow);

        // One must use this
        this.shadow = shadow;
    }

    public static void main(String[] args) {
        ShadowedParameter sp = new ShadowedParameter();
        sp.foo("y");
    }
}

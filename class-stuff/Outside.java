public class Outside implements Barable {

    @Override
    public void bar() {
        // Cannot access
        // System.out.println(StaticInnerStuff.bar);
    }
}

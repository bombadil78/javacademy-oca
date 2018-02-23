import javafx.scene.effect.Shadow;

public class Shadowing {
    int x = 0;

    class Inner {
        int x = 1;

        public void foo(int x) {
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Shadowing.this.x);
        }
    }

    public static void main(String[] args) {
        Shadowing s = new Shadowing();
        Inner i = s.new Inner();
        i.foo(2);
    }
}

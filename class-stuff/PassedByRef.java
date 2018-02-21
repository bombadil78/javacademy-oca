public class PassedByRef {

    public void foo(int x) {
        x = 1000;
        System.out.println("Inside method: " + x);
    }

    public void bar(Test test) {
        test = null;
        System.out.println("Inside method: " + test);
    }

    public void fooBar(AnotherTest anotherTest) {
        anotherTest.setName("changed...");
        System.out.println("Inside method: " + anotherTest);
    }

    class Test {
        private String name;

        public Test(String s) {
            this.name = s;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    class AnotherTest {
        private String name;

        public AnotherTest(String s) {
            this.name = s;
        }

        public void setName(String s) {
            this.name = s;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        PassedByRef pbr = new PassedByRef();

        // #1: Cannot change primitive type argument
        int x = 100;
        System.out.println("Before method call: " + x);
        pbr.foo(x);
        System.out.println("After method call: " + x);

        // #2: Cannot change reference type argument ...
        Test t = pbr.new Test("t1");
        System.out.println("Before method call: " + t);
        pbr.bar(t);
        System.out.println("After method call: " + t);

        // #3
        AnotherTest at = pbr.new AnotherTest("t2");
        System.out.println("Before method call: " + at);
        pbr.fooBar(at);
        System.out.println("After method call: " + at);
    }
}

package b;

import a.AccessTest;

public class AccessTester extends AccessTest {

    public static void main(String[] args) {
        AccessTest accessTest = new AccessTest();
        accessTest.d();
        // accessTest.c();  // Not allowed, static type is not in same package

        AccessTester accessTester = new AccessTester();
        accessTester.d();
        // accessTester.c();  // Allowed, static type is in same package
    }

}

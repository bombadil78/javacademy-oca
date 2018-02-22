public final class FinalClass {

    public static void main(String[] args) {
        FinalClass fc = new FinalClass();
    }
}

class NonFinalClass {

    final void foo() {}

}

// Will not compile - final class cannot be extended
// class NiceTry extends FinalClass {}

class AnotherTry extends NonFinalClass {

    // Will not compile - final method cannot be overriden
    // void foo();
}

class InitIntegers {
    long l1 = 10;
    long l2 = 10000000000L;
    long l3 = 2147483647; // last valid integer literal
    // long l4 = 2147483648; Will not compile, not a valid integer literal since bigger than 2^31 - 1
    // int l5 = 10L; Will not compile; possible loss in precision
}

class InitFloats {
    // float literals end with f or F
    float f1 = 10f;
    float f2 = 10.1f;
    float f3 = 10e2f;

    // double literals can end with d or D
    double d1 = 10.0;
    double d2 = 1.1e2;
    double d3 = 1.1d;
    double d4 = 1f;

    // attention: those are integer literals
    double d = 1;
    // integer i = 1.1; Will not compile; possible loss in precision
    // float f = 1.1d; Will not compile; possible loss in precision
    // float f = 1.1; Will not compile; possible loss in precision

    double x1 = 1;
    double x2 = 1f;
    // float x3 = 1.1; Will not compile; possible loss in precision
}

public class InitNumbers {}

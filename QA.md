# Main method
* main() must be public and static and return nothing and take a string array as arguments; final is optional
* Non public main methods in classes are allowed, but programs fails at runtime
* The java program takes the name of the class that offers main() 
# Packages
* If a class name is ambiguous because imports give access to multiple classes with the same name then there are two cases:
  * Only wildcard imports OR only explicit imports: Compiler error
  * One wildcard import, one explicit import: explicit import takes precedence
* From the main program the JVM searches packages using the folder structure
* Package names are case-sensitive (like variables and any other identifier!)
* Packages must match the file system in order to lookup 
* Import of nested classes are allowed with dot-Notation, e.g. import a.someClass.someInnerClass;
# Construction
* Methods with the same name as a constructor are allowed, e.g. returning void
# Strings
* String concatenation with + allows converts a null-Reference to the String "null"
* Compare to: concat(null) will throw a NullPointerException
# Operators
* Operator precedence
  * Unary
    * Post-unary (++y) before
    * Pre-unary (--x) before
    * Other unary (!x, -123, ~0b000)
  * Arithmetic
    * Multiplication (* / %)
    * Addition/Substraction (+ -)
    * Shift operators (<< >> >>>)
  * Relational
    * < > <= >= instanceof
  * Equal / not equal (== !=)
  * Logical
    * Normal (& ^ |)
    * Short-circuit (&& ||)
  * Ternary
  * Assignment (= += *= /= %= &= ...)
* Evaluation among operators of same precedence is from **left-to-right** 
* Division of integer values is the floor of the result
* Numeric promotion (= Change of data type to make operations possible)
  * If values differ in type they are promoted to the larger data type
    * Integral: byte < short | char (unsigned) < int < long
    * Floating-point: float < double
  * If one value is integral and the other is floating-point the integral is promoted to floating-point
  * For binary arithmetic anything below int is promoted to int
  * After all operands are promoted to the same data type, the result is computed and has the same data type as the operands
* Casts are used
  * To go from a larger data type to a smaller
  * To go from a floating-point to an integral (but not vice versa!)
* Compound assignment operators introduce a downcast if needed
  * Example: short s = 10; short t = 3; short u = (short) s * t; <=> short s = 10; short t = 3;
# String
* String concatenation vs. + Operator
  * If both operators are numbers then addition is used
  * Otherwise if any of the operators is a string then concatenation is used
  * Evaluate from left to right
* Strings are immutable
* String pool for every string literal in the program
* new String() or any instance method will return a newly created string
# String Builder
* String Builders are mutable
* Applies a builder-pattern; will always return the instance itself
* The string methods like length(), indexOf(), ... return an immutable string
* append(), insert() and delete() are mutable
# Arrays
* Arrays are like objects, so default value is null
* Initialization: new int[] { 1, 2, 3 } or { 1, 2, 3 }
* arr.equals(arr2) uses Object's equals() which is by default a reference check 
* Arrays are covariant, so String[] is a subtype of Object[]
* Writing to arrays throws an ArrayStoreException at runtime if the object cannot be stored
* Arrays.sort() sorts using standard comparator, so alphanumeric for strings and numeric for numbers
* Arrays.binarySearch() searches in a **sorted** array; if nothing is found then -(positionalIndex + 1) for the search value in the array is returned
* Multidimensional arrays
  * int[][] m1 = new int[10][10];
  * Asymmetric
    * int[][] x = { {1}, {1, 2}, {1, 2, 3} };
    * int[][] y = new int[3][]; y[0] = new int[1]; y[1] = new int[2]; 

  

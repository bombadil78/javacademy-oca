# javacademy-oca

## Java Basics

### Variables
- Instance variable (non-static field)
- Class variable (static field)
- Local variable
- Parameter

### Comments
```java
// single-line comment; ignored until end of line

/* 
  multi-line comment
*/


/**
 * JavaDoc comment, used by javadoc-Tool
 */
  
```

### Main method

Every java application must have at least one main() method
```java
public static main(String[] args) { ... }
```

### Packages 
Packages creates a new namespaces. Public types from a package can be used *outside* by doing one of the following:
* Packages 
* Import a single type from the package, optionally with one or all of its inner types
* Import the full package
* Refer a type by its fully qualified name

```java
import org.acme.Foo;
import org.acme.Foo.*;
import org.acme.Foo.SomeInnerType;
import org.acme.*;
```

Package names are hierarchically structured, but logically not connected.

```java
import org.acme.foo.*;
import org.acme.foo.bar.*;
```

If type names are identical, then the fully qualified name must be used for at least one of the types.

Static import allow imports of single (or all) static members or methods of a type in order to prevent prefixing.

```java
import static org.acme.Foo.fooBar;
...
fooBar(); // can use fooBar() directly instead of Foo.fooBar()
```

### Java Platform
* Java code is written in .java files and compiled to byte-code in .class files
* The JVM interprets byte-code; there exists JVMs for all kinds of hardware platforms, so that is why Java is platform-independent
* The Java API is a collection of packages that can be used

### Java Types
* Package: Collection of types
* Interface
* Class
* Object
* Inheritance
* Enum

## Working with Java Data Types

### Initialization
* Static fields
  * Field initialization
  * Static block initialization (order matters!) or static methods
* Non-static field
  * Constructor
  * Initializer block (will be copied to constructor)
  * Final method: Often protected final such that subclasses cannot override but use   

```java
class Foo {
    
    private int i;
    private int j;
    private int k = initMe();
    
    public Foo() {
        i = 1;
    }
    
    {
        j = 2;
    }
    
    protected final int initMe() {
        return 3;
    }
}
```

### Primitives
* byte (8-bit signed, default = 0)
* short (16-bit signed, default = 0)
* int (32-bit signed, default = 0)
* long (64-bit signed or unsigned, default = 0L)
* float (floating-point, 32-bit, default = 0.0f)
* double (floating-point, 64-bit, default = 0.0d)
* boolean (bit, default = false)
* char (16-bit Unicode, default = '\u0000')

Signed two's complement
* Used to map bit-patterns to signed numbers
* Maps the first half of the available range to positive numbers (starting with 0 up to the maximum value)
* Maps the second half of the available range to negative numbers (starting with the minimal value up to -1)
* How to calculate: Flip bits, then add 1
* Properties: Addition, multiplication and substraction are analogue to signed numbers

Local variables must be initialized, fields may be initialized.

Literals are primitive type values
* General
  * Lower-range variables can not be assigned a higher-range value
  * Higher-range variable can be assigned lower-range values
* Long literals: End with l or L (prefer L)
* Integer literals
  * Must be in integer range, no postfix
  * Expressible in decimal (no prefix), binary (0b prefix), hexadecimal (0x prefix) form
  * Use underscore to group
* Floating-point literals
  * If the number has a dot then it is a double literal unless it also has a prefix of f or F
  * Use underscore to group
* Character literals
  * Use single quotes
* String literals
  * Use double quotes
* Underscores for integer and floating-point literals
  * Only in between numbers or characters
  * Multiple underscores are allowed
  * Underscore cannot touch: Radix prefix, dot, number type postfix
  
```java
double d1 = 1;     // ok, integer <= double
double d2 = 1f;    // ok, float <= double
float f1 = 1.1;    // nok, double <= float is false

float f2 = 3._14_15F // ok
float f3 = 3._1415F  // nok <= dot is touched
float f4 = 3.14_15_F // nok <= F is touched
```  

### Numbers
* There are wrapper classes for the primitive types: Byte, Short, Integer, Long, Float, Double
* The wrapper classes are of supertype Number
  * xyValue(): Converts to primitive type, e.g. someInt.byteValue()
  * compareTo(XY anotherNumber): Compares the number to another number with XY <= Number
  * static XY valueOf(somePrimitive): Converts primitive to wrapper
  * static somePrimitive parseXY(String someString): Parses string to primitive
* Compiler transforms from primitive to wrapper class (Auto-Boxing) or vice-versa (Auto-Unboxing)
* Use cases for wrapper classes
  * Generic collections need an object
  * Useful constant such as MIN_VALUE, MAX_VALUE
  * Conversion methods

## Inheritance
* Subclass inherits all public and protected methods
* If subclass is in same package then also package-private methods are inherited
* Hiding: Compiler warns if methods are hidden (e.g. super.foo() is protected and sub.foo() is private), but not for fields

## Operators
* Postfix
* Unary: { + - ++ -- ! }
* Arithmetic
  * Multiplicative: { * / % }
  * Additive: { + - }
* Shift
* Relational: { < > <= >= }
* Equality: { == != }
  * For objects equality means comparision of the object reference
* Bitwise (AND, XOR, OR)
* Conditional (AND, OR): { && || instanceof } 
* Ternary: { ?: }
* Assignment: { = }

## Object methods
* equals()
  * Are objects considered equal? Default implementation uses object equality check
  * o1.equals(o2) => o1.hashCode() == o2.hashCode() MUST hold, but o1.hashCode == o2.hashCode => o1.equals(o2) MAY hold
  * Map implementations have a limited number of buckets, and hashCode() is used to distribute the keys of the map to a linked list of key-/value-pairs. If equal objects would not have identical hash codes then there could be multiple entries in the map with equal keys (!)
* hashCode(): Default implementation uses the memory address of the object. If equals() is overridden then hashCode() should consider the fields relevant for the equality check.
* clone(): Don't use
* finalize(): Don't use, behavior depends on system (may or may not be called)
* getClass(): Corresponding class of object
* toString()
* notify(), notifyAll(), wait(): For thread synchronization

* Expression: Can be evaluated to a single value
* Statement: An expression as a unit of execution, delimited by a semicolon. Examples: Assignments, ++/--, method call, object creation
* Block: 0..N statements

Control flow
* If-then: Single control flow
* If-then-(elseif)*-else: Single control flow
* switch
  * Switch on some primitive types (byte, short, char, int) including their wrappers
  * Switch on Enums
  * Switch on Strings
  * Hop to case label, then execute all other cases in order until end is reached, only exit on break

## Arrays
* Declaration: identifier type[] OR identifier[] type
* Creation: new type[]
* Initialization: arr[atIndex] = 1 OR arr = { 1, 2, 3 } (includes creation)
* Access: arr[atIndex]

Questions
* What are valid names for variables?
* Multiple main() methods?
* Are packages bound to directory structure? No
fLyMd-mAkEr
Topics
* Naming: Classes, methods, fields
* Visibility
* Inner classes
* Up-/Downcasting and runtime-checks
* Bitwise operations

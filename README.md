# javacademy-oca

## Java Basics

Variables
- Instance variable (non-static field)
- Class variable (static field)
- Local variable
- Parameter

Comments
```java
// single-line comment; ignored until end of line

/* 
  multi-line comment
*/


/**
 * JavaDoc comment, used by javadoc-Tool
 */
  
```

Main method

Every java application must have at least one main() method
```java
public static main(String[] args) { ... }
```

Packages creates a new namespaces. Public types from a package can be used *outside* by doing one of the following:
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

Java Platform
* Java code is written in .java files and compiled to byte-code in .class files
* The JVM interprets byte-code; there exists JVMs for all kinds of hardware platforms, so that is why Java is platform-independent
* The Java API is a collection of packages that can be used

Java Types
* Package: Collection of types
* Interface
* Class
* Object
* Inheritance
* Enum

## Working with Java Data Types

Initialization
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

Primitives
* byte (8-bit signed, default = 0)
* short (16-bit signed, default = 0)
* int (32-bit signed, default = 0)
* long (64-bit signed or unsigned, default = 0L)
* float (floating-point, 32-bit, default = 0.0f)
* double (floating-point, 64-bit, default = 0.0d)
* boolean (bit, default = false)
* char (16-bit Unicode, default = '\u0000')

Local variables must be initialized, fields may be initialized.

Literals are primitive type values
* General
  * Lower-range variables can not be assigned a higher-range value
  * Higher-range variable can be assigned lower-range values
* Long literals: End with l or L (prefer L)
* Integer literals
  * Must be in integer range, no postfix
  * Expressible in decimal (no prefix), binary (0b prefix), hexadecimal (0x prefix) form
* Floating-point literals
  * If the number has a dot then it is a double literal unless it also has a prefix of f or F
  
```java
double d1 = 1;     // ok, integer <= double
double d2 = 1f;    // ok, float <= double
float f1 = 1.1;    // nok, double <= float is false
```  

Questions
* What are valid names for variables?
* Multiple main() methods?


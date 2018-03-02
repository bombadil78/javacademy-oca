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

Arrays offers utility methods for primitive arrays 
* binarySearch(haystackArr, needle)
* copyOf(orig, newLength)
* copyOfRange(orig, fromIdx, toIdx)
* deepEquals(arrOne, arrTwo)
* deepHashCode(arrOne, arrTwo)
* fill()
* sort()
* stream()
* Parallel variants: parallelSort(), ...

## Control flow 
* if-then / if-then-else
* do-loop / while-loop / for-loop
* Branching statements
  * break: Breaks out of the innermost xy-loop or switch statement
  * break someLabel: Used to break out of a label; label must be defined right before construct
  * continue
  * continue someLabel
  * return *(value)+*
  
## Methods 
* When does a method return?
  * All statements finished
  * return statement executed
  * Exception thrown  
* Covariant return types: Return type can be of subtype of declared type 
* Ingredients
  * Modifier
  * Return type
  * Method name
  * Parameter list
  * Exception list
  * Method body
* Method signature = Method name + parameter list
* Parameter vs. arguments
  * Parameters = List of accepted data types
  * Arguments = Concrete values as a concrete list of parameters
  * Arguments are
    * Primitive types
    * Object types
    * Lambdas
    * Method references  
* Overload: Same method name, but different parameter list
* Overriding: TargetType.A method in a subclass qualifies if ...
  * It has the same method signature (Contravariant parameter types do NOT qualify for an override)
  * It is at least as visible as the overridden method
  * The return type is in covariant position
  * The exceptions in the exception list are in covariant positions
  * The static-/non-static ness does not change
* Hiding
  * Subclass defines same static method as superclass
  * Can only occur between static methods
  * Subclass hides implementation of superclass' method
  
# Classes
* Globals
  * Expressed with static members and methods
  * Access of non-static members/methods is not possible from within a static context (there is no appropriate object yet...)
* Interfaces
  * Visibility of interface is either public or package-private
  * Visibility of methods is always public
  * Fields are always final
  * Non-static methods are either abstract or have a default modifier
* Default methods
  * Changes in interfaces do not break implementors
  * Normal implementations in a class take precedence over default implementations (that's why it's called default)
  * Default implementations can override other default implementations
  * Diamond case
    * TargetType.A class that inherits identical default methods from its ancestors must implement it
    * Class might be abstract; override still needed in order to resolve ambiguous situation
* Constructors
  * Classes w/o constructors get a no-args constructor which will be removed once any constructor is provided
  * Subclass constructors MUST call a superclass constructor; either by calling another constructor with this(...) are with super(...)
  * Remark: No-args constructor calls are added automatically by the compiler
* Nested classes
  * Classes nested inside another class, e.g. inner class or static inner class
* Static nested class
  * Conceptionally like a normal class, but nested inside another class for encapsulation reasons
  * Can access private static members of the outer class (unlike a normal class)
  * Cannot access non-static members of the outer class (like a normal class)
  * Creation: new Outer.Inner()
* Inner classes
  * Bound to an instance of the outer class
  * Can access enclosing class: Outer.this.someField, Outer.this.someMethod()     
* Special types of inner classes
  * Local class: Like local field; no visibility keyword
  * Anonymous class: Class w/o name, only an interface declaraction with an ad-hoc implementation. If only one method must be overridden, the anonymous class can be replaced by a lambda.
* Shadowing vs. Hiding
  * Shadowing: Same name within different scopes in the same class
  * Hiding: Same name within an inheritanc hierarchy
* Super
  * Used to refer to overridden methods
  * Used to refer to hidden fields (this would be used for inherited fields)
  * Used to call super class constructors
  * Every constructor must make a super class constructor call; if none is given the compiler adds a call to the no-args constructor using super() which can result in a compile-time error if none such constructor exists
* This
  * To mitigate shadowing for constructors/setter methods, e.g. setX(int x) { this.x = x; }
  * To call constructors from within another constructor; must occur in first position    
* Abstract classes
  * If declared abstract, they cannot be instantiated
  * They can declare abstract methods that must be implemented by any concrete subclass
  * Used for code reuse whereas interfaces are used for subtyping
* Interfaces
  * Can contain abstract, default or static methods
  * Can contain constants        
  
```java
class Foo {
    protected Object foo() { return null; }
    protected String bar() { return null; }
}

class FooBar extends Foo {

    // covariant position of return type => OK
    @Override
    protected String foo() { return null; }
    
    // contravariant position of return type => NOK
    @Override
    protected Object bar() { return null; }
}
```

## Exceptions
* Catch or specify requirement: Code throwing an exception must either catch it or declare it to be thrown
* Three types of exceptions
  * Recoverable problems (belongs to checked exceptions)
    * Problems a program can recover from, e.g. invalid user input
    * Subject to the catch or specify requirement
    * Throwable > Exception or any subclass except RuntimeException
    * The compiler checks them by imposing the check or specify requirement 
  * Errors (belongs to unchecked exceptions)
    * Abnormal conditions, that should never occur, e.g. disk failure
    * Throwable > Error or any subclass
    * NOT subject to the catch or specify requirement
  * Internal problems (belongs to unchecked exceptions)
    * Program a program cannot recover from, e.g. programming error, inappropriate usage of API, ...
    * Throwable > Exception > RuntimeException or any subclass
    * NOT subject to the catch or specify requirement
* try-catch-finally
  * try: Encloses exception throwing code
  * catch
    * Defines exception handlers connected to the try block 
    * Exception handler can do error recovery, ask user input or propagate the error to another context
    * Finds first match using dynamic binding
    * List of exceptions allowed, e.g. catch(SomeException | SomeOtherException ex) <= ex is final (!)
  * finally
    * Executed in any case (passing exception vs. not passing exception)
    * Used for clean-up code
* try-with-resources
  * Used for resource closing and analogue to ... finally { if (res != null) res.close(); }
  * try (<resource-statement(s)>) { ... } will close any resources, indendent from wheter an exception occured or not, so there is no need for the null-check
  * Resource is     
     
## Java API Selection

* Conversions (Wrapper vs. Primitive vs. String)
  * Convert to wrapper: valueOf(other)
  * Convert to String: toString() on instance (for wrapper) or static toString(i) for Primitive
  * Convert to Primitive: parseXXX() from String, xxxValue() from wrapper
* String
  * CharSequence is the superclass of String, StringBuilder, StringBuffer
    * Offers: length(), subSequence(int start, int end), charAt(int index), toString()
  * Comparision, e.g. startsWith(String prefix, int offset), regionMatches(...)
  * Manipulation (always returns a new String)
    * Get portion: substring(), split(), trim(), ...
    * Search: indexOf(), lastIndexOf()
    * Replace: replace(), replaceAll(), replaceFirst()
* Basic date abstractions
  * Temporal
    * Representation of date/time
    * Offers: minus(temporalAmount), plus(temporalAmount), with(temporalAdjuster)
    * Implementations: Instant, LocalTime, LocalDate, LocalDateTime, YearMonth, MonthDay, Year  
  * TemporalAmount
    * Representation of a duration
    * Offers: addTo(temporal), substractFrom(temporal)
    * Implementations: Duration (seconds semantics), Period (day/month/year semantics)
  * TemporalUnit
    * Unit to measure date/time  
    * Offers: between(unit1, unit2)
* Date
  * Date representation
    * LocalDate
      * now(), of(year, month, day), with(temporalAdjuster), ...
    * YearMonth
      * now(), of(year, month), lengthOfMonth(), ...
    * MonthDay
      * now(), of(month, day), isValidYear(someYear)
    * Year
      * now(), of(year), isLeap()
  * LocalTime
    * Time without time zone, no date (!)
    * Immutable
    * Offers: now(), of(), getHour(), getMinute(), getSecond(), isAfter(other), isBefore(other)
    * Useful constans like MAX, MIN, MIDNIGHT, NOON
  * LocalDateTime
    * Date and Time
    * Combination of LocalTime and LocalDate
    * Offers: now(), of(...), plusMonths(i), minusDays(2), ...
  * DateTimeFormatter
  * Period = Quantity of time in year/month/day
    * Quantities: YEARS, MONTHS, DAYS
    * Calculation based on year/month/day semantics
    * Offers: of(), plus(), minus(), between(t1, t2), addTo(someDate), ...
  * Duration = Quantity of time in seconds
    * Calculation based on exact seconds
    * Offers: of(), plus(), minus(), between(t1, t2), ...
* Date exceptions
  * UnsupportedTemporalTypeException is thrown if time granularity between amounts, units and durations exist
* Collection interface
  * add(), addAll()
  * size(), isEmpty()
  * remove(Object o) vs. removeAll(Collection<?> other)
  * retainAll(Collection<? extends E> other)
  * Iteration
    * forEach() (Stream API)
    * for-each loop
    * Iterator: hasNext(), next(), remove(), forEachRemaining()
  * Collections: Utility methods like shuffle(), reverse(), rotate(), max(), min(), ...

* List = Ordered collection that allows duplicates
  * Offers (in addition to collection): 
    * Positional access: get(i), set(i), add/addAll() (= add to end)
    * Iteration: for-each loop, iterato 
    * Range-views
  * Equality semantics: Equal length && objects at every position are equal
  * Arrays.asList() offers is a view based on an underlying array ("write through") => Arrays$ArrayList

* List implementations  
  * ArrayList
  * LinkedList

## Lambdas  
* Motivation: Anonymous classes with only one method are cumbersome to write
* Predicate<T>: boolean test(T t)
* Producer<T>: T produce()
* Consumer<T>: void consume(T t)
* Function<T, U>: U apply(T t)
* Then use filter() with predicate, map() with Function, forEach() with Consumer
* Anonymous classes and lambdas can only capture final or effectively final **local** variables
  * Capturing a local variable means copying to the anonymous class (Java approach), because after the method finishes, the local variable will be gone, but the code relying on it, might be executed later.
  * Capturing an instance variable does not mean copying, because the instance variable will continue to live even after the method finishes
  * Copying done implicitly, so it is not evident that changes of the variable inside would not be reflected outside (and vice-versa), so this is why it is prohibited in Java
  * To the rescue: Use array reference to cheat the compiler
* Local and anonymous classes have their own *this* context, lambdas do not; but both have the restriction that local variables used must be final or effectively final
* Target type
  * The compiler must infer the target type of a lambda from its context (it is not declared in the lambda)
  * Valid contexts are variable declarations, return statements, array initalizers, ...
  * What if multiple 

# Feedback
## Session 26.02.2018 (Foundation Test)
* java.util.time: Repeat the main abstractions, main classes
* Most important exceptions & when they are thrown, exception class hierarchy 
* Java Primitive Types: What they are, ranges, and conversion between each other (integer vs. floating-point)
* Switch case: What are valid labels?
* StringBuilder / StringBuffer methods (mutating vs. pure) including constructors
* String methods including constructors
* Primitive wrapper methods including constructors
* Two-complement of integers / min-/max-Values
* Hiding (static vs. non-static)

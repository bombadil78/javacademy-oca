import java.util.*;
import java.util.stream.Stream;

public class ArrayStuff {

    public static void main(String[] args) {

		// Arrays are covariant, so Integer <= Object => Integer[] <= Object[]
		// Compiler looks at declared type
		Object[] arr = new Integer[10];
		arr[0] = 0;
		// arr[1] = "boom at runtime: ArrayStoreException";

		int arr1[];
		int[] arr2;

		char[] c1 = { 'a', 'b', 'c' };
		char[] c2 = new char[c1.length];
		System.arraycopy(c1, 0, c2, 0, 3);
		System.out.println(new String(c2));

		int[][] matrix = new int[10][10];

		for (int i = 0; i < matrix.length; i++) {
		    int[] row = matrix[i];
            Arrays.fill(row, i);
        }
    }

    private static <T> String arrOutput(T[] arr) {
        return Arrays.stream(arr).map(x -> x.toString()).reduce("", (acc, el) -> acc + el);
    }
}

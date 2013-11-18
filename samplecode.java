import java.io.*;
import java.util.*;
import java.math.*;
public class samplecode {
	public static void debug(String s) {
		System.out.printf(">>>%s>>>\n", s); //Comment this out to kill n birds with two /
	}
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int a = Integer.parseInt(s1.split(" ")[0]);
		String[] arr = s1.split(" ");

		// Does God play Tetris? used java.util.Collections, it's super effective!

		// A comparator can be defined by
		class MyClassCmp implements Comparator<MyClass> {
			// Should return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second respectively
			public int compare(MyClass a, MyClass b) {
				return a.a - b.a; }
			// As far as I can tell this may not be neccessary, but probably best to do anyway
			public boolean equals(MyClass a, MyClass b) {
				return a.a == b.a; }
		}
		// To change an array to a list we can do
		List<String> arrayaslist = Arrays.asList(arr);
		// Or make a general list
		List<MyClass> list = new LinkedList<MyClass>();
		List<MyClass> list2 = new Vector<MyClass>();
		// If we have a comparator already we can do
		Collections.sort(arrayaslist); // or maybe
		Collections.sort(list, new MyClassCmp());
		// If we have a sorted list we can do
		MyClass target = new MyClass(3);
		Collections.binarySearch(list, target, new MyClassCmp());
		SortedSet<MyClass> set = new TreeSet<MyClass>(new MyClassCmp());

		// We can work with arbitrary precision integers as follows:
		BigInteger numb = new BigInteger("1223423784329545891238471293812391254651");
		numb = numb.add(BigInteger.valueOf(3));
		debug(numb.toString());

		// In places where code should never be reached we can debug (and submit) with assert(false); there, this way we will get an exception rather than dodge behaviour.
		debug(arr[0]);
	}
	// Custom classes declared within the main like this:
	static class MyClass {
		int a;
		MyClass(int A) {
			a = A; }
	}
}

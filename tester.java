import java.util.*;
public class tester
{
	public static void main(String[] args)
	{
		// Testing Knuth-Morris-Pratt
		System.out.println("Testing KMP");
		char[] x = "aaa".toCharArray();
		char[] y = "aaaaaaaaaa".toCharArray();

		kmp.KMP(x,x.length-1,y,y.length-1);


		// Testing point sorting
		System.out.println("Testing hull");
		ArrayList<Point> points = new ArrayList();
		Point p0 = new Point();
		p0.x = 0;
		p0.y = 0;
		Point p1 = new Point();
		p1.x = 1;
		p1.y = 0;
		Point p2 = new Point();
		p2.x = 0;
		p2.y = 1;
		Point p3 = new Point();
		p3.x = 1;
		p3.y = 1;
		Point p4 = new Point();
		p4.x = 2;
		p4.y = 2;
		Point p5 = new Point();
		p5.x = 1;
		p5.y = 2;
		Point p6 = new Point();
		p6.x = 3;
		p6.y = 3;
		points.add(p0);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		List<Point> hull = convexhull.hull(points);
		for (Point p : hull)
		{
			System.out.printf("%s,%s\n", p.x,p.y);
		}
	}
}

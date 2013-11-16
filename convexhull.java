import java.util.*;
public class convexhull
{
	static final double eps = 0.0000000001;
	static int isAnti(Point x0,Point x1,Point x2) {
		double a = (x1.x-x0.x)*(x2.y-x0.y)-(x2.x-x0.x)*(x1.y-x0.y);
		if (a > eps || -a > eps) return a > 0 ? -1 : 1;
		return 0;
	}
	static int isCloser(Point x0,Point x1,Point x2) {
		double d1 = (x0.x - x1.x)*(x0.x - x1.x) + (x0.y - x1.y)*(x0.y - x1.y);
		double d2 = (x0.x - x2.x)*(x0.x - x2.x) + (x0.y - x2.y)*(x0.y - x2.y);
		if (d1-d2 > eps || d2-d1 > eps) return d1 < d2 ? -1 : 1;
		return 0;
	}
	public static List<Point> hull(List<Point> points) {
		Collections.sort(points);
		final Point p0 = points.get(0);
		points.remove(p0);
		Collections.sort(points, new Comparator<Point>() {
				public int compare(Point p1, Point p2) {
				int a = isAnti(p0,p1,p2);
				if (a != 0) return a;
				return isCloser(p0,p1,p2);
				}});
		int m = points.size();
		for (int i = 1; i < m; i++) { // Remove colinears
			if (isAnti(p0,points.get(i-1),points.get(i)) == 0) {
				points.remove(i-1);
				m--;
			}
		}
		LinkedList<Point> hull = new LinkedList<Point>();
		if (m < 2) return hull; // All colinear, no hull
		hull.push(p0);
		hull.push(points.get(0));
		hull.push(points.get(1));
		for (int i = 2; i < m; i++) {
			while (isAnti(hull.get(0),hull.get(1),points.get(i))<=0) {
				hull.pop();
			}
			hull.push(points.get(i));
		}
		return hull;
	}
}

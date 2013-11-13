import java.util.*;
public class convexhull
{
	public static List<Point> hull(List<Point> points)
	{
		List<Point> hull = new LinkedList<Point>();
		Collections.sort(points);
		final Point x0 = points.get(0);
		hull.add(x0);
		points.remove(x0);
		final double eps = 0.0000001;
		Collections.sort(points, new Comparator<Point>() {
				public int compare(Point p1, Point p2) {
				double a1, a2;
				a1 = x0.cross(p1);
				a2 = x0.cross(p2);
				if (Math.abs(a1 - a2) > eps) return a1 < a2 ? -1 : 1;
				double d1 = (x0.x - p1.x)*(x0.x - p1.x) + (x0.y - p1.y)*(x0.y - p1.y);
				double d2 = (x0.x - p2.x)*(x0.x - p2.x) + (x0.y - p2.y)*(x0.y - p2.y);
				if (Math.abs(d1 - d2) > eps) return d1 < d2 ? -1 : 1;
				return 0; }});
		return hull;
	}
}

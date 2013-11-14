public class Point implements Comparable<Point> {
	int x; int y;
	public int compareTo(Point p) {return (x-p.x == 0) ? y-p.y : x-p.x;}// left-bottommost
	public float cross(Point p) { return x*p.y - p.x*y; }
}

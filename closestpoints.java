import java.util.*;
public class closestpoints {
	public static Point[] closestPair(Point[] arr){
		Point[] ret = {arr[0],arr[1]};
		Arrays.sort(arr);
		return ret;
	}
}

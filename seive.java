public class seive {
	public static boolean[] iscompslessthan(int n) {
		boolean[] iscomp = new boolean[n];
		for (int i = 2; i < Math.sqrt((double)n) + 1; i++) {
			if (iscomp[i]) continue;
			for (int j = i*i; j < n; j+=i) {
				iscomp[j] = true;
			}
		}
		return iscomp;
	}
}

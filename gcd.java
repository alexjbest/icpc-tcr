public class gcd {
	static int gcd(int a, int b) {
		int c = 0;
		while(a!=0 && b!=0) {
			c = b;
			b = a%b;
			a = c;
		}
		return a+b;
	}

	static int arrGCD(int[] a) {
		int g = a[0];
		for (int i = 0; i < a.length; i++) {
			g = gcd(a[i],g);
			if (g == 1) break;
		}
		return g;
	}
}

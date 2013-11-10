public class kmp {
	public static void main(String[] args)
	{
		char[] x = "aaa".toCharArray();
		char[] y = "aaaaaaaaaa".toCharArray();

		KMP(x,x.length-1,y,y.length-1);
	}
	static int[] preKmp(char[] x, int m, int[] kmpNext) {
		int i, j;

		i = 0;
		j = kmpNext[0] = -1;
		while (i < m) {
			while (j > -1 && x[i] != x[j])
				j = kmpNext[j];
			i++;
			j++;
			if (x[i] == x[j])
				kmpNext[i] = kmpNext[j];
			else
				kmpNext[i] = j;
		}
		return kmpNext;
	}

	static void KMP(char[] x, int m, char[] y, int n) {
		int i, j;
		int[] kmpNext = new int[x.length];

		/* Preprocessing */
		kmpNext = preKmp(x, m, kmpNext);

		/* Searching */
		i = j = 0;
		while (j < n) {
			while (i > -1 && x[i] != y[j])
				i = kmpNext[i];
			i++;
			j++;
			if (i >= m) {
				System.out.println(j - i);
				i = kmpNext[i];
			}
		}
	}

}

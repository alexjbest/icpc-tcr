public class tester
{
	public static void main(String[] args)
	{
		char[] x = "aaa".toCharArray();
		char[] y = "aaaaaaaaaa".toCharArray();

		kmp.KMP(x,x.length-1,y,y.length-1);
	}
}

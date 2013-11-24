import java.util.*;
public class knapsack
{
	public static List<Integer> zerooneknapsack(List<Integer> values,List<Integer> weights, int W)
	{
		int numItems = values.size();
		int maxWeight = Collections.max(weights);
		int[][] B = new int [numItems+1][maxWeight+1]; 
		for (int k = 0; k < numItems; k++) {
			for (int w = maxWeight; w >= weights.get(k); w--)
				if (values.get(k) + B[k][w-weights.get(k)] > B[k][w])
					B[k+1][w] = values.get(k) + B[k][w-weights.get(k)];
				else
					B[k+1][w] = B[k][w];
			for (int w = 0; w < weights.get(k); w++)
				B[k+1][w] = B[k][w];
		}

		ArrayList<Integer> retval = new ArrayList<Integer>();
		// The maximum value is noew B[numItems][maxWeight])
		// For items used, code is
		for (int k = numItems-1, remainingWeight=maxWeight; k >= 0; k--) {
			if (remainingWeight >= weights.get(k))
				if (B[k][remainingWeight] == (values.get(k) + B[k][remainingWeight - weights.get(k)]))
				{
					retval.add(k);
					remainingWeight -= weights.get(k);
				}
		}
		return retval;
	}
}

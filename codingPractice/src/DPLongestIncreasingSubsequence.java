/**
 * 최장증가수열
 * 
 * @author Wonjin Heo
 *
 */
public class DPLongestIncreasingSubsequence {

	public static void main(String[] args) {
//		int[] input = new int[] { 2, 7, 4, 3, 8 };
		 int[] input = new int[] { 5, 4, 3, 2, 1, 6, 7, 8 };

		System.out.println(getLIS(input));
	}

	static int getLIS(int[] input) {
		int[] cache = new int[input.length + 1];
		int max = 0;
		cache[0] = 1;
		for (int i = 0; i < input.length; i++) {
//			cache[i] = 1;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j]) {
					cache[i] = Math.max(cache[i], cache[j] + 1);
				}
			}
			max = Math.max(max, cache[i]);

		}
		return max;
	}

}

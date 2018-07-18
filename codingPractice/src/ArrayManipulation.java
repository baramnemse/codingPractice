
/**
 * Done
 * 
 * @author WONJIN
 *
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		 System.out.println(arrayManipulation(5, new int[][] { { 1, 2, 100 },
		 { 2, 5, 100 }, { 3, 4, 100 } }));
		// System.out.println(arrayManipulation(10, new int[][] { { 1, 5, 3 }, {
		// 4, 8, 7 }, { 6, 9, 1 } }));
		// System.out.println(
		// arrayManipulation(10000000, new int[][] { { 5216499, 7952900, 40114
		// }, { 1259346, 5532643, 46983 } }));

	}

	/**
	 * O(n^2) 시간 복잡도, 안좋은 알고리즘
	 * 
	 * @param n
	 * @param queries
	 * @return
	 */
	static long arrayManipulation2(int n, int[][] queries) {
		long max = 0;
		long[][] resultArray = new long[1][n];
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
				max = Math.max(resultArray[0][j] = resultArray[0][j] + queries[i][2], max);
			}
		}
		return max;
	}

	/**
	 * O(n) 시간 복잡도, 좋은 알고리즘, 이해못함
	 * https://codingin.wordpress.com/2017/02/19/solution-algorithmic-crush-in-java/
	 * @param n
	 * @param queries
	 * @return
	 */
	static long arrayManipulation(int n, int[][] queries) {
		long[] resultArray = new long[n + 1];
		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			resultArray[a - 1] += k;
			resultArray[b] -= k;
		}
		
		long max = resultArray[0];
        for (int i = 1; i < n; i++) {
        	resultArray[i] += resultArray[i - 1];
            max = Math.max(resultArray[i], max);
        }
		return max;
	}
}

import java.util.Arrays;

/**
 * 더블포인터로 해결
 * @author WONJIN
 *
 */
public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(maxMin(10, new int[] { 4, 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 }));
		System.out.println(maxMin(2, new int[] { 1,4,7,2 }));
	}

	/**
	 * O(n)
	 * 
	 * @param k
	 * @param arr
	 * @return
	 */
	static int maxMin(int k, int[] arr) {
		Arrays.sort(arr);
		int leftPoint = 0;
		int rightPoint = 0;
		int result = Integer.MAX_VALUE;
		while (rightPoint < arr.length) {
			if (rightPoint - leftPoint + 1 == k) {
				result = Math.min(Math.max(arr[rightPoint], arr[leftPoint]) - Math.min(arr[rightPoint], arr[leftPoint]),
						result);
				leftPoint++;
				rightPoint++;
			}
			if (rightPoint - leftPoint + 1 < k) {
				rightPoint++;
			}
		}
		return result;
	}

}

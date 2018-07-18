
public class CompareTheTriplets {

	public static void main(String[] args) {
		solve(new int[] { 5, 6, 7 }, new int[] { 3, 6, 10 });

	}

	static int[] solve(int[] a, int[] b) {
		int alicePoint = 0;
		int bobPoint = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b[i]) {
				alicePoint++;
			} else if (a[i] < b[i]) {
				bobPoint++;
			}
		}
		return new int[] { alicePoint, bobPoint };
	}

}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Median값을 빠르게 가져와야 속도 개선 가능
 * @author Wonjin Heo
 *
 */
public class FraudulentActivityNotifications {

	static int activityNotifications(int[] expenditure, int d) {
		int leftPointer = 0;
		int rightPointer = 0;
		int alert = 0;

		while (rightPointer + 1 < expenditure.length) {
			if (rightPointer - leftPointer + 1 < d && leftPointer < 1) {
				rightPointer++;
			} else if (rightPointer - leftPointer + 1 == d) {
				// 여기서 성능 저하
				double average = 0.0;
				int temp[] = new int[d];
				System.arraycopy(expenditure, leftPointer, temp, 0, d);
				Arrays.sort(temp);
				if (d % 2 == 0) {
					average = (temp[d / 2] + temp[d / 2 - 1]) / 2.0;
				} else {
					average = temp[d / 2];
				}
				// 성능저하 끝
				if (expenditure[rightPointer + 1] >= average * 2) {
					alert++;
				}
				leftPointer++;
				rightPointer++;
			}
		}
		return alert;
	}

	// public static void main(String[] args) {
	// System.out.println(activityNotifications(
	// new int[] { 10, 20, 30, 40, 50 }, 3));
	//
	// }
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
				"out.txt"));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}

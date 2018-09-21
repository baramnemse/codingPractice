import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Code1 {
	// Complete the rotLeft function below.

	static int[] rotLeft(int[] a, int d) {
		return new int[] { 1, 2, 3 };
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
				"out.txt"));
		String[] nd = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nd[0]);
		int d = Integer.parseInt(nd[1]);
		int[] a = new int[n];
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(new int[] { 1, 2, 3, 4, 5 }, 5);
		// int[] result = rotLeft(a, d);
		System.out.println(Arrays.toString(result));

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {

				bufferedWriter.write(" ");

			}

		}
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();

	}

}
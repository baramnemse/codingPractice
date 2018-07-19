import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * O(n) O(m+n)
 * @author WONJIN
 *
 */
public class RansomNote {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}

	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> noteMap = new HashMap();
		for (String word : magazine) {
			Integer count = noteMap.get(word);
			if (count == null) {
				noteMap.put(word, 1);
			} else {
				noteMap.put(word, count + 1);
			}
		}
		for (String word : note) {
			Integer count = noteMap.get(word);
			if (count == null) {
				System.out.println("No");
				return;
			} else {
				if (count < 1) {
					System.out.println("No");
					return;
				}
				noteMap.put(word, count - 1);
			}
		}
		System.out.println("Yes");
	}

}

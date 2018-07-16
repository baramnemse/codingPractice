import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubsequence {
	static Map resultMatrix = new HashMap();

	public static void main(String[] args) {
		// int result = getMaxValue(new int[] { -2, 1, 3, -4, 5 }, 5);
		System.out.println(commonSubsequence("SHINCHAN", "NOHARAAA"));
		System.out.println(commonSubstring("SHINCHAN", "NOHARAAA"));

	}

	public static int commonSubsequence(String str1, String str2) {
		int L[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					// 같은 경우 대각선 왼쪽값에서 1을 더함
					L[i + 1][j + 1] = L[i][j] + 1;
				} else {
					// 다르면 위나 왼쪽값 중 큰값을 넣는다
					L[i + 1][j + 1] = Math.max(L[i][j + 1], L[i + 1][j]);
				}
			}
		}
		return L[str1.length()][str2.length()];
	}

	public static int commonSubstring(String str1, String str2) {
		int result = 0;
		int L[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					// 같은 경우 대각선 왼쪽값에서 1을 더함
					result = Math.max(L[i + 1][j + 1] = L[i][j] + 1, result);
				}
			}
		}
		return result;
	}

}

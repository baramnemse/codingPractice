import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5 {

	public static void main(String[] args) {
		// String str1 = "FRANCE";
		// String str2 = "french";
		// String str1 = "aa1+aa2";
		// String str2 = "AAAA12";
		// String str1 = "handshake";
		// String str2 = "shake hands";
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		// 문자열을 소문자로 변경
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		// 문자열을 스트링 리스트로 변경
		List<String> group1 = new ArrayList();
		for (int i = 0; i < str1.length(); i++) {
			if (i + 1 < str1.length()) {
				if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' && str1.charAt(i + 1) >= 'a'
						&& str1.charAt(i + 1) <= 'z') {
					group1.add(String.format("%c%c", str1.charAt(i), str1.charAt(i + 1)));
					System.out.println(String.format("%c%c", str1.charAt(i), str1.charAt(i + 1)));
				}
			}
		}
		List<String> group2 = new ArrayList();
		for (int i = 0; i < str2.length(); i++) {
			if (i + 1 < str2.length()) {
				if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' && str2.charAt(i + 1) >= 'a'
						&& str2.charAt(i + 1) <= 'z') {
					group2.add(String.format("%c%c", str2.charAt(i), str2.charAt(i + 1)));
					System.out.println(String.format("%c%c", str2.charAt(i), str2.charAt(i + 1)));
				}
			}
		}
		// 합집합 만들기
		List union = new ArrayList();
		union.addAll(group1);
		union.addAll(group2);

		// 교집합만들기 AUB -A'C - B'C
		int unionNum = getUnionNumber(group1, group2);
		int intersectionNum = getIntersectionNumber(group1, group2);
		System.out.println(intersectionNum);
		System.out.println(unionNum);
		if (intersectionNum == 0 && unionNum == 0) {
			System.out.println(65536);
		} else {
			System.out.println((int) (intersectionNum * 1.0 / unionNum * 65536));
		}
	}

	static int getUnionNumber(List<String> group1, List<String> group2) {
		int result = 0;
		Set checkedItem = new HashSet();
		for (String item : group1) {
			if (group2.contains(item)) {
				if (!checkedItem.contains(item)) {
					checkedItem.add(item);
					// 각각 그룹에 해당 원소가 몇개 있는지 카운트
					int g1 = 0;
					int g2 = 0;
					for (String member1 : group1) {
						if (item.equals(member1)) {
							g1++;
						}
					}
					for (String member2 : group2) {
						if (item.equals(member2)) {
							g2++;
						}
					}
					int num = Math.max(g1, g2);
					result += num;
				}
			} else {
				result++;
			}
		}
		return result;
	}

	static int getIntersectionNumber(List<String> group1, List<String> group2) {
		int result = 0;
		Set checkedItem = new HashSet();
		for (String item : group1) {
			if (group2.contains(item)) {
				if (!checkedItem.contains(item)) {

					checkedItem.add(item);
					// 각각 그룹에 해당 원소가 몇개 있는지 카운트
					int g1 = 0;
					int g2 = 0;
					for (String member1 : group1) {
						if (item.equals(member1)) {
							g1++;
						}
					}
					for (String member2 : group2) {
						if (item.equals(member2)) {
							g2++;
						}
					}
					int num = Math.min(g1, g2);
					result += num;
				}
			}
		}
		return result;
	}

}

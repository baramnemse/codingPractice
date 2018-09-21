/**
 * 자료구조를 사용하지 않고 문자열의 문자가 유니크한지 확인
 * 
 * @author Wonjin Heo
 *
 */
public class Q219 {

	public static void main(String[] args) {
		System.out.println(isUnique("abc"));
		System.out.println(isUnique("abbc"));
	}

	/**
	 * 연산복잡도O(n) 공간복잡도O(1), 상수
	 * 
	 * @param text
	 * @return
	 */
	static boolean isUnique(String text) {
		// 아스키는 256가지인데 텍스트의 길이가 256을 넘을 경우 반드시 중복이 있다는 뜻이다.
		if (text.length() > 256)
			return false;

		boolean checkMatrix[] = new boolean[256];
		for (int i = 0; i < text.length(); i++) {
			if (checkMatrix[text.charAt(i)])
				return false;
			checkMatrix[text.charAt(i)] = true;
		}
		return true;
	}

}

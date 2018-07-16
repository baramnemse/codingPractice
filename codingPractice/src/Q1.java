
public class Q1 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		makeMap(5, arr1, arr2);

		n = 6;
		int[] arr3 = { 46, 33, 33, 22, 31, 50 };
		int[] arr4 = { 27, 56, 19, 14, 14, 10 };
		makeMap(6, arr3, arr4);
	}

	static void makeMap(int n, int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			String result = Integer.toBinaryString(arr1[i] | arr2[i]);
			if (result.length() < n) {
				for (int j = 0; j < n - result.length(); j++) {
					result = "0" + result;
				}
			}
			for (int j = 0; j < result.length(); j++) {
				if (result.charAt(j) == '1') {
					System.out.print('#');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println("");
		}
	}

}

/**
 * 정수만을 이용해서 원 태두리 그리기
 * @author Wonjin Heo
 *
 */
public class DrawCircle {

	public static void main(String[] args) {
		int input[][] = new int[64][64];
		getXyInCircle(input, 32, 2);

		for (int x = 0; x < 64; x++) {
			for (int y = 0; y < 64; y++) {
				if (input[x][y] == 1) {
					System.out.print(".");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void getXyInCircle(int page[][], int r, int border) {
		for (int x = 0; x < r * 2; x++) {
			for (int y = 0; y < r * 2; y++) {
				if (Math.pow(x - r, 2) + Math.pow(y - r, 2) <= Math.pow(r, 2)) {
					page[x][y] = 1;
				}
			}
		}
		for (int x = 0; x < r * 2; x++) {
			for (int y = 0; y < r * 2; y++) {
				if (Math.pow(x - (r - border), 2)
						+ Math.pow(y - (r - border), 2) <= Math.pow(r - border,
						2)) {
					page[x + border][y + border] = 0;
				}
			}
		}
	}

}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://lacuna-atelier.tistory.com/14?category=620467
 * 
 * @author WONJIN
 *
 */
public class Q6 {

	public static void main(String[] args) {
		String input = "have a nice day";
		input = input.replaceAll(" ", "");
		int l = input.length();
		int row = (int) Math.sqrt(12);
		int column = row;
		if (row * row != l) {
			column++;
		}

		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				if (j * column + i <= l) {
					System.out.println(input.charAt(j * column + i));
				}
			}
			System.out.println();
		}

		try {
			FileWriter fw = new FileWriter("out.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < column; i++) {
				for (int j = 0; j < row; j++) {
					if (j * column + i <= l) {
						bw.write(input.charAt(j * column + i));
					}
				}
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

	}

}

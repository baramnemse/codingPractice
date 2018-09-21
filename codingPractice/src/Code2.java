import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Code2 {

	/*
	 * 
	 * 데이터 속의 전송량을 읽는다.
	 * 
	 * return 전송량
	 */

	static int readResponseBytes(String line) {

		String tokens[] = line.split(" ");

		// 전송바이트는 라인의 마지막 부분에 저장되므로 마지막기준으로 읽는것이 유리함

		String payloadString = tokens[tokens.length - 1];

		return Integer.parseInt(payloadString);

	}

	/*
	 * 
	 * 저장할 파일이름을 가져온다.
	 */

	static String getFilename(String filename) {

		return "bytes_" + filename;

	}

	static void saveFile(String filename, long count, long totalPayload) {

		// 저장할 파일네임

		String filenameToSave = getFilename(filename);

		try {

			File file = new File(filenameToSave);

			FileWriter writer = new FileWriter(file);

			writer.write("" + count);

			writer.write('\n');

			writer.write("" + totalPayload);

			writer.write('\n');

			writer.flush();

			writer.close();

		} catch (Exception e) {

			// 예외 로그 저장

		}

	}

	/*
	 * 
	 * 네트워크 로그 파일을 읽어서 6천바이트가 넘어가는 응답의 수와 총 전송량을 bytes_{filename} 형태로 저장한다.
	 */

	static void makeFile(String filename) {

		// 파일오픈

		try {

			BufferedReader reader = new BufferedReader(new FileReader(filename));

			String line;

			long count = 0;

			long totalPayload = 0;

			// 한라인씩 읽어서 전송바이트를 읽는다.

			while ((line = reader.readLine()) != null) {

				int payload = readResponseBytes(line);

				if (payload > 5000) {
					count++;
					totalPayload += payload;
				}


			}

			reader.close();

			// 파일저장

			saveFile(filename, count, totalPayload);

		} catch (IOException e) {

			// 이곳에 예외 로그를 남긴다.

		}

	}

	public static void main(String args[]) throws Exception {

		makeFile("hosts_access_log_00.txt");

	}
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Array2D {

    /**
     * O(n^2)
     * @param arr
     * @return
     */
    static int hourglassSum(int[][] arr) {
        int width = arr[0].length;
        int height = arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=height-3;i++){
            for(int j=0;j<=width-3;j++){
                int value=arr[i+0][j+0]+arr[i+0][j+1]+arr[i+0][j+2]+arr[i+1][j+1]+arr[i+2][j+0]+arr[i+2][j+1]+arr[i+2][j+2];
                max=Math.max(value,max);
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


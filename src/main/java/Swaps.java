import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Swaps {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumSwaps function below.
    private static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[iMin]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                int tmp = arr[i];
                arr[i] = arr[iMin];
                arr[iMin] = tmp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

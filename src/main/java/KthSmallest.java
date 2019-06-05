import java.util.Random;

class KthSmallest {

    private Random rand = new Random();

    public static void main(String[] args) {
        System.out.println(new KthSmallest().kthSmallest(new int[] { 1, 4, 2, 5, 3, 7 }, 3));
    }

    public int stringToInt(String in) {
        int value = 0;
        for (char ch : in.toCharArray()) {
            value = value * 10 + Character.getNumericValue(ch);
        }
        return value;
    }

    public int kthSmallest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException();
        }
        return kthSmallest(arr, 0, arr.length - 1, k - 1);
    }

    private int kthSmallest(int[] arr, int left, int right, int k) {
        int smallerSize = partition(arr, left, right) - left + 1;
        if (k == smallerSize - 1) {
            return arr[smallerSize];
        } else if (k < smallerSize) {
            return kthSmallest(arr, left, left + smallerSize - 1, k);
        } else {
            return kthSmallest(arr, left + smallerSize, right, k - smallerSize);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int i = left + 1;
        int j = right;
        while (true) {
            while (arr[i] < arr[left]) {
                if (i == right) {
                    break;
                }
                i++;
            }

            while (arr[j] > arr[left]) {
                if (j == left) {
                    break;
                }
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class PrimeValidator {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named PrimeValidator. */
        Scanner sc = new Scanner(System.in);
        boolean[] isPrime = generatePrimes(100500);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
            System.out.println(isPrime[n] ? "Prime" : "Not prime");

            t--;
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        // check if n is multiple of primes
        for (int i = 2; i < Math.round(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] generatePrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, 2, isPrime.length, true);

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOffPrimeMultiples(isPrime, prime);

            prime = getNextPrime(prime, isPrime);
        }
        return isPrime;
    }

    private static int getNextPrime(int prime, boolean[] isPrime) {
        int next = prime + 1;
        while (next < isPrime.length && !isPrime[next]) {
            next++;
        }
        return next;
    }

    private static void crossOffPrimeMultiples(boolean[] isPrime, int prime) {
        for (int i = prime * prime; i < isPrime.length; i += prime) {
            isPrime[i] = false;
        }
    }
}

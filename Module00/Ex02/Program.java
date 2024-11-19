import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long number = 0;
		int count = 0;
		int sum = 0;
		boolean isPrime = true;
		while (number != 42) {
			isPrime = true;
			System.out.print("-> ");
			number = in.nextInt();
			sum = getSum(number);
			if (sum < 2 || number == 42)
				continue;
			else {
				int i = 2;
				for (i = 2; i * i <= sum; i++) {
					if (sum % i == 0) {
						isPrime = false;
						// System.out.println(i + " sum " + sum);
					}
				}
				// System.out.println(number + " is " + isPrime + " sum of it = " + sum);
				if (isPrime)
					count++;
			}
		}
		in.close();
		System.out.println("Count of coffee-request : " + count);
	}

	public static int getSum(long value) {
		int sum = 0;
		int n = String.valueOf(value).length();
		for (int i = 0; i <= n; i++) {
			sum += value % 10;
			value /= 10;
		}
		return sum;
	}
}

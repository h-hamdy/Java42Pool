import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {
	public static void main(String[] args) {

		int primeNumber;
		boolean isPrime = true;

		System.out.print("->  ");
		Scanner in = new Scanner(System.in);
		try {
			primeNumber = in.nextInt();
	
	
			if (primeNumber < 2)
				System.err.println("IllegalArgument");
			else {
				int i = 2;
				for (i = 2; i * i <= primeNumber; i++) {
					if (primeNumber % i == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime)
					System.out.println("true " + (i - 1));
				else
					System.out.println("false " + (i - 1));
			}
		}
		catch(InputMismatchException e) {
			System.err.println("IllegalArgument");
		}
		in.close();
	}
}

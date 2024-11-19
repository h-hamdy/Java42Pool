public class Program {
	public static void main(String args[]) {
		int number = 479598;
		int sum = 0;
		String Snumber = Integer.toString(number);
		for (int i = 0; i < Snumber.length(); i++) {
			sum += Character.getNumericValue(Snumber.charAt(i));
		}
		System.out.println(sum);
	}
}

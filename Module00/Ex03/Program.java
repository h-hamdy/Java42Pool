import java.util.LinkedList;
import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		String weekNum = "";
		String statsNum = "";
		short weekCount = 1;
		Scanner inWeek = new Scanner(System.in);
		Scanner inStats = new Scanner(System.in);
		LinkedList<Short> stats = new LinkedList<>();

		System.out.print("-> ");
		weekNum = inWeek.nextLine();

		while (weekNum.equals("42") == false && weekCount <= 18) {
			if (checkWeek(weekNum.trim(), weekCount) == false)
				throwError(inWeek, inStats);

			System.out.print("-> ");
			statsNum = inStats.nextLine();
			if (getMinStats(statsNum) != -1)
				stats.add(getMinStats(statsNum));
			else
				throwError(inWeek, inStats);
			weekCount++;
			System.out.print("-> ");
			weekNum = inWeek.nextLine();
		}
		inWeek.close();
		inStats.close();
		drawStats(stats);
	}

	public static boolean checkWeek(String value, short weekCount) {
		if (value.length() < 6)
			return false;
		if (value.substring(0, 4).equals("week") == false
				|| value.substring(5).equals(Integer.toString(weekCount)) == false)
			return false;
		return true;
	}

	public static short getMinStats(String stats) {
		Short min;
		String[] statsArr = stats.split(" ");
		if (statsArr.length != 5)
			return -1;
		try {

			min = Short.parseShort(statsArr[0]);
			for (int i = 0; i < statsArr.length; i++) {
				if (Short.parseShort(statsArr[i]) > 9 || Short.parseShort(statsArr[i]) < 1)
					return -1;
				if (Short.parseShort(statsArr[i]) < min)
					min = Short.parseShort(statsArr[i]);
			}
		} catch (NumberFormatException e) {
			return -1;
		}
		return min;
	}

	public static void throwError(Scanner inWeek, Scanner inStats) {
		System.err.println("IllegalArgument");
		inWeek.close();
		inStats.close();
		System.exit(-1);
	}

	public static void drawStats(LinkedList<Short> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print("week " + (i + 1) + " ");
			for (short j = 0; j < list.get(i); j++) {
				System.out.print("=");
			}
			System.out.println(">");
		}
	}
}

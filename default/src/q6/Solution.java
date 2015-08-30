package q6;

import java.util.Scanner;

public class Solution {

	private static int maxCube = 21;
	private static long[][] amounts = new long[maxCube + 1][10000];

	public static long cube(long x) {
		return (long) Math.pow(x, 3);
	}

	public static void dp() {
		amounts[0][1] = 1;
		for (int i = 0; i < 10000; i++)
			amounts[1][i] = 1;

		for (int i = 2; i < maxCube + 1; i++) {
			for (int j = 0; j < 10000; j++) {
				long x = (j - cube(i) >= 0) ? amounts[i][(int) (j - cube(i))]
						: 0;
				long y = (amounts[i - 1][j]);
				amounts[i][j] = x + y;
			}
		}
	}

	public static int ways(int val, int maxThresh) {
		if (val == 0)
			return 1;

		int max = Math.min((int) Math.pow(val, 1.0 / 3.0), maxThresh);
		int total = 0;

		int temp = val - (int) Math.pow(max, 3);
		if (amounts[max][temp] == 0) {
			total += ways(temp, max);
			// amounts[max][temp] = total;
		} else {
			total += amounts[max][temp];
		}

		if (max > 1) {
			total += ways(val, max - 1);
		}
		amounts[max][val] = total;
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		dp();

		while (sc.hasNext()) {
			int val = sc.nextInt();
			System.out.println(amounts[maxCube][val]);
		}
		sc.close();
	}

}

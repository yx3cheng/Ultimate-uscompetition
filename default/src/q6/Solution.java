package q6;

import java.util.Scanner;

public class Solution {

	//TODO: incomplete for value > 7000
	
	private static int maxCube = 21;
	private static int[][] amounts = new int[22][10000];

	
	public static void dp() {
		amounts[0][1] = 1;
		for (int i = 0; i < 10000; i++)
			amounts[1][i] = 1;
		
		for (int i = 2; i < 22; i++) {
			for (int j = 0; j < 10000; j++) {
				int x = (j - Math.pow(i, 3) >= 0) ? amounts[i][j-(int)Math.pow(i, 3)]: 0;
				int y = (amounts[i-1][j]);
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
			//amounts[max][temp] = total;
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

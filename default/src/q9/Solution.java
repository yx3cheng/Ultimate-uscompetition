package q9;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			long pieces = sc.nextLong();
			if (pieces == -1) {
				sc.close();
				return;
			}
			if (pieces == 1) {
				System.out.println("0%");
			} else {
				System.out.println(pieces * 25 + "%");
			}
		}
		sc.close();
	}

}

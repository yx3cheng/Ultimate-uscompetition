package q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	private static Map<String, Integer> sums;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sums = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int ctr = sc.nextInt();
			for (int i = 0; i < ctr; i++) {
				sums.put(sc.next(), new Integer(0));
			}
			for (int h = 0; h < ctr; h++) {
				String sender = sc.next();
				
				int val = sc.nextInt();

				int rec_count = sc.nextInt();
				for (int i = 0; i < rec_count; i++) {
					sums.put(sender, sums.get(sender) - val / rec_count);
					String receiver = sc.next();
					sums.put(receiver, sums.get(receiver) + val / rec_count);
				}
			}
			for (Entry<String, Integer> entry : sums.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			sums.clear();
			System.out.println("");
		}
		sc.close();
	}

}

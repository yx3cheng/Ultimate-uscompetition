package q8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		int ctr = 1;
		while (true) {
			int z = sc.nextInt();
			int i = sc.nextInt();
			int m = sc.nextInt();
			int l = sc.nextInt();
			if (z == 0 && i == 0 && m == 0 && l == 0) {
				sc.close();
				return;
			}
			loop: while (true) {
				if (map.containsKey(l)) {
					//System.out.println("");
					System.out.println("Case " + ctr + ": "
							+ (list.size() - map.get(l)));
					list.clear();
					map.clear();
					ctr++;
					break loop;
				} else {
					map.put(l, list.size());
					list.add(l);
				}
				//System.out.print(l + " ");
				l = (z * l + i) % m;
			}
		}
	}
}

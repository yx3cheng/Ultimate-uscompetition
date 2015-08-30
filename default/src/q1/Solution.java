package q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static Map<Record, Set<String>> dictionary;

	public class Record {
		public int[] values;

		public Record() {
			values = new int[26];
		}

		public Record(int[] blah) {
			values = blah;
		}

		@Override
		public int hashCode() {
			int sum = 0;
			for (int i = 0; i < 26; i++)
				sum += values[i] * i;
			return sum;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Record))
				return false;
			Record newrec = (Record) obj;
			for (int i = 0; i < 26; i++) {
				if (this.values[i] != newrec.values[i])
					return false;
			}
			return true;
		}

	}

	public static Record render(String str) {
		int[] values = new int[26];
		for (int i = 0; i < 26; i++)
			values[i] = 0;
		for (int i = 0; i < str.length(); i++) {
			values[(int) str.charAt(i) - 97]++;
		}
		Record record = new Solution().new Record(values);

		return record;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();

		while (sc.hasNext()) {
			String temp = sc.next();
			if (temp.equals("#"))
				break;
			inputs.add(temp);
		}
		sc.close();
		dictionary = new HashMap<>();

		for (String str : inputs) {
			Record hashcode = render(str.toLowerCase());

			if (dictionary.containsKey(hashcode)) {
				dictionary.get(hashcode).add(str);
			} else {
				Set<String> temp = new HashSet<>();
				temp.add(str);
				dictionary.put(hashcode, temp);
			}
		}

		List<String> outputs = new ArrayList<>();

		for (Set<String> values : dictionary.values()) {
			for (String str : values) {
				if (values.size() == 1 || str.length() == 1) {
					outputs.add(str);
					// System.out.println(values.get(0));
				}
			}
		}
		Collections.sort(outputs);
		for (String str : outputs) {
			System.out.println(str);
		}

	}
}

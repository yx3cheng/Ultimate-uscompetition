package q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public class Problem {
		public Double power;
		public Double current;
		public Double voltage;

		public Problem() {
		}

		public String solve() {
			if (power == null) {
				power = new Double(current * voltage);
				return String.format("P=%.2fW", power);
			}
			if (current == null) {
				current = new Double(power / voltage);
				return String.format("I=%.2fA", current);
			}
			if (voltage == null) {
				voltage = new Double(power / current);
				return String.format("U=%.2fV", voltage);
			}
			return "";

		}
	}

	public static void parseNumber(Problem problem, String str) {
		String[] tokens = str.split("[a-z][A-z]");
		double val = Double.parseDouble(tokens[0]);

		if (tokens[1].equals("m"))
			val = val / 1000.0;
		if (tokens[1].equals("k"))
			val = val * 1000.0;
		if (tokens[1].equals("M"))
			val = val * 1000000.0;
		if (tokens[1].equals("V") || tokens[2].equals("V"))
			problem.voltage = val;
		if (tokens[1].equals("P") || tokens[2].equals("P"))
			problem.power = val;
		if (tokens[1].equals("I") || tokens[2].equals("I"))
			problem.current = val;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linecount = sc.nextInt();
		List<Problem> problems = new ArrayList<>();
		Pattern p = Pattern
				.compile("[P|U|I]=[-]?[0-9][0-9]*(.[0-9][0-9]*|[e][-][0-9][0-9]*)?[m|k|M]?[A|V|W]");

		for (int i = 0; i <= linecount; i++) {
			String line = sc.nextLine();
			Problem problem = new Solution().new Problem();

			Matcher m = p.matcher(line);
			while (m.find()) {
				String exp = m.group(0);
				// System.out.println(exp);

				double value = 1.0;
				char type = exp.charAt(0);
				exp = exp.substring(2);
				exp = exp.substring(0, exp.length() - 1);
				if (exp.charAt(exp.length() - 1) == 'k') {
					value *= 1000.0;
					exp = exp.substring(0, exp.length() - 1);
				} else if (exp.charAt(exp.length() - 1) == 'm') {
					value /= 1000.0;
					exp = exp.substring(0, exp.length() - 1);
				} else if (exp.charAt(exp.length() - 1) == 'M') {
					value *= 1000000.0;
					exp = exp.substring(0, exp.length() - 1);
				}
				value = value *= Double.parseDouble(exp);

				if (type == 'P') {
					problem.power = new Double(value);
				}
				if (type == 'I') {
					problem.current = new Double(value);
				}
				if (type == 'U') {
					problem.voltage = new Double(value);
				}
			}

			problems.add(problem);
		}

		problems.remove(0);

		for (int i = 0; i < linecount; i++) {
			System.out.println(String.format("Problem #%d", i + 1));
			System.out.println(problems.get(i).solve());
			System.out.println("");
		}
		
		sc.close();
	}
}

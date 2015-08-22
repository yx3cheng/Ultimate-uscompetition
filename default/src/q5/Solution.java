package q5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNext())
		{
			int game_ctr = sc.nextInt();
			int lives = 7;
			if (game_ctr == -1)
				return;
			System.out.println("Round " + game_ctr);
			
			String word = sc.next();
			Set<Character> letters = new HashSet<>();
			for (int i = 0; i < word.length(); i++) {
				letters.add(word.charAt(i));
			}
			
			String guess = sc.next();
			Set<Character> guessed = new HashSet<>();
			round: for (int i = 0; i < guess.length(); i++) {
				char c = guess.charAt(i);
				if (!guessed.contains(c)) {
					if (letters.contains(c)) {
						letters.remove(c);
					}
					else {
						lives --;
					}
					if (lives == 0)
					{	System.out.println("You lose.");
						break round;
					}
					else if (letters.isEmpty())
					{	System.out.println("You win.");
						break round;
					}
					guessed.add(c);
					
				}
			}
			if (!letters.isEmpty() && lives > 0) {
				System.out.println("You chickened out.");
			}
		}
		
		sc.close();
	}
}

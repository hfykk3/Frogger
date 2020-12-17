package hud;

import javax.swing.*;

import p4_group_8_repo.Main;

import java.awt.*;
import java.util.*;

public class HighScore extends Main {

	public class Score {
		int points;
		String name;
		
		Score(String name, int points) {
			this.name = name;
			this.points = points;
		}
	}
	
	public HighScoreData data = new HighScoreData(10);

	/**
	 *	The max number of entries
	 */
	public HighScore(int limit) {
		data.entries = new ArrayList<>();
		this.data.limit = limit;
	}
	
	public HighScore() {
		data.entries = new ArrayList<>();
		this.data.limit = data.DEFAULT_LIMIT;
	}
	
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Score score: data.entries) {
			sb.append(String.format("%s %d\n", score.name, score.points));
		}
		return sb.toString();
	}
	
	/**
	 * Inserts a new entry into the HighScore if it meets condition.
	 */
	public boolean addEntry(String name, int points) {
		Score score;
		for(int i = 0, len = Math.min(data.entries.size(), data.limit-1); i <= len; ++i) {
			score = i < data.entries.size()? data.entries.get(i): null;
			if(score == null || points > score.points) {
				data.entries.add(i, new Score(name, points));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a list of names in the HighScore in ascending order.
	 */
	public String[] getNames() {
		String[] names = new String[data.entries.size()];
		for(int i = 0; i < data.entries.size(); ++i)
			names[i] = data.entries.get(i).name;
		return names;
	}
	
	
	public int[] getPoints() {
		int[] points = new int[data.entries.size()];
		for(int i = 0; i < data.entries.size(); ++i)
			points[i] = data.entries.get(i).points;
		return points;
	}
	

	public int getSize() {
		return data.entries.size();
	}
	
	/**
	 * Recovers a HighScore that was saved via toString().
	 */
	public static HighScore fromString(String s) {
		HighScore highscore = new HighScore();
		
		Scanner sc = new Scanner(s);
		String[] parts;
		while(sc.hasNextLine()) {
			parts = sc.nextLine().split(" ");
			highscore.addEntry(parts[0], Integer.parseInt(parts[1]));
		}
		sc.close();
		
		return highscore;
	}
}

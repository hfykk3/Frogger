package hud;

import java.util.ArrayList;

import hud.HighScore.Score;

public class HighScoreData {
	public ArrayList<Score> entries;
	public int limit;
	public int DEFAULT_LIMIT;

	public HighScoreData(int dEFAULT_LIMIT) {
		DEFAULT_LIMIT = dEFAULT_LIMIT;
	}
}
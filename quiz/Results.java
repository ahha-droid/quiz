package quiz;

import java.util.ArrayList;

public class Results {
	private int score;
	private int quest;
	ArrayList<Integer> al = new ArrayList<Integer>();
	
	public Results() {
		score=0;
		quest=0;
		al.add(-2);
	}
	
	public Results(int score, int quest, ArrayList<Integer>al){
		this.score=score;
		this.quest=quest;
		this.al=al;
	}
	
	public int getScore() {return score;}
	public int getQuest() {return quest;}
	public ArrayList<Integer> getAl() {return al;}
	
	public void setScoreP() {this.score = score+2;}
	public void setScoreM() {this.score = score-1;}
	public void setQuest() {this.quest = quest+1;}
	public void setAl(ArrayList<Integer> al) {this.al = al;}
	
	public ArrayList<Integer> setAl2(int x) {
		ArrayList<Integer> al2 = al;
		al2.add(x);
		return al2;
	}
	
}
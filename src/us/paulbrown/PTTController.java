package us.paulbrown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.util.Log;

public class PTTController {
	
	int historyPosition;
	HashMap<Integer, PTTNode> nodes;
	PTTNode currentNode;
	

	public PTTController() {
		super();
		this.historyPosition = 0;
		
		
		
		
		//filler code that creates some nodes. we need to abstract this out
		PTTAnswer node0answer0 = new PTTAnswer(1, "Yes");
		PTTAnswer node0answer1 = new PTTAnswer(2, "No");
		
		ArrayList<PTTAnswer> answers0 = new ArrayList<PTTAnswer>();
		answers0.add(node0answer0);
		answers0.add(node0answer1);
		
		PTTAnswer node1answer0 = new PTTAnswer(3, "Yes");
		PTTAnswer node1answer1 = new PTTAnswer(4, "No");
		
		ArrayList<PTTAnswer> answers1 = new ArrayList<PTTAnswer>();
		answers1.add(node1answer0);
		answers1.add(node1answer1);
		
		
		
		
		ArrayList<String> footnotes = new ArrayList<String>();
		footnotes.add("none");
		
		PTTNode node0 = new PTTNode(0,"Does the patient have prolonged PTT and normal PT?",answers0,footnotes);
		PTTNode node1 = new PTTNode(1,"Is the patient older than 6 months?",answers1,footnotes);
		
		//end filler code to create nodes
		
		
		//map to hold nodes
		this.nodes = new HashMap<Integer, PTTNode>();
		this.nodes.put(node0.getId(),node0);
		this.nodes.put(node1.getId(),node1);
	}
	
	
	//this method returns the question for a particular node
	public String getQuestionForNodeNumber(int nodeNumber) {
		PTTNode n = this.nodes.get(nodeNumber);
		return n.getQuestion();
	}
	
	
	//this method returns the text and targets of each answer in a node
	public ArrayList<PTTAnswer> getAnswersForNodeNumber(int nodeNumber) {
		ArrayList<PTTAnswer> answers = new ArrayList<PTTAnswer>();
		
		//TODO: iterate through all answers
		
		PTTNode n = this.nodes.get(nodeNumber);
		answers.add(n.answers.get(0));
		answers.add(n.answers.get(1));
		
		
		return answers;
	}
	
	
	
	
	
	public HashMap<Integer, PTTNode> getNodes() {
		return nodes;
	}




	public int getHistoryPosition() {
		return historyPosition;
	}

	public void setHistoryPosition(int historyPosition) {
		this.historyPosition = historyPosition;
	}

}

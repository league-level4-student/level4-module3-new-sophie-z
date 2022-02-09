package _01_Spies_On_A_Train;

import java.util.Arrays;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	Node<TrainCar> node = train.getHead();
    	String name = "";
    	System.out.println(Arrays.toString(clues));
    	while(!node.equals(train.getTail())) {
    		String evidence = node.getValue().questionPassenger();
    		System.out.println(evidence);
    		String[] evidences = evidence.split("I saw ");
    		name = evidences[1].split(" ")[0];
    		System.out.println(evidences[1]);
    		String clue = evidences[1].substring(evidences[1].indexOf(" ")+1);
    		System.out.println(clue);
    		for(int i = 0; i<clues.length; i++) {
    			if(clue.equals(clues[i] + ".")) {
    				if(map.containsKey(name)) {
    					map.put(name, map.get(name)+1);
    					if(map.get(name)==3) {
    		       			return name;
    		       	    }
    				}
    				else {
    					map.put(name, 1);
    				}
    			}
    		}
    		System.out.println(name + " " + map.get(name));
    		node = node.getNext();
       		}
       		return "";
    	}
}
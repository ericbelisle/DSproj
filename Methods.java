import java.util.Stack;
import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;

class Methods{

	//populate HashMap method
	public static HashMap populateHashMap(int size){
	
		//creates HashMap
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		//random number generator
		Random random = new Random();
		
		//iterates to put random numbers in hash map up to size
		for(int i = 0; i < size; i++){
			hm.put(i, new Integer(random.nextInt()));
		}
		
		//returns stack
		return hm;

	} 
	
	//populate Stack method
	public static Stack populateStack(int size){
	
		//creates stack
		Stack<Integer> st = new Stack<Integer>();
		//random number generator
		Random random = new Random();
		
		//iterates to put random numbers in stack up to size
		for(int i = 0; i < size; i++){
			st.push(new Integer(random.nextInt()));
		}
		
		//returns stack
		return st;

	} 
	
	//populate LinkedList method
	public static LinkedList populateLinkedList(int size){
	
		//creates LinkedList linked
		LinkedList<Integer> linked = new LinkedList<Integer>();
		//random number generator
		Random random = new Random();
		
		//iterates to put random numbers in LinkedList up to size
		for(int i = 0; i < size; i++){
			linked.add(random.nextInt());
		}
		
		//returns LinkedList linked
		return linked;

	} 
	
	//populate array method
	public static int[] populateIntArray(int size){
	
		//creates intarray at size
		int[] intarray = new int[size];
		//random number generator
		Random random = new Random();
		
		//iterates to put random numbers in intarray up to size
		for(int i = 0; i < size; i++){
			intarray[i] = random.nextInt();
		}
		
		//returns LinkedList linked
		return intarray;

	}
		
}


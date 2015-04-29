/*
Algorithm:
insertion - DONE
deletion - DONE
merge sort - 
linear search - DONE

Data Structure:
Array - DONE
LinkedList - DONE
Stack - DONE
HashMap - DONE
*/


import java.util.Stack;
import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;

class Methods{

//does this make me a bad person? I sleep sound at night.. 
@SuppressWarnings("unchecked") 

	public static void main(String args[]){
		HashMap hm = populateHashMap(10);
		Stack st = populateStack(10);
		LinkedList<Integer> linked = populateLinkedList(10);
		int[] intarray = populateArray(10);
		
		System.out.println(linearSearchStack(st, 1));
		System.out.println(linearSearchHashMap(hm, 1));
		System.out.println(linearSearchLinkedList(linked, 1));
		System.out.println(linearSearchArray(intarray, 1));
	
	
	}
	
	//linearSearch on HashMap
	public static boolean linearSearchHashMap(HashMap<Integer, Integer> hm, int item){
		for (int i = 0; i < hm.size(); i++){
			if(hm.get(i).equals(item)) return true;
		}
		return false;
	}
	
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
	
	//linearSearch on stack
	public static boolean linearSearchStack(Stack<Integer> st, int item){
		for (int i = 0; i < st.size(); i++){
			if(st.pop().equals(item)) return true;
		}
		return false;
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
	
	//linearSearch on LinkedList
	public static boolean linearSearchLinkedList(LinkedList<Integer> linked, int item){
		for (int i = 0; i < linked.size(); i++){
			if(linked.get(i).equals(item)) return true;
		}
		return false;
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
	
	//linearSearch on Array
	public static boolean linearSearchArray(int[] intarray, int item){
		for (int i = 0; i < intarray.length; i++){
			if(intarray[i] == item) return true;
		}
		return false;
	}
	
	//populate array method
	public static int[] populateArray(int size){
	
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


import java.util.*;

public class BinaryHeap<E extends Comparable<? super E>> {
	ArrayList<E> keylist;
	int size;
	public BinaryHeap() {
		keylist = new ArrayList<>();
		size = 0;
	}

	public E remove() {
		if(size<1){
			System.err.println("Error empty pq");
			return null;
		}else{
			size--;
			E minNode = keylist.get(0);  	// Get the top node
			keylist.set(0, keylist.get(keylist.size()-1));		// Set top node = last node;
			keylist.remove(keylist.size()-1);
			heapify(0);							// Heapify
			return minNode;
		}
	}
	
	private void swap(int node_i,int node_j){
		E temp = keylist.get(node_j);
		keylist.set(node_j, keylist.get(node_i));
		keylist.set(node_i, temp);
	}
	
	public void heapify(int index){
		int left =  2*index+1;	
		int right = 2*index+2;
		int minimum = index;
		
		if(right < size &&  keylist.get(right).compareTo(keylist.get(index))<0){ // Right is smaller
			minimum = right;
		}
		
		if(left < size && keylist.get(left).compareTo(keylist.get(minimum))<0){ // left is smallest
			minimum = left;
		}
		
		if(minimum!= index){	//Index is not minimum => swap index node with minimum node
			swap(index,minimum); 
			heapify(minimum);
		}
	}
	
	public int size() {
		return keylist.size();
	}
	
	private int parent(int index){
		return (index-1)/2;
	}
	
	public void add(E node) {	 //No issues with add	
		int index = size++;
		keylist.add(node);
		while(index > 0 && node.compareTo(keylist.get((index-1)/2))<0){ //  node.frequency< parent.frequency
			swap((index-1)/2,index);
			index = (index-1)/2;
		}
	}

	public E top() {
		return keylist.get(0);
	}

	public String toString(){
		String result = "";
		for (E heapNode : keylist) {
			result  = result + heapNode.toString() + " ";
		}
		return result;
	}
}

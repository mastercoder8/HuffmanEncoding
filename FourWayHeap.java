import java.util.ArrayList;
import java.util.List;
public class FourWayHeap {
	public List<Node> keylist;
    public FourWayHeap() {
    	keylist = new ArrayList<>();
    	keylist.add(new Node(-1,-1)); //Dummy for cache optimization
    	keylist.add(new Node(-1,-1)); //Dummy
    	keylist.add(new Node(-1,-1)); //Dummy
    }    
 // 0 1 2 3 4 5 6 7 8 9 
 // 0 0 0 4 5 6 7 8 9 10
    private int parent(int c) { 
    	return  2+ c/4;
    }    

    private int leftChild(int p) {
    	return 4*(p-2);
    }
    
    private int leftmostChild(int p){
    	return 4*(p-2)+1;
    }
    
    private int rightChild(int p) {
    	return 4*(p-2)+2;
    } 
    
    private int rightmostChild(int p){
    	return 4*(p-2)+3;
    }

    public int size() {
    	return keylist.size()-3; 
    }

	private void swap(int i, int j) {
		Node temp = keylist.get(i);
        keylist.set(i, keylist.get(j));
        keylist.set(j, temp);
	}
	public String toString(){
		String result = "";
		for (Node heapNode : keylist) {
			result  = result + heapNode.toString() + " ";
		}
		return result;
	}

	public void add(Node node) {
		keylist.add(node);
	    int child = keylist.size() - 1;
	    int parent = parent(child);
		while( child != 0 && (keylist.get(parent).frequency > keylist.get(child).frequency)){
			swap(parent,child);
			child = parent;
			parent = parent(child);
		}
	}

	public Node remove(){
		 if (size() == 0){
			 System.err.println("No elements");
			 return null;
		 }

		 Node top = keylist.get(3);
		 keylist.set(3, keylist.get(keylist.size() - 1));
		 keylist.remove(keylist.size() - 1);
		 minHeapify(3);
		return top;
	}
	
	private void minHeapify(int parent) {	
		int min = parent;
		for(int i=0;i<4;i++){
			int child = 4*(parent-2)+i;
			if(child < keylist.size() && keylist.get(child).frequency < keylist.get(min).frequency){
				min = child;
			}
		}
		
		if(min != parent){
			swap(parent,min);
			minHeapify(min);
		}
	}
}
import java.util.Map;

/* Class PairNode */
	class PairNode
	{
		int number;
	    int frequency;
	    PairNode leftChild;
	    PairNode nextSibling;
	    PairNode prev;
	    PairNode left;
	    PairNode right;
	    /* Constructor */
	    public PairNode(int number,int frequency)
	    {
	    	this.number = number;
	        this.frequency = frequency;
	        leftChild = null;
	        nextSibling = null;
	        prev = null;
	        left = null;
	        right = null;
	    }
	    

	    public PairNode(int number, int frequency, PairNode smallnode, PairNode smallest){
			this.number = number;
			this.frequency = frequency;
			leftChild = null;
			nextSibling = null;
			prev = null;
			this.left = smallnode;
			this.right = smallest;
		}
		
		public int compareTo(Node other) {
			return frequency - other.frequency;
		}

		//fill tree with 0 1
		public void fillEncodingMap(Map<Integer, String> map, String prefix) {
			if (left == null) // it's a leaf
			{
				map.put(number, prefix);
			} 
			else {
				left.fillEncodingMap(map, prefix + "0");
				right.fillEncodingMap(map, prefix + "1");
			}
		}

		public String toString() {
			if(number==-1) return "*-"+frequency;
			return number + "-" + frequency;
		}
	}
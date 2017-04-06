import java.util.*;


class Node implements Comparable<Node> {
		public int number;
		public int frequency;
		public Node left;
		public Node right;
		Node(){
			this.number = 0;
			this.frequency = 0;
		}
		Node(int number, int frequency){
			this.number = number;
			this.frequency = frequency;
			this.left = null;
			this.right = null;
		}
		Node(int number, int frequency, Node leftNode, Node rightNode){
			this.number = number;
			this.frequency = frequency;
			this.left = leftNode;
			this.right = rightNode;
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
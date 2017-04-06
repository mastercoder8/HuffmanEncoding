import java.util.*;

public class HuffmanTree {
	private Node root;
	BinaryHeap<Node> nodes;
	
	HuffmanTree(Map<Integer,Integer> frequencies){
		nodes = new BinaryHeap<>();
		
		for (int num : frequencies.keySet()) {
			nodes.add(new Node(num,frequencies.get(num)));
		}
		root = buildHuffmanTree();		
	}
	
	private Node buildHuffmanTree(){
		while (nodes.size() > 1) {					//reduce queue to node set last node to root
			Node smallest = nodes.remove();			//remove the head of this queue
			Node nextSmallest = nodes.remove();		//Second head
			nodes.add(new Node(-1, smallest.frequency + nextSmallest.frequency , smallest, nextSmallest));
		}
		return nodes.remove();
	}
	
	public Map<Integer, String> getEncodingMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		if (root != null) {
			root.fillEncodingMap(map, "");
		}
		return map;
	}
}

import java.util.*;

 class HuffmanTreePairHeap {
	private PairNode root;
	PairHeap nodes;
	
	HuffmanTreePairHeap(Map<Integer,Integer> frequencies){
		nodes = new PairHeap();
		
		for (int num : frequencies.keySet()) {
			nodes.add(new PairNode(num,frequencies.get(num)));
		}
		root = buildHuffmanTree();		
	}
	
	private PairNode buildHuffmanTree(){
		while (nodes.size() > 1) {					//reduce queue to node set last node to root
			PairNode smallest = nodes.remove();			//remove the head of this queue
			PairNode nextSmallest = nodes.remove();		//Second head
			nodes.add(new PairNode(-1, smallest.frequency + nextSmallest.frequency , smallest, nextSmallest));
		}
		
		
		return  nodes.remove();
	}
	
	public Map<Integer, String> getEncodingMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		if (root != null) {
			root.fillEncodingMap(map, "");
		}
		return map;
	}	
}

import java.util.Map;

public class PerformanceCompare {

	public static void main(String[] args) {
		Map<Integer, Integer> frequencies = new FrequencyTable().generateFrequencyMap("sample_input_large.txt");
		double mean = 0;
		for(int i=0;i<10;i++){
			double start = System.nanoTime();
			HuffmanTreePairHeap h = new HuffmanTreePairHeap(frequencies);
			double now = System.nanoTime();
			mean = mean + (now-start);
		}
		System.out.println("Pair Heap Mean: "+mean/(10*1000000)+" ms");
		
		mean = 0;
		for(int i=0;i<10;i++){
			double start = System.nanoTime();
			HuffmanTree4Way h = new HuffmanTree4Way(frequencies);
			double now = System.nanoTime();
			mean = mean + (now-start);
		}
		System.out.println("Tree 4Way Mean: "+mean/(10*1000000)+" ms");
		
		mean = 0;
		for(int i=0;i<10;i++){
			double start = System.nanoTime();
			HuffmanTree h = new HuffmanTree(frequencies);
			double now = System.nanoTime();
			mean = mean + (now-start);
		}
		System.out.println("Binary Tree Mean: "+mean/(10*1000000)+" ms");
		
		
	}	
}

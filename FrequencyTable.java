
import java.util.*;
import java.io.*;
public class FrequencyTable {
	Map<Integer,Integer> freqT = new HashMap<>();	
	private void readInputFile(String fileName){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line =br.readLine();
			while((line)!=null && line.length()!=0){
				int key = Integer.parseInt(line);
				if(freqT.get(key)==null){
					freqT.put(key, 0);
					continue;
				}
				freqT.put(key,freqT.get(key)+1);
				line =br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println("Exception:"+e);
		}	
	}
	public Map<Integer,Integer> generateFrequencyMap(String fileName){
		readInputFile(fileName);
		return freqT;
	}
}

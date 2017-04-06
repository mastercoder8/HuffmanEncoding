import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class encoder {
	encoder(String inputFile){
		TimeManager t = new TimeManager();
		t.start();
		FrequencyTable freqT = new FrequencyTable();
		Map<Integer,Integer>frequencies = freqT.generateFrequencyMap(inputFile);
		
		System.out.println("["+t.now()+" ms]: Generated Frequency Table");
		HuffmanTree4Way tree = new HuffmanTree4Way(frequencies);
		Map<Integer, String> encodingMap = tree.getEncodingMap();
		System.out.println("["+t.now()+" ms]: Generated Encoding Map");
		writeCodeTable(encodingMap);
		System.out.println("["+t.now()+" ms]: Code Table Written");
		encode(inputFile,encodingMap);
		t.end();
	}
	
	public static void writeCodeTable(Map<Integer, String> encodingMap){
		File f = new File("code_table.txt");
		try{
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			Iterator it = encodingMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
				fw.write(pair.getKey() + " " + pair.getValue()+"\n");
		    }
		    fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public byte[] getByteArray(String bitString){
		BitSet bs = new BitSet(bitString.length());
		for(int i = 0;i<bitString.length();i++){
			if(bitString.charAt(i)=='1'){
				bs.set(i,true);
			}else{
				bs.set(i,false);
			}
		}
		return bs.toByteArray();		
	}
	
	public  File encode(String fileName, Map<Integer, String> encodingMap) {
		File f = new File("encoded.bin");

		try {
			f.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line= br.readLine();
	    	StringBuilder stringBuilder = new StringBuilder();
	    	while(line!=null&&line.length()!=0){
				String bitString = encodingMap.get(Integer.parseInt(line));
				stringBuilder.append(bitString);
				line = br.readLine();
			}
			br.close();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(getByteArray(stringBuilder.toString()));
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public static void main(String[] args){
		if(args.length<1){
			System.err.println("Input File Needed");
			return;
		}
		encoder en = new encoder(args[0]);
	}
}

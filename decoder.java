import java.io.*;
import java.util.*;

public class decoder{
	HuffTree ht;
	decoder(String encodedFile, String codetablefile){
		TimeManager t = new TimeManager();
		ht = new HuffTree();
		t.start();
		readCodeTable(codetablefile);	
		System.out.println("["+t.now()+" ms]: Code Table Read");
		ht.decode(new File(encodedFile));
		System.out.println("["+t.now()+" ms]: File Decoded");
		t.endS();
	}
	
	public void readCodeTable(String fileName){
		System.out.println("Reading Code Table");
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			do{
				String[] arr = line.split(" ");
				ht.insert(arr[1],Integer.parseInt(arr[0]));
				line = br.readLine();
			}while(line!=null&&line.length()!=0);
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private class HuffTree{
		class Node{
			int val;
			Node left;
			Node right;
			Node(int key){
				this.val = key;
				this.left = null;
				this.right = null;
			}
		}
		
		Node root;
		public HuffTree() {
			root = new Node(-1);
		}
		public void insert(String code, int key){
			insert(code, key, root);
		}
		private void insert(String code, int key, Node root){
			Node curr = root;
			for(int i=0;i < code.length();i++){
				if(code.charAt(i)=='0'){						
					if(curr.left!=null){
						curr = curr.left;
					}else{
						curr.left = (i == code.length()-1)?new Node(key): new Node(-1);
						curr = curr.left;
					}
				}else{
					if(curr.right!=null){
						curr = curr.right;
					}else{
						curr.right = (i == code.length()-1)?new Node(key): new Node(-1);
						curr = curr.right;
					}
				}
			}
		}	
		
		private  String getEncodedInputString(File file) {
			StringBuilder encoded = new StringBuilder();
			byte[] data = new byte[(int)file.length()];
			try {
				FileInputStream in = new FileInputStream(file);
				in.read(data);
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			BitSet bitset = BitSet.valueOf(data);
			for(int i = 0; i < data.length * 8; i++){
				encoded.append((bitset.get(i))?'1':'0');
			}
			return encoded.toString();

		}

		public File decode(File f){
			System.out.println("Decoding File");
			File decoded = new File("decoded.txt");
			try{
				decoded.createNewFile();
				String code = getEncodedInputString(f);
				FileWriter fw = new FileWriter(decoded);
				traverse(code, fw, root);
				fw.flush();
				fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return decoded;
		}

		private void traverse(String input, FileWriter fw, Node root) throws IOException {
			Node curr = root;
			for(int i=0;i<input.length();i++){
				curr = (input.charAt(i)=='0')? curr.left:curr.right;
				if(curr.left == null){
					fw.write(curr.val+"\n");
					curr = root;
				}
			}
		}
	}	
	public static void main(String[] args) {
		if(args.length<2){
			System.err.println("java decoder encoded.bin code_table.txt");
			return;
		}
		decoder d  = new decoder(args[0],args[1]);
	}
}

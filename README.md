# HuffmanEncoding
Huffman Codes - Compress and Decompress
# ADS Project 
Huffman Encoding To Compress Large Files using Best Heap (4 Way Cache Optimized heap in this case) -> code_table.txt, encoded.bin
Huffman Decoder To UnCompress the encoded files to return the source files
## Encoder
1. Source Files (sample_input_small.txt) => FrequencyTable -> FrequencyMap
2. FrequencyMap => encoder => HuffmanTree4Way -> HuffmanTree
3. HuffmanTree4Way => FourWayHeap -> encodingMap
4. encodingMap => encoder -> code-table.txt, encoded.bin

## Decoder
1. code_table.txt => decoder -> HuffTree (Decoder Tree)
2. encoded.bin => HuffTree.Traverse -> Source File (decoded.txt)

## Test
decoded.txt = sample_input_small.txt

## Run Steps
#### $ make 
javac -g TimeManager.java <br />
javac -g FrequencyTable.java  <br />
javac -g Node.java <br />
javac -g FourWayHeap.java <br />
javac -g HuffmanTree4Way.java <br />
javac -g encoder.java <br />
javac -g decoder.java <br />
javac -g PerformanceCompare.java  <br />
#### $ java encoder sample_input_small.txt 
[3276.0 ms]: Generated Frequency Table  <br />
[4384.0 ms]: Generated Encoding Map  <br />
[6562.0 ms]: Code Table Written <br />
Duration: 12602 ms <br />
#### $ java decoder encoded.bin code_table.txt 
Reading Code Table  <br />
[935.0 ms]: Code Table Read  <br />
Decoding File  <br />
[9656.0 ms]: File Decoded <br />
Duration: 9.0 s  <br />

### Encoder Run output 
![Alt text](encoder_output.png?raw=true "Encoder Run - Large input 10million lines")

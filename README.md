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
** $ make **
javac -g TimeManager.java
javac -g FrequencyTable.java
javac -g Node.java
javac -g FourWayHeap.java
javac -g HuffmanTree4Way.java
javac -g encoder.java
javac -g decoder.java
javac -g PerformanceCompare.java
** $ java encoder sample_input_small.txt **
[3276.0 ms]: Generated Frequency Table
[4384.0 ms]: Generated Encoding Map
[6562.0 ms]: Code Table Written
Duration: 12602 ms
** $ java decoder encoded.bin code_table.txt **
Reading Code Table
[935.0 ms]: Code Table Read
Decoding File
[9656.0 ms]: File Decoded
Duration: 9.0 s

### Encoder Run output 
![Alt text](encoder_output.png?raw=true "Encoder Run - Large input 10million lines")

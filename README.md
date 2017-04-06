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


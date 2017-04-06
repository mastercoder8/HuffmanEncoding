JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		TimeManager.java \
		FrequencyTable.java \
		Node.java \
		FourWayHeap.java \
		HuffmanTree4Way.java \
		encoder.java \
		decoder.java \
		PerformanceCompare.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class

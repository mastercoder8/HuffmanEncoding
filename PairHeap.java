import java.util.*;

/* Class PairHeap */
class PairHeap
{	 
    private PairNode root; 
    int size;
	
    /* Constructor */
    public PairHeap( )
    {
        root = null;
        size = 0;
    }
    /* Check if heap is empty */
    public boolean isEmpty() 
    {
        return root == null;
    }
    
    public int size(){
    	return size;
    }
    /* Function to insert data */
    public PairNode add(PairNode newNode)
    {
    	size++;
        if (root == null)
            root = newNode;
        else
            root = compareAndLink(root, newNode);
        return newNode;
    }
    
   
    /* Function compareAndLink */
    private PairNode compareAndLink(PairNode first, PairNode second)
    {
        if (second == null)
            return first;
 
        if (second.frequency < first.frequency)
        {
            second.prev = first.prev;
            first.prev = second;
            first.nextSibling = second.leftChild;
            if (first.nextSibling != null)
                first.nextSibling.prev = first;
            second.leftChild = first;
            return second;
        }
        else
        {
            second.prev = first;
            first.nextSibling = second.nextSibling;
            if (first.nextSibling != null)
                first.nextSibling.prev = first;
            second.nextSibling = first.leftChild;
            if (second.nextSibling != null)
                second.nextSibling.prev = second;
            first.leftChild = second;
            return first;
        }
    }
    
    private PairNode combineSiblings(PairNode firstSibling)
    {
        List<PairNode>  treeArray = new ArrayList<>();
        if( firstSibling.nextSibling == null )
            return firstSibling;
        int numSiblings = 0;
        for ( ; firstSibling != null; numSiblings++)
        {
            treeArray.add(numSiblings, firstSibling);
            firstSibling.prev.nextSibling = null;  
            firstSibling = firstSibling.nextSibling;
        }

        treeArray.add(numSiblings, null);
        int i = 0;
        for ( ; i + 1 < numSiblings; i += 2)
            treeArray.set(i, compareAndLink(treeArray.get(i), treeArray.get(i+1)));
        int j = i - 2;
        if (j == numSiblings - 3)
            treeArray.set(j, compareAndLink( treeArray.get(j), treeArray.get(j+2)));
        for ( ; j >= 2; j -= 2)
            treeArray.set(j-2, compareAndLink(treeArray.get(j-2), treeArray.get(j)));
        return treeArray.get(0);
    }

    /* Delete min frequency */
    public PairNode remove( )
    {
        if (isEmpty( ) )
            return null;
        size--;
        PairNode min = root;
        if (root.leftChild == null)
            root = null;
        else{
            root = combineSiblings( root.leftChild );
        }
        return min;
    }  
}

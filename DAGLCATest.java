import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DAGLCATest {

    DAGLCA directAcyclic = new DAGLCA(9);

    @Test
    public void TestDAGLCA(){
        
    }
    @Test
    public void testaddEdge(){
        directAcyclicGraph();
        assertEquals("Expected 9 edges", 9, directAcyclic.Edges());
        directAcyclic.addEdge(6, 8);
        assertEquals("Expected 10 edges", 10, directAcyclic.Edges());
    }

   @Test
   public void testFindLCA(){
    directAcyclicGraph();
    //showing different levels within the graph
    assertEquals("", 7, directAcyclic.findLCA(3, 4));
    assertEquals("", 7, directAcyclic.findLCA(1, 4));
    assertEquals("", 7, directAcyclic.findLCA(5, 2));
    //swapping around the vertices v and w
    assertEquals("", 5, directAcyclic.findLCA(1, 5));
    assertEquals("", 5, directAcyclic.findLCA(5, 1));
   }


    public void directAcyclicGraph(){
        //                
        //  -> 1 -> 3 -> 5
		//0                -> 7 -> 8          
		//  -> 2 -> 4 -> 6       
		directAcyclic.addEdge(0, 1);
        directAcyclic.addEdge(0, 2);
		directAcyclic.addEdge(1, 3);
		directAcyclic.addEdge(2, 4);
		directAcyclic.addEdge(3, 5);
		directAcyclic.addEdge(4, 6);
		directAcyclic.addEdge(5, 7);
		directAcyclic.addEdge(6, 7);
		directAcyclic.addEdge(7, 8);
	}
}

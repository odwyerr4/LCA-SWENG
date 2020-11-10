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


    public void directAcyclicGraph(){
		//  -> 1 -> 3 -> 5 ->
		//0    ^              7 -> 8             
		//  -> 2 -> 4 -> 6 ->      
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

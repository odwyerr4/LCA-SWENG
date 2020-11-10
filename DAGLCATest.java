import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BinaryTreeLCATest {
    @Test
    public void TestLCA(){
        BinaryTreeLCA test = new BinaryTreeLCA();
        test.root = BinaryTreeLCA.createBinaryTree();
        BinaryTreeLCA.Node Node20=new BinaryTreeLCA.Node(20);
		BinaryTreeLCA.Node Node10=new BinaryTreeLCA.Node(10);
		BinaryTreeLCA.Node Node30=new BinaryTreeLCA.Node(30);
		BinaryTreeLCA.Node Node60=new BinaryTreeLCA.Node(60);
		BinaryTreeLCA.Node Node50=new BinaryTreeLCA.Node(50);
		BinaryTreeLCA.Node Node70=new BinaryTreeLCA.Node(70);
		BinaryTreeLCA.Node Node5=new BinaryTreeLCA.Node(5);
		BinaryTreeLCA.Node Node45=new BinaryTreeLCA.Node(45);
        BinaryTreeLCA.Node Node55=new BinaryTreeLCA.Node(55);
        
        assertEquals("Expecting 20", 20, test.lowestCommonAncestor(test.root, Node5, Node30).data);
        assertEquals("Expecting 60", 60, test.lowestCommonAncestor(test.root, Node50, Node70).data);
        assertEquals("Expecting 50", 50, test.lowestCommonAncestor(test.root, Node55, Node45).data);
        assertEquals("Expecting 40", 40, test.lowestCommonAncestor(test.root, Node20, test.root).data);
        assertEquals("Expecting 40", -1, test.lowestCommonAncestor(test.root, null, test.root).data);
    

    }
}

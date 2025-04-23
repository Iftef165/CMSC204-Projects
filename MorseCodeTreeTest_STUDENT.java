import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {

	MorseCodeTree test1;
	@BeforeEach
	void setUp() throws Exception {
		test1 = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
	}
	

	@Test
	void testAddNode()
	{
		test1.addNode("", "l");
		
		//this should be at the root of the tree
		assertTrue(test1.getRoot().getData().equals("l"));
		
		test1.addNode("-", "a");
		
		//should be the right child of the root 
		assertTrue(test1.getRoot().right.getData().equals("a"));
		
		
		test1.addNode(".-", "n");

		//should be the root's left's right child 
		assertTrue(test1.getRoot().left.right.getData().equals("n"));
	}
	
	void testAddNodePassingRoot() {
		
		test1.addNode(test1.getRoot(), "-.", "b");
		//should be the root's rights's left child 
		assertTrue(test1.getRoot().right.left.getData().equals("b"));
		
		test1.addNode(test1.getRoot(), "-..", "o");

		assertTrue(test1.getRoot().right.left.left.getData().equals("o"));
	}
	@Test
	void testGetRoot() {
		//should not be null after initializing with constructor
		assertNotNull(test1.getRoot());
		
		//data should be null when no nodes have been inserted
		assertNull(test1.getRoot().getData());
	}

	@Test
	void testSetRoot() {
		TreeNode<String> newRoot = new TreeNode<>("p");
		
		test1.setRoot(newRoot);
		
		assertEquals(test1.getRoot().getData(),"p");
		
		TreeNode<String> emptyRoot = new TreeNode<>(null);
		
		//overwrites the previous tree node
		test1.setRoot(emptyRoot);

		assertNull(test1.getRoot().getData());


	}

	@Test
	void testBuildTree() {
		test1.buildTree();
		//level 1 tree
		assertTrue(test1.getRoot().left.getData().equals("e"));
		assertTrue(test1.getRoot().right.getData().equals("t"));
		
		//level 2 tree
		assertTrue(test1.getRoot().left.left.getData().equals("i"));
		assertTrue(test1.getRoot().left.right.getData().equals("a"));
		
		//level 3 tree
		assertTrue(test1.getRoot().left.left.right.getData().equals("u"));
		assertTrue(test1.getRoot().right.left.right.getData().equals("k"));

		
		//level 4 tree
		assertTrue(test1.getRoot().left.right.right.left.getData().equals("p"));
		assertTrue(test1.getRoot().right.left.right.right.getData().equals("y"));

	}

	@Test
	void testFetchLetter() {
		test1.buildTree();
		
		//from level 1
		assertEquals(test1.fetchLetter(test1.getRoot(), "-"),"t");
		
		//level 2
		assertEquals(test1.fetchLetter(test1.getRoot(), "-."),"n");
		
		//level 3
		assertEquals(test1.fetchLetter(test1.getRoot(), ".--"),"w");
		
		//level 4
		assertEquals(test1.fetchLetter(test1.getRoot(), "-.-."),"c");

	}

	@Test
	void testTraverseInOrder() {
		test1.buildTree();
		
		ArrayList<String> letterList = new ArrayList<>();
		
		test1.traverseInOrder(test1.getRoot(), letterList);
		
		assertEquals(letterList.get(0),"h");
		assertEquals(letterList.get(1),"s");
		assertEquals(letterList.get(2),"v");
		assertEquals(letterList.get(3),"i");
		assertEquals(letterList.get(4),"f");
		assertEquals(letterList.get(5),"u");
		assertEquals(letterList.get(6),"e");
		assertEquals(letterList.get(7),"l");
		assertEquals(letterList.get(8),"r");
		assertEquals(letterList.get(9),"a");
		assertEquals(letterList.get(10),"p");
		assertEquals(letterList.get(11),"w");
		assertEquals(letterList.get(12),"j");
		assertEquals(letterList.get(13),null);
		assertEquals(letterList.get(14),"b");
		assertEquals(letterList.get(15),"d");
		assertEquals(letterList.get(16),"x");

	}
	
	@Test
	void testToArrayList()
	{
		test1.buildTree();
		ArrayList<String> letterList = test1.toArrayList();
		
		
		assertEquals(letterList.get(0),"h");
		assertEquals(letterList.get(1),"s");
		assertEquals(letterList.get(2),"v");
		assertEquals(letterList.get(3),"i");
		assertEquals(letterList.get(4),"f");
		assertEquals(letterList.get(5),"u");
		assertEquals(letterList.get(6),"e");
		assertEquals(letterList.get(7),"l");
		assertEquals(letterList.get(8),"r");
		assertEquals(letterList.get(9),"a");
		assertEquals(letterList.get(10),"p");
		assertEquals(letterList.get(11),"w");
		assertEquals(letterList.get(12),"j");
		assertEquals(letterList.get(13),null);
		assertEquals(letterList.get(14),"b");
		assertEquals(letterList.get(15),"d");
		assertEquals(letterList.get(16),"x");
	}

	@Test
	void testPrintTree() {
		test1.buildTree();
		String letterFormat = test1.printTree();
		
		String comparison = "[h, s, v, i, f, u, e, l, r, a, p, w, j, null, b, d, x, n, c, k, y, t, z, g, q, m, o]";
		
		assertEquals(letterFormat,comparison);

	}

}

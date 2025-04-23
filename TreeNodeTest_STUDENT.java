import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest_STUDENT {
	TreeNode<String> test1;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new TreeNode<>("i");
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
	}

	@Test // Test case for TreeNode(T dataNode) constructor
	void testTreeNodePassingData() {
		assertEquals(test1.getData(),"i");
	}

	@Test // Test case for TreeNode(TreeNode<T> node) constructor
	void testCopyTreeNode() {
		TreeNode<String> copyNode = new TreeNode<>(test1);
		
		assertEquals(copyNode.getData(),"i");
		
	}

	@Test
	void testGetData() {
		
		assertEquals(test1.getData(),"i");
		
		TreeNode<String> anotherNode = new TreeNode<>("j");

		assertEquals(anotherNode.getData(),"j");
	}

}

import java.util.ArrayList;

public class MorseCodeTree implements ConverterTreeInterface<String> {

	private TreeNode<String> root;

	public MorseCodeTree() {
		root = new TreeNode<>(null);
	}

	public void addNode(String code, String letter) {
		addNode(root, code, letter);
	}

	public void addNode(TreeNode<String> root, String code, String letter) {
		// when the code has been finished analyzing
		if (code.isEmpty() == true)

		{
			// set the letter to the current node
			root.setData(letter);
		}

		// checks the first character of the code and recursively calls the method with
		// the remaining code
		else if (code.charAt(0) == '.') {
			String remainingCode = code.substring(1);

			if (root.left == null) {
				root.left = new TreeNode<>(null);
			}

			addNode(root.left, remainingCode, letter);
		}

		else if (code.charAt(0) == '-') {
			String remainingCode = code.substring(1);

			if (root.right == null) {
				root.right = new TreeNode<>(null);
			}

			addNode(root.right, remainingCode, letter);
		}

	}

	public void buildTree() {
		// represents level 1
		addNode(".", "e");
		addNode("-", "t");

		// represents level 2
		addNode("..", "i");
		addNode(".-", "a");
		addNode("-.", "n");
		addNode("--", "m");

		// represents level 3
		addNode("...", "s");
		addNode("..-", "u");
		addNode(".-.", "r");
		addNode(".--", "w");
		addNode("-..", "d");
		addNode("-.-", "k");
		addNode("--.", "g");
		addNode("---", "o");

		// represents level 4
		addNode("....", "h");
		addNode("...-", "v");
		addNode("..-.", "f");
		addNode(".-..", "l");
		addNode(".--.", "p");
		addNode(".---", "j");
		addNode("-...", "b");
		addNode("-..-", "x");
		addNode("-.-.", "c");
		addNode("-.--", "y");
		addNode("--..", "z");
		addNode("--.-", "q");
	}

	public TreeNode<String> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	public String fetchLetter(TreeNode<String> root, String code) {
		// returns the data when the whole code has been analyzed
		if (code.isEmpty() == true) {
			//base case 
			return root.getData();
		}

		if (code.charAt(0) == '.') {
			String remainingCode = code.substring(1);

			return fetchLetter(root.left, remainingCode);
		}

		else if (code.charAt(0) == '-') {
			String remainingCode = code.substring(1);

			return fetchLetter(root.right, remainingCode);
		}
		
		return null;
		
	}
	
	public void traverseInOrder(TreeNode<String> root, ArrayList<String> list)
	{
		//if the node is not missing, then the current node is not a leaf
		if(root.left !=null)
		{
			//this occurs when we traversed all the left nodes 
			traverseInOrder(root.left,list);
		}
		
		//visits the data 
		list.add(root.getData());
		
		//now checks the right side of the node
		if(root.right !=null)
		{
			//process the leaf of all the right side of the node's
			traverseInOrder(root.right,list);
		}
		
	}
	
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> letterList = new ArrayList<>();
		
		traverseInOrder(root,letterList);
		
		
		return letterList;
	}
	
	public String printTree()
	{
		ArrayList<String> listLetters = toArrayList();
		
		//returns a string representation of the list with commas in between
		return listLetters.toString();
	}

}

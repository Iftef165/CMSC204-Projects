
public class TreeNode<T> {
	private T dataNode;
	TreeNode<T> left;
	TreeNode<T>right;
	
	public TreeNode(T dataNode)
	{
		this.dataNode = dataNode;
		left = null;
		right = null;
	}
	
	public TreeNode(TreeNode<T> node)
	{
		//when null get's passed, manually set the data to null to avoid an exception
		if(node == null)
		{
			dataNode = null;
			left = null;
			right = null;
		}
		else
		{
			this.dataNode = node.dataNode;
			this.left = node.left;
			this.right = node.right;
		}
		
	}
	
	public T getData()
	{
		return dataNode;
	}
	
	public void setData(T dataNode)
	{
		this.dataNode = dataNode;
	}
}

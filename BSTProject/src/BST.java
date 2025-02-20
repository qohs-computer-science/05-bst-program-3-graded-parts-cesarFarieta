import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    private TreeNode subroot;


    public BST(){
        root=null;
    }

	public void add(Comparable newVal){
        if(root=null){
            root= new TreeNode();
        }
        else if(newVal<=root.getValue())
	        addHelper(newVal,root.getLeft(),root)
        else 
	        addHelper(newVal,root.getRight(),root)
    }

    private void addHelper(Comparable newVal,TreeNode child,TreeNode parent)
    {
        if(child==null){
		    if(val.comparTo(parent.getValue())<=0 )
			    parent.setLeft(new TreeNode);
		    else 
			    parent.setRight(new TreeNode);
        }
        
        else if  (child vs value)
		    addHelper(left)
	    else 
		    addHelper(right)
    }


}
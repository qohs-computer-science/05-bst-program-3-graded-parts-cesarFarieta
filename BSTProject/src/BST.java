import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    private int counter;

    public BST(){
        root=null;
    }

	public void add(Comparable newVal){
        if(root==null){
            root= new TreeNode(newVal, null,null);
            counter++;
        }
        else if(newVal.compareTo(root.getValue())<=0){
	        addHelper(newVal,root.getLeft(),root);
        }else{ 
	        addHelper(newVal,root.getRight(),root);
        }
    }

    private void addHelper(Comparable newVal,TreeNode child,TreeNode parent)
    {
        if(child==null){
		    if(newVal.compareTo(parent.getValue())<=0 ){
			    parent.setLeft(new TreeNode(newVal,null,null));
                counter++;
            }else {
			    parent.setRight(new TreeNode(newVal,null,null));
                counter++;
            }
        }else{
            if(newVal.compareTo(child.getValue())<=0){
                addHelper(newVal,child.getLeft(),child);
            }else{ 
                addHelper(newVal,child.getRight(),child);
            }    
        }
        
    }


    public int size(){
        return counter;
    }

	public boolean isEmpty(){
        if(root!=null)
            return false;
        else
            return true;
    }   


	public boolean find(Comparable toFind){

        if(root== null)
            return false;
        else{ 
            if(toFind.compareTo(root.getValue())==0)
                return true ;
            else if (toFind.compareTo(root.getValue())<=0)
                return findHelper(toFind,root.getLeft());
            else
                return findHelper(toFind,root.getRight());
        }

    }


    private boolean findHelper(Comparable newVal,TreeNode child)
    {
        if(child == null)
		    return false;
	    else 
            if(newVal.compareTo(child.getValue())==0)
                return true; 
            else if (newVal.compareTo(child.getValue())<=0)
                return findHelper(newVal,child.getLeft());
            else
                return findHelper(newVal,child.getRight());
    }


	public boolean replace(Comparable old, Comparable toAdd){
        //if(root.find(old)== true){

       // }
        //else{
            return false;
        //}
    }

	public boolean delete(Comparable old){
        return true;
    }

	public void printInOrder(){
        if(root!= null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue());
            inOrderHelper(root.getRight());
        }
    }

    public void inOrderHelper(TreeNode child){
        if(child!= null){
            inOrderHelper(child.getLeft());
            System.out.print(" " + child.getValue());
            inOrderHelper(child.getRight());
        }
    }
	public void printPreOrder(){
        if(root!=null){
            System.out.print(root.getValue());
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
        }
    }

	public void preOrderHelper(TreeNode child){
        if(child!=null){
            System.out.print(" " + child.getValue());
            preOrderHelper(child.getLeft());
            preOrderHelper(child.getRight());
        }
    }


	public void printPostOrder(){
        if(root!=null){
            postOrderHelper(root.getLeft()) ;   
            postOrderHelper(root.getRight());   
            System.out.print(root.getValue()); 
        }
    }

	public void postOrderHelper(TreeNode child){
        if(child!=null){
            postOrderHelper(child.getLeft()) ;   
            postOrderHelper(child.getRight()) ;  
            System.out.print(" "+child.getValue()); 
        }
    }




    


}
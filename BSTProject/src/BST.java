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
        if(root==null){
            return false;
        }
        else{
            if(old.compareTo(root.getValue())==0){
                deleteRoot();
                return true;
            }
            else{
                if(old.compareTo(root.getValue())<=0){
                    if(root.getLeft()==null){
                        return false;
                    }
                    else{
                        if(old.compareTo(root.getLeft().getValue())==0){
                            deleteSide(root,root.getLeft(), true);
                            return true;
                        }else{
                            return deleteHelper(old, root.getLeft());

                        }      
                    }
                }
                else{
                    if(root.getRight()==null){
                        return false;
                    }
                    else{
                        if(old.compareTo(root.getRight().getValue())==0){
                            deleteSide(root,root.getRight(),false);
                            return false;
                        }
                        else{
                            return deleteHelper(old,root.getRight());
                        }
                    }
                }
            }

        }
    }





	private boolean deleteHelper (Comparable val, TreeNode child){
        if(val.compareTo(child.getValue())<=0){
            if(child.getLeft()==null){
                return false;
            }
            else {
                if(val.compareTo(child.getLeft().getValue())==0){
                    deleteSide(child, child, isEmpty());(child,child.getLeft(),true);
                    return true;
                }
                else{
                    return deeteHelper(val,child.getLeft);
                }
            }
        }
        else{
            if(child.getRight()==null){
                return false;
            }
            else{
                if(val.compareTo(child.getRight().getValue())==0){
                    deleteSide(child , child.getright(), false);
                    return true;
                }
                else{
                    return deleteHelper(val,child.getRight());
                }
            }

        }
    }











	private void deleteSide(TreeNode parent, TreeNode child, boolean isLeft){
        if(child.getLeft()==null){
            if(child.getRight()==null){
                if(isLeft==true){
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            else{
                if(isLeft==true){
                    parent.setLeft(child.getRight());
                    chuild.setRight(null);
                }
                else{
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }
            }        
        }
        else{
            if(child.getRight()==null){
                if(isLeft==true){
                    parent.setLeft(child.getRight());
                    child.setLeft(null);
                }
                else{
                    parent.setRight(child.getRight());
                    child.setLeft(null);
                }
            }
            else{
                TreeNode temp = child.getleft();
                while(temp.getRight()!=null){
                    remp=temp.getRight();
                }
                temp.setRight(child.getRight());
                if(isLeft){
                    parent.setLeft(child.getLeft());
                }
                else{
                    parent.setRight(child.getLeft());
                }
                child.setLeft(null);
                child.setRight(null);


            }
        }
    }

	private void deleteRoot(){
        if(root.getLeft() == null){
            if(root.getRight() == null){
                root= null;
            }
            else{
                root= root.getRight();
            }
        }
        else{
            if(root.getRight() ==null)
                root=root.getLeft();
            else{
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){
                    temp=temp.getRight();
                }
                temp.setRight(root.getRight());
                root= root.getLeft();
            }
        }
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
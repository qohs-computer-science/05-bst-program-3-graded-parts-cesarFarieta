// Cesar Farieta 
// pd 3
//3/4/2025
//this program creates a binary search tree and tests different methods. The methods it tests out are add, delete,find,replace, and get size.
//add, adds an object to the tree to its coreect and sorted location. Delete deletes the object from the tree and shifts eveything, if needed to its 
//correct location. Find looks for an object in the tree and it returns if it is found or not. Replace takes an object and finds it then replaces it 
//with the new object, if its not found then it jusst adds it to the search tree. Finally size just returns the size of the biarny search tree.
import java.lang.Comparable;

public class BST implements BSTInterface
{// start class
    private TreeNode root;
    private int counter;

    public BST(){// start  BST
        root=null;
    }// end BST

	public void add(Comparable newVal){// start add
        if(root==null){// start if
            root= new TreeNode(newVal, null,null);
            counter++;
        }// end if 
        else if(newVal.compareTo(root.getValue())<=0){// start else if
	        addHelper(newVal,root.getLeft(),root);
        }// end if else
        else{ // start else
	        addHelper(newVal,root.getRight(),root);
        }// end else
    }// end add

    private void addHelper(Comparable newVal,TreeNode child,TreeNode parent)
    {// start addHelper
        if(child==null){// start  if
		    if(newVal.compareTo(parent.getValue())<=0 ){// start  if
			    parent.setLeft(new TreeNode(newVal,null,null));
                counter++;
            }// end if
            else {// start else
			    parent.setRight(new TreeNode(newVal,null,null));
                counter++;
            }// end else
        }// end if 
        else{// start else
            if(newVal.compareTo(child.getValue())<=0){// start  if
                addHelper(newVal,child.getLeft(),child);
            }// end if
            else{ // start  else
                addHelper(newVal,child.getRight(),child);
            }// end else    
        }// end else  
        
    }// end addHelper  


    public int size(){// start size
        return counter;
    }// end size

	public boolean isEmpty(){// start empty
        if(root!=null)
            return false;
        else
            return true;
    }  // end empty


	public boolean find(Comparable toFind){// start find

        if(root== null)
            return false;
        else{ // start else
            if(toFind.compareTo(root.getValue())==0)
                return true ;
            else if (toFind.compareTo(root.getValue())<=0)
                return findHelper(toFind,root.getLeft());
            else
                return findHelper(toFind,root.getRight());
        }// end else

    }// end find


    private boolean findHelper(Comparable newVal,TreeNode child)
    {// start finderHelper
        if(child == null)
		    return false;
	    else 
            if(newVal.compareTo(child.getValue())==0)
                return true; 
            else if (newVal.compareTo(child.getValue())<=0)
                return findHelper(newVal,child.getLeft());
            else
                return findHelper(newVal,child.getRight());
    }// end findHelper


	public boolean replace(Comparable old, Comparable toAdd){// start replace
        if(find(old)== true){// start if 
            delete(old);
            add(toAdd);
            return true;
        }// end if 
        else{// start else
            add(toAdd);
            return false;
        }// end else
    }// end replace





	public boolean delete(Comparable old){//  start delete
        if(root==null){// start if
            return false;
        }// end if
        else{
            if(old.compareTo(root.getValue())==0){// start if
                deleteRoot();
                return true;
            }// end if
            else{// start else
                if(old.compareTo(root.getValue())<=0){// start if
                    if(root.getLeft()==null){// start if
                        return false;
                    }// end if
                    else{// start else
                        if(old.compareTo(root.getLeft().getValue())==0){// start if
                            deleteSide(root,root.getLeft(), true);
                            return true;
                        }// end if
                        else{// start else
                            return deleteHelper(old, root.getLeft());

                        }//end else      
                    }// end else
                }// end if
                else{// start else
                    if(root.getRight()==null){// start if
                        return false;
                    }// end if
                    else{// start else
                        if(old.compareTo(root.getRight().getValue())==0){// start if
                            deleteSide(root,root.getRight(),false);
                            return false;
                        }// end if
                        else{// start else
                            return deleteHelper(old,root.getRight());
                        }// end else
                    }// end else
                }// end else
            }// end else

        }// end else
    }// end delete





	private boolean deleteHelper (Comparable val, TreeNode child){// start deleteHelper
        if(val.compareTo(child.getValue())<=0){// start if
            if(child.getLeft()==null){// start if
                return false;
            }// end if
            else {// start else
                if(val.compareTo(child.getLeft().getValue())==0){// start if
                    deleteSide(child,child.getLeft(),true);
                    return true;
                }// end if
                else{// start else
                    return deleteHelper(val,child.getLeft());
                }// end else
            }// end else
        }// end if 
        else{// start else
            if(child.getRight()==null){// start if
                return false;
            }// end if
            else{// start else
                if(val.compareTo(child.getRight().getValue())==0){// start if
                    deleteSide(child , child.getRight(), false);
                    return true;
                }// end if
                else{// start else
                    return deleteHelper(val,child.getRight());
                }// end  else
            }// end  else

        }// end  else
    }// end  deleteHelper











	private void deleteSide(TreeNode parent, TreeNode child, boolean isLeft){// start deleteSide
        if(child.getLeft()==null){// start if
            if(child.getRight()==null){// start if
                if(isLeft==true){// start if
                    parent.setLeft(null);
                }// end if
                else{// start else
                    parent.setRight(null);
                }// end  else
            }// end  if
            else{// start else
                if(isLeft==true){// start if
                    parent.setLeft(child.getRight());
                    child.setRight(null);
                }// end if
                else{// start else
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }// end  else
            }// end else     
        }// end if
        else{// start else
            if(child.getRight()==null){// start if
                if(isLeft==true){// start if
                    parent.setLeft(child.getRight());
                    child.setLeft(null);
                }// end if
                else{// start else
                    parent.setRight(child.getRight());
                    child.setLeft(null);
                }// end  else
            }// end if
            else{// start else
                TreeNode temp = child.getLeft();
                while(temp.getRight()!=null){// start while
                    temp=temp.getRight();
                }// end while
                temp.setRight(child.getRight());
                if(isLeft){// start if
                    parent.setLeft(child.getLeft());
                }// end if
                else{// start else
                    parent.setRight(child.getLeft());
                }// end  else
                child.setLeft(null);
                child.setRight(null);


            }// end  else
        }// end  else
    }// end deleteSide






	private void deleteRoot(){// start deleteRoot
        if(root.getLeft() == null){// start if
            if(root.getRight() == null){// start if
                root= null;
            }// end if
            else{// start else
                root= root.getRight();
            }// end else
        }// end if
        else{// start else
            if(root.getRight() ==null){// start if
                root=root.getLeft();
            }// end if
            else{// start else
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){// start while
                    temp=temp.getRight();
                }// end while
                temp.setRight(root.getRight());
                root= root.getLeft();
            }// end else
        }// end else
    }// end deleteRoot

	public void printInOrder(){// start printInOrder
        if(root!= null){// start if
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue());
            inOrderHelper(root.getRight());
        }//end if
    }// end printInOrder

    public void inOrderHelper(TreeNode child){// start inOrderHelper
        if(child!= null){// start if
            inOrderHelper(child.getLeft());
            System.out.print(" " + child.getValue());
            inOrderHelper(child.getRight());
        }//end if
    }// end inOrderHelper
	public void printPreOrder(){// start printPreOrder
        if(root!=null){// start if
            System.out.print(root.getValue());
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
        }//end if
    }// end printPreOrder

	public void preOrderHelper(TreeNode child){// start preOrderHelper
        if(child!=null){// start if
            System.out.print(" " + child.getValue());
            preOrderHelper(child.getLeft());
            preOrderHelper(child.getRight());
        }//end if
    }// end preOrderHelper


	public void printPostOrder(){//  start printPostOrder
        if(root!=null){// start if
            postOrderHelper(root.getLeft()) ;   
            postOrderHelper(root.getRight());   
            System.out.print(root.getValue()); 
        }// end if
    }//  end printPostOrder

	public void postOrderHelper(TreeNode child){// start postOrderHelper
        if(child!=null){// start if
            postOrderHelper(child.getLeft()) ;   
            postOrderHelper(child.getRight()) ;  
            System.out.print(" "+child.getValue()); 
        }//end if 
    }//  end postOrderHelper

}// end class
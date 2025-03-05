// Cesar Farieta 
// pd 3
//3/4/2025
//this program creates a binary search tree and tests different methods. The methods it tests out are add, delete,find,replace, and get size.
//add, adds an object to the tree to its coreect and sorted location. Delete deletes the object from the tree and shifts eveything, if needed to its 
//correct location. Find looks for an object in the tree and it returns if it is found or not. Replace takes an object and finds it then replaces it 
//with the new object, if its not found then it jusst adds it to the search tree. Finally size just returns the size of the biarny search tree.
import java.lang.Comparable;

public class BSTTester {
  public static void main(String[] args) {
    BST searchArbol = new BST();
    searchArbol.add("O");
    searchArbol.add("R");
    searchArbol.add("C");
    searchArbol.add("H");
    searchArbol.add("A");
    searchArbol.add("R");
    searchArbol.add("D");
    searchArbol.add("Q");
    searchArbol.add("U");
    searchArbol.add("I");
    searchArbol.add("N");
    searchArbol.add("C");
    searchArbol.add("E");

    System.out.println("In Order: ");
    searchArbol.printInOrder();
    System.out.println("");
    System.out.println();

    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");
    System.out.println();

    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");
    System.out.println();


    System.out.println("Is it found: ");
    System.out.println(searchArbol.find("A"));
    System.out.println();

    System.out.println("Is it found: ");
    System.out.println(searchArbol.find("B"));
    System.out.println();

    System.out.println("Is it Empty?: ");
    System.out.println(searchArbol.isEmpty());
    System.out.println();

    System.out.println("The Size is:  ");
    System.out.println(searchArbol.size());
    System.out.println();


    System.out.println("Delete O: " + searchArbol.delete("O"));
    System.out.println("In Order: ");
    searchArbol.printInOrder();
    System.out.println("");
    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");
    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");
    System.out.println();

    System.out.println("Delete R: " + searchArbol.delete("R"));
    System.out.println("In Order: ");
    searchArbol.printInOrder();
    System.out.println("");
    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");
    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");
    System.out.println();

    System.out.println("Delete A: " + searchArbol.delete("A"));
    System.out.println("In Order: ");
    searchArbol.printInOrder();
    System.out.println("");
    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");
    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");

    System.out.println();

    System.out.println("Replace E with A: " + searchArbol.replace("E","A"));
    System.out.println("In Order: ");
    searchArbol.printInOrder();
    System.out.println("");
    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");
    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");
  }
}
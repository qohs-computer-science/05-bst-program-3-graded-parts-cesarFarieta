/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

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

    System.out.println("Pre Order: ");
    searchArbol.printPreOrder();
    System.out.println("");

    System.out.println("Post Order: ");
    searchArbol.printPostOrder();
    System.out.println("");


    System.out.println("Is it found: ");
    System.out.println(searchArbol.find("A"));

    System.out.println("Is it found: ");
    System.out.println(searchArbol.find("B"));

    System.out.println("Is it Empty?: ");
    System.out.println(searchArbol.isEmpty());

    System.out.println("The Size is:  ");
    System.out.println(searchArbol.size());


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



  }
}
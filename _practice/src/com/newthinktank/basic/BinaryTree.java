package com.newthinktank.basic;
/**
 * Written by myself.
 * @author Administrator
 *
 */
public class BinaryTree {

	Node root;

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean removeNode(int key) {
		Node focusNode = root;
		Node parent = root;
		boolean isLeft = true;
		while (key != focusNode.key) {			
			parent = focusNode;
			if (key < focusNode.key) {				
				focusNode = focusNode.leftChild;
				isLeft = true;
				if (focusNode == null) {
					return false;
				}
			} else if (key > focusNode.key) {
				focusNode = focusNode.rightChild;
				isLeft = false;
				if (focusNode == null) {
					return false;
				}
			}			
		}
		
		if (focusNode.leftChild == null || focusNode.rightChild == null) {
			if (focusNode.leftChild != null) {
				if (focusNode == root) {
					root = focusNode.leftChild;
				} else {
					if (isLeft)
						parent.leftChild = focusNode.leftChild;
					else
						parent.rightChild = focusNode.leftChild;
				}
			} else if (focusNode.rightChild != null) {
				if (focusNode == root) {
					root = focusNode.rightChild;
				} else {
					if (isLeft)
						parent.leftChild = focusNode.rightChild;
					else
						parent.rightChild = focusNode.rightChild;
				}

			} else {
				if (focusNode == root) {
					root = null;
				} else if (isLeft)
					parent.leftChild = null;
				else
					parent.rightChild = null;
			}
		} else {
			//the left and right child of the place where the node will be placed
			Node theRightChild = focusNode.rightChild;
			Node theLeftChild = focusNode.leftChild;
			//the parent node of the replacement node
			Node theParent = focusNode;
			
			//find the replacement node and its parent, cut the relation between them.

			focusNode = focusNode.rightChild;
			while(focusNode.leftChild!=null){
				theParent = focusNode;
				focusNode = focusNode.leftChild;
			}
			if(focusNode.rightChild!=null){
				theParent = focusNode;
				focusNode = focusNode.rightChild;
			}else{
				theParent.leftChild = null;
			}
				
			//place the replacement node to the place			
			if (isLeft)
				parent.leftChild = focusNode;
			else
				parent.rightChild = focusNode;
			// assign those children to it.
			if(focusNode != theRightChild)
				focusNode.rightChild = theRightChild;
			focusNode.leftChild = theLeftChild;
			
		}
		return true;
	}

	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
	}

	public void postorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postorderTraverseTree(focusNode.leftChild);
			postorderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return null;
			}
		}
		return focusNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bTree = new BinaryTree();
		bTree.addNode(10, "Root");
		bTree.addNode(11, "11");
		bTree.addNode(5, "5");
		bTree.addNode(3, "3");
		bTree.addNode(7, "7");
		bTree.addNode(2, "2");
		bTree.addNode(4, "4");
		bTree.addNode(6, "6");
		bTree.addNode(8, "8");
		/*
		 * *********root10 
		 * *******5*********11 
		 * ***3******7    
		 * 2****4**6***8
		 */
		bTree.preorderTraverseTree(bTree.root);
//		bTree.removeNode(5);
		bTree.inOrderTraverseTree(bTree.root);
		bTree.postorderTraverseTree(bTree.root);
//		System.out.println("find key 1: " + bTree.findNode(1));
	}

}

class Node {
	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return key + " has value " + name;
	}
}
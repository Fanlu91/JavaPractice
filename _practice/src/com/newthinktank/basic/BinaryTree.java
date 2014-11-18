package com.newthinktank.basic;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		if(root == null){
			root = newNode;
		}else{
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(key<focusNode.key){
					focusNode = focusNode.leftChild;
					
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key,String name){
		this.key=key;
		this.name=name;
	}
}
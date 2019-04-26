package com.fanlu.geektime;

import org.testng.reporters.XMLConstants;

public class LinkedList {
    public Node headNode;

    public LinkedList() {
        headNode = null;
    }

    public LinkedList(Node headNode) {
        this.headNode = headNode;
    }

    public boolean isEmpty() {
        return null == this.headNode;
    }

    public void addNodeToHead(Node node) {
        node.next = headNode;
        headNode = node;
    }

    public boolean addNodeAfterNodeByName(String name, Node node) {
        if (this.headNode == null)
            return false;
        Node tmp = this.headNode;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                node.next = tmp.next;
                tmp.next = node;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public boolean removeNodeByName(String name) {
        if (this.headNode == null)
            return false;
        if (this.headNode.name.equals(name)) {
            this.removeHeadNode();
            //don't forget to return true.
            return true;
        }

        Node tmp = this.headNode;
        Node prev = null;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                prev.next = tmp.next;
                return true;
            }
            prev = tmp;
            tmp = tmp.next;
        }
        return false;
    }

    public boolean removeHeadNode() {
        System.out.println("removeHeadNode called");
        displayList();
        if (this.headNode == null) {
//            System.out.println("empty");
            return false;
        }
        headNode = headNode.next;
//        System.out.println("true");
        return true;
    }

    public LinkedList reverseList() {
        return new LinkedList();
    }

    public boolean containsCycle() {
        return true;
    }


    public void removeNodeByIndex(int index) {

    }

    public void removeNodeByIndexFromLast(int indexFromLast) {

    }

    public Node findTheMiddleNode() {
        return new Node();
    }

    public void displayList() {
        System.out.println("=======================");
        Node tmpNode = headNode;
        while (tmpNode.next != null) {
            System.out.println(tmpNode);
            tmpNode = tmpNode.next;
        }
        System.out.println(tmpNode);
        System.out.println("=======================");

    }

    public static void main(String[] args) {
        System.out.println();
    }

}

class Node {
    public String name;
    public int value;
    public Node next;


    public Node() {

    }

    public Node(String name, int value, Node next) {
        this.name = name;
        this.next = next;
        this.value = value;
    }

    public Node(String name, int value) {
        this.name = name;

        this.value = value;
        this.next = null;
    }

    public String toString() {
        if (null != next)
            return " node name: " + this.name + " , node value: " + this.value + ", next node's name: " + next.name;
        else
            return " node name: " + this.name + " , node value: " + this.value + ", it has no next.";
    }
}
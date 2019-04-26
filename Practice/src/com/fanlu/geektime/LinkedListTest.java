package com.fanlu.geektime;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTest {

    LinkedList listOne, listTwo, listThreeWithOrder, listFourWithOrder, listEmpty;
    Node node11, node12, node13, node14, node15;
    Node node21, node22, node23, node24, node25;
    Node node31, node32, node33, node34, node35;
    Node node41, node42, node43, node44, node45;


    @BeforeMethod
    public void setUp() {
        listEmpty = new LinkedList();
        listOne = new LinkedList();
        listTwo = new LinkedList();
        listThreeWithOrder = new LinkedList();
        listFourWithOrder = new LinkedList();

        node11 = new Node("One", 1);
        node12 = new Node("Two", 2);
        node13 = new Node("Three", 3);
        node14 = new Node("Four", 4);
        node15 = new Node("Five", 5);


        node21 = new Node("One", 1);
        node22 = new Node("Two", 2);
        node23 = new Node("Three", 3);
        node24 = new Node("Four", 4);
        node25 = new Node("Five", 5);

        node31 = new Node("One", 1);
        node32 = new Node("Two", 2);
        node33 = new Node("Three", 3);
        node34 = new Node("Four", 4);
        node35 = new Node("Five", 5);

        node41 = new Node("One", 1);
        node42 = new Node("Two", 2);
        node43 = new Node("Three", 3);
        node44 = new Node("Four", 4);
        node45 = new Node("Five", 5);


        listOne.addNodeToHead(node11);
        listOne.addNodeToHead(node12);
        listOne.addNodeToHead(node13);
        listOne.addNodeToHead(node14);
        listOne.addNodeToHead(node15);

        listTwo.addNodeToHead(node21);
        listTwo.addNodeToHead(node22);
//        listTwo.addNodeToHead(node23);
//        listTwo.addNodeToHead(node24);
        listTwo.addNodeToHead(node25);


        listThreeWithOrder.addNodeToHead(node32);
        listThreeWithOrder.addNodeToHead(node33);
        listThreeWithOrder.addNodeToHead(node34);

        listFourWithOrder.addNodeToHead(node43);
        listFourWithOrder.addNodeToHead(node44);
        listFourWithOrder.addNodeToHead(node45);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(listEmpty.isEmpty());
        assertFalse(listOne.isEmpty());
        listOne.displayList();
        listThreeWithOrder.displayList();
    }

    @Test
    public void testAddNodeAfterNodeByName() {
        listTwo.displayList();
        assertFalse(listTwo.addNodeAfterNodeByName("Zero", node24));
        assertTrue(listTwo.addNodeAfterNodeByName("Five", node24));
        listTwo.addNodeAfterNodeByName("Four", node23);
        listTwo.displayList();
    }

    @Test
    public void testRemoveNodeByName() {
        assertFalse(listEmpty.removeNodeByName("one"));
        assertFalse(listOne.removeNodeByName("Six"));
        listTwo.displayList();
        assertTrue(listTwo.removeNodeByName("One"));
        listTwo.displayList();
        assertTrue(listTwo.removeNodeByName("Five"));
        listTwo.displayList();
    }

    @Test
    public void testRemoveHeadNode() {
        assertFalse(listEmpty.removeHeadNode());
        listOne.displayList();
        assertTrue(listOne.removeHeadNode());
        listOne.displayList();
        assertTrue(listOne.removeHeadNode());
        listOne.displayList();
    }

    @Test
    public void testReverseList() {
    }

    @Test
    public void testContainsCycle() {
    }

    @Test
    public void testRemoveNodeByIndex() {
    }

    @Test
    public void testRemoveNodeByIndexFromLast() {
    }

    @Test
    public void testFindTheMiddleNode() {
    }
}
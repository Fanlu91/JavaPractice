package com.newthinktank.basic.linklist;

public class Link {
    public String bookName;
    public int millionsSold;
    // Reference to next link made in the LinkList
    // Holds the reference to the Link that was created before it
    // Set to null until it is connected to other links
    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");
    }

    public String toString() {
        return bookName;
    }

}
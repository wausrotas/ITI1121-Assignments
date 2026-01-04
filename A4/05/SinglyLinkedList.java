/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */
/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q5
 * Section: ITI1121-A
 */


//TEST

import java.util.Stack;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E value;
        private Node<E> next = null;
        private Node( E value, Node<E> next ) {
            this.value = value;
            this.next  = next;
        }
    }

    // Instance variable
    private Node<E> first;
    private int pos = 0; //To find position in List.
    private SinglyLinkedList<Integer> result = null; //List we will be returning.
    private Stack<Integer> stack = new Stack<Integer>(); //To reverse the order of list.

    //  ----------------------------------------------------------
    //  SinglyLinkedList methods
    //  ----------------------------------------------------------

    public void addFirst( E item ) {
        first = new Node<E>( item, first );
    }

    public boolean isEmpty() { 
        return first == null;
    }

    /**
     * This recursive method will check to see if "Element" is in our list
     * And will record where in the list it appears.
     * @param element
     * @return
     */
    public SinglyLinkedList<Integer> indexOfAll( E element ) {
       
        if(result == null)
        {
        	result = new SinglyLinkedList<Integer>(); //Initializes the List.
        }
	    if(isEmpty()) //Runs only once we have gone through the whole list.
	    {
	    	while(!stack.isEmpty())
	    	{
	    		result.addFirst(stack.pop()); //Adds the positions into the list in reverse order.
	    	}
	    	return result;
	    }
        if(element == null)
        {
            throw new NullPointerException("Element can not be null"); //Throws an error if given invalid Element.
        }
	    else
	    {
	    	
	    	if(first.value == element) //If the element is found in the list:
	    	{
	    		stack.push(pos); //Add it into the stack.
	    		//System.out.println(pos);
	    	}
	    	pos++;    //Increase the pos by one.
	    	first = first.next; //Move to the next element in the list.
	
	    	return indexOfAll(element); //Recall this method.
	    }

	
	    }

    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------

    @Override
    public String toString() {
        return "{" + toString(first) + "}";
    }

    private String toString(Node<E> p) {

        String result = "";

        if (p != null) {
            result = p.value.toString();
            if (p.next != null) {
                result = result + "," + toString(p.next);
            }
        }

        return result;
    }
}

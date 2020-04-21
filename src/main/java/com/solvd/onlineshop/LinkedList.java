package com.solvd.onlineshop;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;



public class LinkedList<T> {
	private static final Logger LOGGER = LogManager.getLogger(LinkedList.class);
	private LinkedListNode<T> first = null;
	
	
	public void add (LinkedListNode<T> node) {
		node.setNext(first);
		first = node;
	}

	
	public void remove(){
		if(first.getNext()!=null)
			first = first.getNext();
		else first = null;
	}
	
	
	private void printList(LinkedListNode<T> node) {
		LOGGER.info ("Node is " + node.getValue());
		if(node.getNext()!=null) printList(node.getNext());
	}

	public void print(){
		printList(first);
	}
	
	
	public static void main(String[] args) {

		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);
		
		LinkedList<String> list = new LinkedList<String>();
		list.add(new LinkedListNode<String>("pants"));
		list.add(new LinkedListNode<String>("shorts"));
		list.add(new LinkedListNode<String>("shoes"));
		list.add(new LinkedListNode<String>("shirts"));
		list.print();
		list.remove();
		LOGGER.info ("After removing head ");
		list.print();
	}

}

class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;

	public LinkedListNode(T value) {
		this.value = value;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}

}

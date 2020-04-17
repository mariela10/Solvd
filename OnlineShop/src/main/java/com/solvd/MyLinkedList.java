package com.solvd;

import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.solvd.onlineshop.Product;
import com.solvd.onlineshop.inventory.Category;
import com.solvd.onlineshop.inventory.Clothing;
import com.solvd.onlineshop.inventory.Drinks;
import com.solvd.onlineshop.inventory.Electronics;
import com.solvd.onlineshop.inventory.Food;
import com.solvd.onlineshop.inventory.Toys;

public class MyLinkedList {
	private static final Logger LOGGER = LogManager.getLogger(MyLinkedList.class);

	public static void main(String[] args) {
		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);
		
		LinkedList<Product> linkedlist = new LinkedList<Product>();
		Clothing clothes = new Clothing("pants", "jeans", 2, Category.WOMEN);
		;
		Drinks drink = new Drinks("Coke", "Cherry", 1);
		Food food = new Food("Potatoe", "Idaho", 2);
		Toys toy = new Toys("Car", "Porsche", 3);
		Electronics elec = new Electronics("radio", "Pioneer", 20);
		
		linkedlist.add(clothes);
		linkedlist.add(drink);
		linkedlist.add(food);
		linkedlist.add(toy);
		linkedlist.add(elec);

		
		LOGGER.info("Linked List Content: " + linkedlist);

		// Move first value to last position
		Product firstVal = linkedlist.get(0);
		Product lastVal = linkedlist.getLast();
		LOGGER.info("First element: " + firstVal);
		int lastInd = linkedlist.size() - 1;

		LOGGER.info("Element at last postion is: " + linkedlist.get(lastInd));

		linkedlist.set(lastInd, firstVal);
		linkedlist.set(0, lastVal);

		LOGGER.info("list after switching first and last " + linkedlist);

		printMiddle(linkedlist);

	}
	public void listItterator(LinkedList ls) {
		for (int i = 0; i < ls.size(); i++) {
			LOGGER.info(ls.get(i));
		}
	}
	

	public static void printMiddle(LinkedList<Product> linkedlist) {
		int size = linkedlist.size();
		LOGGER.info("The middle element is " + linkedlist.get(size / 2));

	}

}

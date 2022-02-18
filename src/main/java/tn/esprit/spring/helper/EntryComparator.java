package tn.esprit.spring.helper;

import java.util.Comparator;
import java.util.Map.Entry;

import tn.esprit.spring.entity.Product;

public class EntryComparator implements Comparator<Entry<Product, Integer>> {

	/**
	 * Implements descending order.
	 */
	@Override
	public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
		if (o1.getValue() < o2.getValue()) {
			return 1;
		} else if (o1.getValue() > o2.getValue()) {
			return -1;
		}
		return 0;
	}

}
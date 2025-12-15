package br.anderson.infnet.appDr1At.exercicio05;

public class LinearSearch implements SearchAlgorithm {

	/**
	 * Generic Linear search method
	 *
	 * @param array List to be searched
	 * @param value Key being searched for
	 * @return Location of the key
	 */
	@Override
	public <T extends Comparable<T>> int find(T[] array, T value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(value) == 0) {
				return i;
			}
		}
		return -1;
	}
}

package assignment03;
/**
 * @author Jiwon Nam , Nickolas Komarnitsky
 */
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchSet<E> implements SortedSet<E>{

	E[] arr;
	int size;
	Comparator<? super E> c;

	@SuppressWarnings("unchecked")
	public BinarySearchSet() {
		arr = (E[]) new Object[1];
		size = 0;
	}

	public BinarySearchSet(Comparator<? super E> comparator) {
		c = comparator;
	}

	@Override
	public Comparator<? super E> comparator() {
		return c;
	}

	@Override
	public E first() throws NoSuchElementException {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return arr[0];
	}

	@Override
	public E last() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return arr[size - 1];
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E element) {
		if (isEmpty()) {
			arr[0] = element;
			size++;
			return true;
		}
		if (contains(element) == true) {
			return false;
		}
		int index = binarySearch(element, arr);
		E[] temp = (E[]) new Object[size + 1];
		for (int i = 0; i < index; i++) {
			temp[i] = arr[i];
		}
		temp[index] = element;
		for (int i = index; i < size; i++) {
			temp[i + 1] = arr[i];
		}
		arr = temp;
		size++;
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> elements) {

		if (elements.isEmpty()) {
			throw new NullPointerException();
		}
		for (E e : elements) {
			this.add(e);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {

		arr = (E[]) new Object[1];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object element) {
		if (!isEmpty() && arr[0] == element || binarySearch((E) element, arr) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * binary search helper method with two elements parameters
	 * 
	 * @param element
	 * 		-the item that we are looking for in array
	 * @param array
	 * 		-the input array that we are searching in
	 * @return the index of array, if duplicate, return negative position
	 */
	@SuppressWarnings("unchecked")
	public int binarySearch(E element, E[] array) {
		int low = 0;
		int high = size - 1;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (c != null) {
				if (array[middle] == element) {
					return -middle;
				}
				else if (c.compare((E) element, array[middle]) < 0) {
					low = middle - 1;
				}
				else if (c.compare((E) element, array[middle]) > 0) {
					high = middle + 1;
				}
			}
			else {
				if ((((Comparable<? super E>) element).compareTo(array[middle])) == 0) {
					return -middle;
				}
				else if ((((Comparable<? super E>) element).compareTo(array[middle])) > 0) {
					low = middle + 1;
				}
				else if ((((Comparable<? super E>) element).compareTo(array[middle])) < 0) {
					high = middle - 1;
				}
			}
		}
		return low;
	}

	@Override
	public boolean containsAll(Collection<?> elements) {

		for (Object e : elements) {
			if (contains(e) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {

		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {

			int index = 0;
			int lastIndex = -1;

			@Override
			public boolean hasNext() {
				if (index >= size) {
					return false;
				}
				return true;
			}

			@Override
			public E next() {
				if (index >= size) {
					throw new NoSuchElementException();
				}
				lastIndex = index;
				index++;
				return arr[lastIndex];
			}

			@SuppressWarnings("unchecked")
			public void remove() {
				E[] temp = (E[]) new Object[size - 1];
				int index = -binarySearch(arr[this.index], arr);
				for (int i = 0; i < index; i++) {
					temp[i] = arr[i];
				}
				for (int i = index + 1; i < arr.length; i++) {
					temp[i - 1] = arr[i];
				}
				arr = temp;
				size--;
			}
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object element) {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		if (contains(element) == false) {
			return false;
		}
		else {
			E[] temp = (E[]) new Object[size - 1];
			int index = -binarySearch((E) element, arr);
			for (int i = 0; i < index; i++) {
				temp[i] = arr[i];
			}
			for (int i = index + 1; i < arr.length; i++) {
				temp[i - 1] = arr[i];
			}
			arr = temp;
			size--;
			return true;
		}
	}

	@Override
	public boolean removeAll(Collection<?> elements) {
		for (Object e : elements) {
			this.remove(e);
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		return arr;
	}

}

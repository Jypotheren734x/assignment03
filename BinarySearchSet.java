package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchSet<E> implements SortedSet<E>, Iterable<E> {

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
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return arr[0];
	}

	@Override
	public E last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return arr[size - 1];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			E[] temp = (E[]) new Object[size + 1];
			temp[0] = (E) element;
			arr = temp;
			size++;
			return true;
		}
		if (contains(element) == true) {
			return false;
		}
		int index = binarySearch(element);
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
		// TODO Auto-generated method stub
		for (E e : elements) {
			this.add(e);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		arr = (E[]) new Object[1];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return false;
		}
		if (arr[0] == element || binarySearch((E) element) < 0) {
			return true;
		}
		return false;
	}

	public int binarySearch(E element) {
		int low = 0;
		int high = size - 1;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (c != null) {
				if (arr[middle] == element) {
					return -middle;
				}
				else if (c.compare((E) element, arr[middle]) < 0) {
					low = middle - 1;
				}
				else if (c.compare((E) element, arr[middle]) > 0) {
					high = middle + 1;
				}
			}
			else {
				if (arr[middle] == element) {
					return -middle;
				}
				else if ((((Comparable<? super E>) element).compareTo(arr[middle])) > 0) {
					low = middle + 1;
				}
				else if ((((Comparable<? super E>) element).compareTo(arr[middle])) < 0) {
					high = middle - 1;
				}
			}
		}
		return low;
	}

	@Override
	public boolean containsAll(Collection<?> elements) {
		// TODO Auto-generated method stub
		for (Object e : elements) {
			if (contains(e) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
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

			public void remove() {
			}
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object element) {
		// TODO Auto-generated method stub
		if (contains(element) == false) {
			return false;
		}
		else {
			E[] temp = (E[]) new Object[size - 1];
			int index = -binarySearch((E) element);
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
		// TODO Auto-generated method stub
		for (Object e : elements) {
			this.remove(e);
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return arr;
	}

}

package assignment03;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSetTest {

	@Test
	public void testArray() {
		String[] expected = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		BinarySearchSet<String> binary = new BinarySearchSet<String>();
		binary.add("B");
		binary.add("C");
		binary.add("D");
		binary.add("E");
		binary.add("F");
		binary.add("G");
		binary.add("H");
		binary.add("I");
		binary.add("J");
		binary.add("K");
		binary.add("L");
		binary.add("M");
		binary.add("O");
		binary.add("N");
		binary.add("P");
		binary.add("Q");
		binary.add("R");
		binary.add("A");
		binary.add("T");
		binary.add("U");
		binary.add("V");
		binary.add("W");
		binary.add("X");
		binary.add("Y");
		binary.add("Z");
		binary.add("C");
		binary.add("D");
		binary.add("E");
		binary.add("F");
		binary.add("S");
		Assert.assertEquals(true, binary.contains("A"));
		BinarySearchSet<Double> binaryD = new BinarySearchSet<Double>();
		double x = 0;
		Double[] ar = new Double[1000];
		while (x < 1000) {
			ar[(int) x] = x;
			binaryD.add(x);
			x++;
		}
		Assert.assertArrayEquals(ar, binaryD.arr);
		Assert.assertArrayEquals(expected, binary.arr);
	}

	@Test
	public void testAddAll() {
		String[] test = { "A", "B", "D", "C" };
		String[] expected = { "A", "B", "C", "D" };
		List<String> e = Arrays.asList(test);
		BinarySearchSet<String> binary = new BinarySearchSet<String>();
		binary.addAll(e);
		Assert.assertArrayEquals(expected, binary.arr);
	}

	@Test
	public void testRemove() {
		String[] expected = { "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "Y", "Z" };
		String[] test = { "A", "B", "D", "C" };
		List<String> e = Arrays.asList(test);
		BinarySearchSet<String> binary = new BinarySearchSet<String>();
		binary.add("B");
		binary.add("C");
		binary.add("D");
		binary.add("E");
		binary.add("F");
		binary.add("G");
		binary.add("H");
		binary.add("I");
		binary.add("J");
		binary.add("K");
		binary.add("L");
		binary.add("M");
		binary.add("O");
		binary.add("N");
		binary.add("P");
		binary.add("Q");
		binary.add("R");
		binary.add("A");
		binary.add("T");
		binary.add("U");
		binary.add("V");
		binary.add("W");
		binary.add("X");
		binary.add("Y");
		binary.add("Z");
		binary.add("C");
		binary.add("D");
		binary.add("E");
		binary.add("F");
		binary.add("S");
		binary.remove("X");
		binary.removeAll(e);
		Assert.assertArrayEquals(expected, binary.arr);
	}

}

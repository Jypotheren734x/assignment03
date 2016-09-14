package assignment03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchSetTest {

	BinarySearchSet<Integer> binarySet;
	ArrayList<Integer> ranList;
	ArrayList<Integer> ascendingList;
	ArrayList<Integer> decendingList;
	
	Object[] numExpect;
	
	@Before
	public void setUp() throws Exception {
		binarySet = new BinarySearchSet<Integer>();
		
		Random ran = new Random();
		
		ranList = new ArrayList<Integer>();
		ascendingList = new ArrayList<Integer>();
		decendingList = new ArrayList<Integer>();
		int count = 0;
		while(count < 100)
		{
			int ranNum = ran.nextInt(100);
			if(!ranList.contains(ranNum))
			{
				ranList.add(ranNum);		
				count++;
			}
			else
				continue;
		}
		
		for(int i = 0; i < 100; i++)
			ascendingList.add(i);
		
		for(int i = 0; i < 100; i++)
			decendingList.add(99 - i);
		
		numExpect = new Integer[100];
		for(int i = 0; i < 100; i++)
			numExpect[i] = i;
	}
	/**
	 * integer add test Integers
	 */
	@Test
	public void addTest()
	{
		// adding random order 0 - 99
		for(int i = 0; i < 100; i++)
			binarySet.add(ranList.get(i));
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());
		
		//clear binarySet
		binarySet.clear();
		
		assertTrue(binarySet.isEmpty());
		
		// adding ascending order 0 - 99
		for(int i = 0; i< 100; i++)
			binarySet.add(ascendingList.get(i));
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());

		//clear binarySet
		binarySet.clear();
				
		assertTrue(binarySet.isEmpty());
				
		// adding descending order 0 - 99
		for(int i = 0; i < 100; i++)
			binarySet.add(decendingList.get(i));
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());

		//clear binarySet
		binarySet.clear();
				
		assertTrue(binarySet.isEmpty());
	}
	
	/**
	 * integer contain test
	 */
	@Test
	public void containTest()
	{
		binarySet.add(0);
		binarySet.add(3);
		binarySet.add(2);
		binarySet.add(100);
		binarySet.add(-32);
		binarySet.add(99);
		binarySet.add(17);
		
		assertTrue(binarySet.contains(0));
		assertTrue(binarySet.contains(3));
		assertTrue(binarySet.contains(2));
		assertTrue(binarySet.contains(100));
		assertTrue(binarySet.contains(-32));
		assertTrue(binarySet.contains(99));
		assertTrue(binarySet.contains(17));
	}
	
	/**
	 * number remove test
	 */
	@Test
	public void removeTest()
	{
		binarySet.add(0);
		binarySet.add(1);
		assertTrue(binarySet.size() == 2);
		assertTrue(binarySet.remove(0));
		assertTrue(binarySet.size() == 1);
		Assert.assertArrayEquals(binarySet.toArray(), new Object[]{1});
		assertTrue(binarySet.remove(1));
		assertTrue(binarySet.size() == 0);
		assertTrue(binarySet.isEmpty());
	}
	
	/**
	 * number addAll test
	 */
	@Test
	public void addAllTest()
	{
		assertTrue(binarySet.isEmpty());
		// random order list add all
		binarySet.addAll(ranList);
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());
		
		//clear binarySet
		binarySet.clear();
						
		assertTrue(binarySet.isEmpty());
		
		binarySet.addAll(ascendingList);
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());
		
		//clear binarySet
		binarySet.clear();
						
		assertTrue(binarySet.isEmpty());
		
		binarySet.addAll(decendingList);
		
		Assert.assertArrayEquals(numExpect, binarySet.toArray());
		
		//clear binarySet
		binarySet.clear();
						
		assertTrue(binarySet.isEmpty());
	}
	
	/**
	 * number containsAll test
	 */
	@Test
	public void containsAllTest()
	{
		binarySet.addAll(ranList);
		
		assertTrue(binarySet.containsAll(ranList));
		assertTrue(binarySet.containsAll(ascendingList));
		assertTrue(binarySet.containsAll(decendingList));
	}
	
	@Test
	public void removeAllTest()
	{
		binarySet.addAll(ranList);
		assertTrue(binarySet.removeAll(ranList));
		assertTrue(binarySet.isEmpty());
	}
	@Test
	public void arrayStringTest() {
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

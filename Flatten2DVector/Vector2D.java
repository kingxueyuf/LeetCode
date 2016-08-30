package Flatten2DVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

	List<List<Integer>> vec2d;
	int row;
	int col;
	boolean findRow = false;

	public Vector2D(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		row = 0;
		col = 0;
	}

	@Override
	public Integer next() {
		int val = this.vec2d.get(row).get(col);
		col++;
		return val;
	}

	@Override
	public boolean hasNext() {
		if (!findRow) {
			// find next row
			while (row < this.vec2d.size()) {
				if (this.vec2d.get(row) != null && this.vec2d.get(row).size() > 0) {
					findRow = true;
					return true;
				}
				row++;
			}
			return false;
		} else {
			// check col
			while (col < this.vec2d.get(row).size()) {
				if (this.vec2d.get(row).get(col) != null)
					return true;
				col++;
			}
			col = 0;
			row++;
			findRow = false;
			while (row < this.vec2d.size()) {
				if (this.vec2d.get(row) != null && this.vec2d.get(row).size() > 0) {
					findRow = true;
					return true;
				}
				row++;
			}
			return false;
		}
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2 }));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3 }));
		ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 5, 6 }));
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		vec2d.add(one);
		vec2d.add(two);
		vec2d.add(three);
		Vector2D i = new Vector2D(vec2d);
		while (i.hasNext())
			System.out.print(i.next());

	}

}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D i =
 * new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
 */

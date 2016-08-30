package Flatten2DVector;

import java.util.Iterator;
import java.util.List;

public class Vector2D_2 implements Iterator<Integer> {

	List<List<Integer>> vec2d;
	Iterator<List<Integer>> row;
	Iterator<Integer> col;

	public Vector2D_2(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		row = this.vec2d.iterator();
	}

	@Override
	public Integer next() {
		return col.next();
	}

	@Override
	public boolean hasNext() {
		if (col == null) {
			if (row.hasNext()) {
				col = row.next().iterator();
				while (!col.hasNext() && row.hasNext()) {
					col = row.next().iterator();
				}
				if (col.hasNext())
					return true;
				return false;
			} else {
				return false;
			}
		} else {
			if (col.hasNext()) {
				return true;
			} else {
				if (row.hasNext()) {
					col = row.next().iterator();
					while (!col.hasNext() && row.hasNext()) {
						col = row.next().iterator();
					}
					if (col.hasNext())
						return true;
					return false;
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public void remove() {
		
	}
}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D i =
 * new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
 */

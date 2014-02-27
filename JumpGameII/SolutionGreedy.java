package JumpGameII;

public class SolutionGreedy {
	public int jump(int[] A) {

		int steps = 0;
		int max = 0;
		int temp = 0;

		int i = 0;
		for (; i < A.length;) {
			if (temp >= A.length - 1)
				break;
			for (; i <= temp; i++) {
				max = Math.max(max, i + A[i]);
			}
			steps++;
			temp = max;
		}
		return steps;

	}
	
	public int jump2(int[] A)
	{
		int steps = 0;
	    for (int i=1, max=A[0], next=0; i<A.length; ++i) {
	        if (i>next) {
	            if (max < i)  return -1; // unreachable
	            next = max;
	            ++steps;
	        }
	        max = Math.max(max, i+A[i]);
	    }
	    return steps;
	}

	public void test() {
		int[] A = { 2, 3, 1, 1, 4, 0, 0, 0, 0, 0, 0 };
		int num = jump2(A);
		System.out.println(num);
	}
}

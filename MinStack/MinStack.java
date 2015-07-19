package MinStack;

import java.util.Stack;

class MinStack {
	Stack<Integer> traceMinStack = new Stack<Integer>();
	Stack<Integer> stack = new Stack<Integer>();

	public void push(int x) {
		if (stack.size() == 0) {
			stack.push(x);
			traceMinStack.push(x);
		} else {
			stack.push(x);
			if (x <= traceMinStack.peek().intValue()) {
				traceMinStack.push(x);
			}
		}
	}

	public void pop() {
		if (stack.peek().intValue() == traceMinStack.peek().intValue()) {
			stack.pop();
			traceMinStack.pop();
		} else {
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return traceMinStack.peek();
	}

	public static void main(String args[]) {
		MinStack ms = new MinStack();
		int[] arr = { 512, -1024, -1024, 512 };
		for (int i = 0; i < arr.length; i++) {
			ms.push(arr[i]);
		}
		for (int i = 0; i < arr.length - 1; i++) {
			ms.pop();
			System.out.println(ms.getMin());
		}
	}
}

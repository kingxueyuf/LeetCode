package GasStation;

/*
 * There are N gas stations along a circular route, 
 * where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of 
 * gas to travel from station i to its next station (i+1). You begin the journey with an 
 * empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1
 * 
 */
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] arr = new int[gas.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = gas[i] - cost[i];
		}
		int total = 0;
		int start = 0;
		boolean find = true;
		while (start < arr.length) {
			find = true;
			total = 0;
			for (int i = 0; i < arr.length; i++) {
				total += arr[(start + i) % arr.length];
				if (total < 0) {
					start = start + i + 1;
					find = false;
					break;
				}
			}
			if (find)
				return start;
		}
		return -1;
	}
}
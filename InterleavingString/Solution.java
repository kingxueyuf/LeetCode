package InterleavingString;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
			return true;
		char[] s1array = s1.toCharArray();
		char[] s2array = s2.toCharArray();
		char[] s3array = s3.toCharArray();
		boolean[][][] dp3D = new boolean[s3.length() + 1][s1.length() + 1][s2
				.length() + 1];

		for (int a = 1; a <= s3.length(); a++) {
			for (int b = 0; b <= Math.min(a, s1.length()); b++) {
				int c = a - b;
				if (c > s2.length())
					continue;
				if (b == 0) {
					dp3D[a][b][c] = (s3.substring(0, a).equals(s2.substring(0,
							c)));
					// System.out.println(dp3D[a][b][c]);
					continue;
				}
				if (c == 0) {
					dp3D[a][b][c] = (s3.substring(0, a).equals(s1.substring(0,
							b)));
					// System.out.println(dp3D[a][b][c]);
					continue;
				}
				if (s3array[a - 1] != s1array[b - 1]
						&& s3array[a - 1] != s2array[c - 1])
					dp3D[a][b][c] = false;
				else {
					boolean bSubOne = false;
					if (s3array[a - 1] == s1array[b - 1])
						bSubOne = dp3D[a - 1][b - 1][c];
					boolean cSubOne = false;
					if (s3array[a - 1] == s2array[c - 1])
						cSubOne = dp3D[a - 1][b][c - 1];

					dp3D[a][b][c] = bSubOne || cSubOne;
				}
			}
		}
		return dp3D[s3.length()][s1.length()][s2.length()];
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		String s1 = "ab";
		String s2 = "bc";
		String s3 = "bbac";
		boolean is = s.isInterleave(s1, s2, s3);
		System.out.println(is);
	}
}

public class Solution {
    public int minDistance(String word1, String word2) {
    	char[] arr1 = word1.toCharArray();
    	char[] arr2 = word2.toCharArray();
    	int[][] dp = new int[arr1.length+1][arr2.length+1];
    	for(int j = 0 ; j <= arr2.length; j++){
    		dp[0][j] = j;
    	}
    	for(int i = 0 ; i <= arr1.length; i++){
    		dp[i][0] = i;
    	}
    	for(int i = 1 ; i <= arr1.length; i++){
    		for(int j = 1 ; j <= arr2.length; j++){
                int mn1 = dp[i-1][j] + 1;
                int m1n = dp[i][j-1] + 1;
                int tmp = 0;
                if(arr1[i-1] != arr2[j-1])
                {
                    tmp = 1;
                }
                int m1n1 = dp[i-1][j-1] + tmp;
                int min = mn1;
                if( m1n < min)
                    min = m1n;
                if( m1n1 < min){
                    min = m1n1;
                }
                dp[i][j] = min;
    		}
    	}
        return dp[arr1.length][arr2.length];
    }
}
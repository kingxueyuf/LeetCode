public class Solution {
    public int minDistance(String word1, String word2) {
    	char[] arr1 = word1.toCharArray();
    	char[] arr2 = word2.toCharArray();
    	int[][] dp = new int[arr1.length()+1][arr2.length()+1];
    	for(int j = 0 ; j <= arr2.length(); j++){
    		dp[0][j] = j;
    	}
    	for(int i = 0 ; i <= arr1.length(); i++){
    		dp[i][0] = i;
    	}
    	for(int i = 0 ; i < arr1.length(); i++){
    		for(int j = 0 ; j < arr2.length(); j++){

    		}
    	}
    }
}
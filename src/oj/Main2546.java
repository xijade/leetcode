package oj;
import java.io.*;
import java.util.*;
public class Main2546 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			
			if (n==0) {
				break;
			}
			
			int dp[] = new int[1001];
			int w[] = new int[n];	//≤À«Æ------÷ÿ¡ø
			for (int i=0;i<n;i++) {
				w[i] = scanner.nextInt();
			}
			int v = scanner.nextInt();	//”‡∂Ó
			Arrays.sort(w);
			if (v<5) {
				System.out.println(v);
				continue;
			}
			
			for (int i=0;i<n-1;i++) {
				for (int j=v-5;j>=w[i];j--) {
					dp[j] = Math.max(dp[j], dp[j-w[i]]+w[i]);
				}
			}
			
			System.out.println(v-dp[v-5]-w[n-1]);
		}
 	
    		
    		
    	
    }
}

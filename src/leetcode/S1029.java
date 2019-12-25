package leetcode;

public class S1029 {
	 public int twoCitySchedCost(int[][] costs) {
	       int len = costs.length;
	       int difcosts[] = new int[len];
	       int sum = 0;
	       for(int i = 0;i<len;i++) {
	    	   difcosts[i] = costs[i][1] - costs[i][0];
	       }
	       sort(difcosts, 0, difcosts.length - 1,costs);
	       
	       for(int i = 0;i<len/2;i++)
	    	   sum += costs[i][1];
	       
	       for(int i = len/2;i<len;i++)
	    	   sum += costs[i][0];
	       
	       return sum;
	       
	    }
	 
	 private static void sort(int[] a, int lo, int hi,int[][] costs) {
			if (hi <= lo) {
				return;
			}
			int lt = lo, i = lo + 1, gt = hi;
			int v = a[lo];
			
			//loΪ���ŵ����ɸ����з�Ԫ�ص�һ����index��iΪ�з�Ԫ�ؿ���һ��index������һ��Ҫ���������gtΪ����v������ȥ������ĩβ��ʼ
			while (i <= gt) {
				int cmp = a[i]-v;
				if (cmp < 0) {
					exch(a, lt++, i++,costs);
				} else if (cmp > 0) {
					exch(a, i, gt--,costs);
				} else {
					i++;
				}
			}
			sort(a, lo, lt - 1,costs);
			sort(a, gt + 1, hi,costs);
		}

	

		private static void exch(int[] a, int i, int j,int[][] costs) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			int temp[] = costs[i];
			costs[i] = costs[j];
			costs[j] = temp;
		}


}

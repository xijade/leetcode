package algo;

public class Quick {
	public static void sort(Comparable[] a) {
		//打乱了数组顺序
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	
	private static int partition(Comparable[] a,int lo,int hi) {
		Comparable k = a[lo];
		int i = lo;
		int j = hi+1;
		
		while (true) {
			//除了切分值为最值的情况，否则ij碰面必能跳出下面两个while，if里面是防止k为最值导致越界 a[i] i变为hi+1
			while (less(a[++i], k)) {
				System.out.println(i+ " : " + a[i]);
				if (i == hi) {
					break;
				}
			}
			while (less(k, a[--j])) {
				System.out.println(j+ " : " + a[j]);
				if (j == lo) {//其实没用，less(k,a[lo])一定是false，,因为 k=l[lo]所以j=lo根本不会进入这个while循环
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
			show(a);
		}
	    exch(a, lo, j);
		return j;
	    
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] {999999999,-3,1,6,3,8,234,64,41234,7557,5,123,423,534,57,99999,4567887,45445,7845,4123};
		show(a);
		sort(a);
		
		show(a);
	}
}

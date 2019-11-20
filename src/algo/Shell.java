package algo;

public class Shell {
    
	
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h < N/3) {
			h = h*3+1;
		}
		
		while(h >= 1) {
			for(int i = h;i<N;i++) {
				for(int j = i;j>=h&&less(a[j],a[j-h]);j-=h) {
					exch(a,j,j-h);
				}
			}
			h/=3;
		}
		
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
		Integer[] a = new Integer[] {-3,1,6,3,8,234,64,41234,7557,5,123,423,534,57,99999,4567887,45445,7845,4123};
		sort(a);
		
		show(a);
	}
}

package algo;

public class Quick3way {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
    
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		
		//lo为连着的若干个的切分元素第一个的index，i为切分元素块下一个index，即下一个要处理的数，gt为大于v的数的去处，从末尾开始
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {
				exch(a, lt++, i++);
			} else if (cmp > 0) {
				exch(a, i, gt--);
			} else {
				i++;
			}
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
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
		Integer[] a = new Integer[] {2,2,2,7,8,9,4,6,4,5,98,3,2,3,1,0,1,4};
		show(a);
		sort(a);
		
		show(a);
	}
}

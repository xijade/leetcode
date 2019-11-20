package algo;

public class MinPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	private Key max;

	public MinPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		pq[++N] = v;
		if (N == 1 || max.compareTo(v) < 0) {
			max = v;
		}
		swim(N);
	}

	public Key delMin() {
		Key min = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		if (isEmpty()) {
			max = null;
		}
		return min;
	}
    //此处是索引不是值
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j + 1, j)) {
				j++;
			}
			if (!less(j, k)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	/**
	 * Exercise 2.4.27
	 * 
	 * @return
	 */
	public Key max() {
		return max;
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[] {97,999999999,-3,1,6,3,8,234,64,41234,7557,5,123,423,534,57,99999,4567887,45445,7845,4123};
		//show(a);
		MinPQ<Integer> pq = new MinPQ(30);
		for(Integer i : a) {
			 pq.insert(i);
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.delMin());
		
		}
	}
}
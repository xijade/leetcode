package model;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	class Node{
		private Key key;
		private Value val;
		private Node right,left;
		private int N;
		private boolean color;
		
		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
		
	}
	
	
	public boolean isRed(Node x) {
		
		if (x == null) {
			return false;
		}
		return x.color == RED;
	}
	
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}
	
	public Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		x.color = h.color;
		h.right = x.left;
		x.left = h;
		
		
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		
		return x;
	}
	//����һ���ڵ㣬ʹԭ��һ��2-3�ڵ���3��1-2�ڵ�ʱ�õ�
	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}
	
	public void put(Key key,Value val) {
		root = put(root, key, val);
		root.color = BLACK;
		
	}
	//����Ĭ�϶��Ǻ����ӣ����뵽2-3�����Ͼ��൱�ڴ�������ʱ��3-4�ڵ�
	private Node put(Node h, Key key, Value val) {
		if (h == null) {
			return new Node(key, val, 1, RED);
		}

		int cmp = key.compareTo(h.key);
		if (cmp < 0) {
			h.left = put(h.left, key, val);
		} else if (cmp > 0) {
			h.right = put(h.right, key, val);
		} else {
			h.val = val;
		}

		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);//���h��color == RED ����һ����ת���ɵڶ���if��������ǵ����Ļ�������˳��
		}
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h); //��������������ӣ����м����Ϊ���ڵ㣬ԭ���ڵ��Ϊ���ӽڵ�
		}
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);//ԭ��ڵ��Ҳ���룬�ֽ�����ɺڽڵ�
		}

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	private Node moveRedLeft(Node h) {
		flipColors(h);
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}

	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMin(root);
		if (root != null) {
			root.color = BLACK;
		}
	}

	private Node deleteMin(Node h) {
		if (h.left == null) {
			return null;
		}
		if (!isRed(h.left) && !isRed(h.left.left)) {
			h = moveRedLeft(h);
		}
		h.left = deleteMin(h.left);
		return balance(h);
	}

	private Node balance(Node h) {
		if (isRed(h.right)) {
			h = rotateLeft(h);
		}
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	// Exercise 3.3.40
	private Node moveRedRight(Node h) {
		flipColors(h);
		if (isRed(h.left.left)) {
			h = rotateRight(h);
		}
		return h;
	}

	public void deleteMax() {
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMax(root);
		if (root != null) {
			root.color = BLACK;
		}
	}

	private Node deleteMax(Node h) {
		if (isRed(h.left)) {
			h = rotateRight(h);
		}
		if (h.right == null) {
			return null;
		}
		if (!isRed(h.right) && !isRed(h.right.left)) {
			h = moveRedRight(h);
		}
		h.right = deleteMax(h.right);
		return balance(h);
	}

	// Exercise 3.3.41
	public void delete(Key key) {
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = delete(root, key);
		if (root != null) {
			root.color = BLACK;
		}
	}

	private Node delete(Node h, Key key) {
		if (key.compareTo(h.key) < 0) {
			if (!isRed(h.left) && !isRed(h.left.left)) {//������Ǻ�ɫ��˵��һ��������-2�ڵ㣻������һ����ɫ����-3.ɾ����������Ҫ��ɾ���ĵ㲻����-2,��ȻӰ��ƽ���ԣ�����Ҫ��·���ǵĵ㱣��Ϊ-3 ����-4�ڵ�
				h = moveRedLeft(h);
			}
			h.left = delete(h.left, key);
		} else {
			if (isRed(h.left)) {
				h = rotateRight(h);
			}
			if (key.compareTo(h.key) == 0 && h.right == null) {
				return null;
			}
			if (!isRed(h.right) && !isRed(h.right.left)) {
				h = moveRedRight(h);
			}
			if (key.compareTo(h.key) == 0) {
				h.val = get(h.right, min(h.right).key);
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			} else {
				h.right = delete(h.right, key);
			}
		}
		return balance(h);
	}
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.val;
		}
	}

	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) {
			return x;
		}
		return max(x.right);
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return floor(x.left, key);
		}
		Node t = floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp > 0) {
			return floor(x.right, key);
		}
		Node t = floor(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node x, int k) {
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x;
		}
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null) {
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(key, x.left);
		} else if (cmp > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		} else {
			return size(x.left);
		}
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			queue.enqueue(x.key);
		}
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}
	}
    

}

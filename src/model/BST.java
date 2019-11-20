package model;

public class BST<Key extends Comparable<Key>, Value> {
	public Node root;
	
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		
		public Node(Key key,Value val,int n) {
			this.key = key;
			this.val = val;
			this.N= N;
			
		}
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(Node x) {
		if(x == null)
			return 0;
		return x.N;
	}
	
	
	public Value get(Key key) {
		return get(key,root);
	}
	private Value get(Key key,Node x) {
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0) {
			return get(key,x.right);
		}else if(cmp < 0) {
			return get(key,x.left);
		}else  {
			
			return x.val;
		}
	}
	
	public void put(Key key,Value val) {
		put(key,val,root);
	}
	
	private Node put(Key key,Value val,Node x) {
		if(x == null) {
			x = new Node(key,val,1);
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			x.left = put(key,val,x.left);
		}else if(cmp > 0) {
			x.right = put(key,val,x.right);
		}else {
			x.val = val;
		}
		x.N = size(x.left)+size(x.right)+1;
		return  x;
	}
	
//	public Value min() {
//		Node x = root;
//		while(x.left != null)
//			x = x.left;
//		return x.val;
//			
//	}
//	
//	
//	public Value max() {
//		Node x = root;
//		while(x.right != null)
//			x = x.right;
//		return x.val;
//			
//	}
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
			return x;                      //最后一层是找到的都是t=null，返回最后这层的x，这个x是前面每次迭代的返回值
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
	
	
	//从0开始
	public Key select(int k) {
		return select(root,k).key;
	}
	
	private Node select(Node x,int k) {
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
	
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			Node t = x;
			x = min(t.right);
			
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
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

package algo;
//Ҫ��a[0]���ã���1��ʼ������k���ӽڵ���� 2k 2k+1
public class Heap {
    public static void sort(Comparable[] a) {
    	int N = a.length-1;
    	System.out.println(N);
    	//��ʼ��������һ��ÿ�����ڵ㶼�������ӽڵ��Ķ�
    	for(int k = N/2;k>0;k--) {
            System.out.println(k);
    		sink(a,k,N);
    	}
    	//���Ѱ��ڵ��������
    	while(N>1) {
    		exch(a,1,N--);
    		sink(a,1,N);
    	}
    	
    	
    }
    
    
    public static void sink(Comparable[] a,int k,int n) {
    	int j = k*2;
    	while(j <= n) {
	    	if(j<n && less(a[j],a[j+1])) // �ж��Ƿ������һ���ӽڵ� ������ȥ�ϴ���Ǹ�
	    		j++;
	    	if(!less(a[k],a[j])) {
	    		break;
	    	}
	    	exch(a,k,j);
	    	k = j;
	    	j = 2*j;
		    
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
	
	public static void main(String[] args) {
		Integer[] a = new Integer[] {97,999999999,-3,1,6,3,8,234,64,41234,7557,5,123,423,534,57,99999,4567887,45445,7845,4123};
		//show(a);
		
		sort(a);
		
		show(a);
	}
}

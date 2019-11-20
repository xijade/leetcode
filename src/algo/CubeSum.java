package algo;
//�����i,0��...��i,j-1�� ��û����,���Ǳض��ֲ�����i��j���ģ�������ѹ��N��(i,0)����������һ�����ܵ���Сֵ��(i,1)
public class CubeSum implements Comparable<CubeSum> {
	private int i, j, sum;

	public CubeSum(int i, int j) {
		this.i = i;
		this.j = j;
		sum = i * i * i + j * j * j;
	}

	@Override
	public int compareTo(CubeSum that) {
		if (this.sum > that.sum) {
			return 1;
		} else if (this.sum < that.sum) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int N = 100;
		
		
		MinPQ<CubeSum> pq = new MinPQ<>(120);
		for (int i = 1; i <= N; i++) {
			pq.insert(new CubeSum(i, 0));
		}
		CubeSum tem = new CubeSum(0, 0);
		while (!pq.isEmpty()) {
			CubeSum min = pq.delMin();
			//System.out.println(min.sum + " = " + min.i + "^3 + " + min.j + "^3");
			if (min.j < N) {
				pq.insert(new CubeSum(min.i, min.j + 1));
			}
			
		    if(min.sum == tem.sum && min.j != tem.i) {
					System.out.println(min.sum + " = " + min.i + "^3 + " + min.j + "^3"+ " = " + tem.i + "^3 + " + tem.j + "^3");
			
			}
			tem = min;
			
		}
	}
}
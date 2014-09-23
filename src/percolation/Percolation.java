/**
 * 
 */
package percolation;

/**
 * @author AXRFO
 *
 */
public class Percolation {

	private int N = 0;
	private static int CLOSE = 0;
	private static int OPEN = 1;
	private int opennodes;
	int[][] site;
	WeightedQuickUnionUF xxx;
	private int top = xyTO1D(N, N) + 2;
	private int bottom = xyTO1D(N, N) + 1;

	/**
	 * @param N
	 */
	public Percolation(int p) {
		N = p;
		site = new int[N][N];
		if (N <= 0) {
			throw new IllegalArgumentException("Illegal parameter value.");
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// System.out.print(i);
					// System.out.print(j);
					site[i][j] = CLOSE;
				}
			}
			xxx = new WeightedQuickUnionUF((N * N) + 2);
			setOpennodes(0);
		}
	}

	public void open(int i, int j) {
		if (isIndexValid(i) && isIndexValid(j)) {
			if (!isOpen(i, j)) {
				site[i - 1][j - 1] = OPEN;
				setOpennodes(getOpennodes() + 1);
				if (i == 1) {
					xxx.union(xyTO1D(i, j), bottom);
				}

				if (i == N) {
					xxx.union(xyTO1D(i, j), top);
				}
				if (i > 1) {
					if (isOpen(i - 1, j)) {
						xxx.union(xyTO1D(i, j), xyTO1D(i - 1, j));
					}
				}
				if (j > 1) {
					if (isOpen(i, j - 1)) {
						xxx.union(xyTO1D(i, j), xyTO1D(i, j - 1));
					}
				}
				if (i < N - 1) {
					if (isOpen(i + 1, j)) {
						xxx.union(xyTO1D(i, j), xyTO1D(i + 1, j));
					}
				}
				if (j < N - 1) {
					if (isOpen(i, j + 1)) {
						xxx.union(xyTO1D(i, j), xyTO1D(i, j + 1));
					}
				}
			}
		}
	}

	public boolean isOpen(int i, int j) {
		boolean flag = false;
		if (isIndexValid(i) && isIndexValid(j)) {
			if (site[i - 1][j - 1] != CLOSE) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isFull(int i, int j) {
		boolean flag;
		if (xxx.connected(xyTO1D(i, j), bottom)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean percolate() {
		return xxx.connected(bottom, top);
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private boolean isIndexValid(int i) {
		boolean flag = false;
		i--;
		if (i < 0 || i > N - 1) {
			throw new IndexOutOfBoundsException("Error in the index");
		} else {
			flag = true;
		}
		return flag;
	}

	private int xyTO1D(int i, int j) {
		return ((i - 1) * N) + j;
	}

	public int getOpennodes() {
		return opennodes;
	}

	public void setOpennodes(int opennodes) {
		this.opennodes = opennodes;
	}

	public static void main(String[] args) {
		// TODO
		Percolation www = new Percolation(10);
		www.open(1, 1);
		www.open(1, 1);
		www.open(2, 1);
		www.open(3, 1);
		www.open(4, 2);
		 www.open(3, 2);
		for (int i = 0; i < www.N; i++) {
			for (int j = 0; j < www.N; j++) {
				System.out.print(www.getNode(i, j));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(www.isFull(3, 2));
		System.out.println(www.isFull(4, 2));
		System.out.println(www.percolate());
	}

	private int getNode(int i, int j) {
		return site[i][j];
	}
}
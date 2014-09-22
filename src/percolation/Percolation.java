/**
 * 
 */
package percolation;

/**
 * @author AXRFO
 *
 */
public class Percolation {

	private static int N;
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
	public Percolation(int N) {
		if (N <= 0) {
			throw new IllegalArgumentException("Illegal parameter value.");
		} else {
			for (int i = 0; i < N; i++) {
				site[i][i] = CLOSE;
			}
			xxx = new WeightedQuickUnionUF((N * N) + 2);
			setOpennodes(0);
		}
	}

	public void open(int i, int j) {
		if (isIndexValid(i) && isIndexValid(j)) {
			if (!isOpen(i, j)) {
				site[i][j] = OPEN;
				setOpennodes(getOpennodes() + 1);
				if (i == 1) {
					xxx.union(xyTO1D(i, j), bottom);
				}
				if (i == N) {
					xxx.union(xyTO1D(i, j), top);
				}
				if (isOpen(i - 1, j)) {
					xxx.union(xyTO1D(i, j), xyTO1D(i - 1, j));
				}
				if (isOpen(i, j - 1)) {
					xxx.union(xyTO1D(i, j), xyTO1D(i, j - 1));
				}
				if (isOpen(i + 1, j)) {
					xxx.union(xyTO1D(i, j), xyTO1D(i + 1, j));
				}
				if (isOpen(i, j + 1)) {
					xxx.union(xyTO1D(i, j), xyTO1D(i, j + 1));
				}
			}
		}
	}

	public boolean isOpen(int i, int j) {
		boolean flag = false;
		if (isIndexValid(i) && isIndexValid(j)) {
			if (site[i][j] != CLOSE) {
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
		boolean flag;
		if (i <= 0 || i > N) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

	private int xyTO1D(int i, int j) {
		return ((i - 1) * N) + j;
	}

	public static void main(String[] args) {
		// TODO
	}

	public int getOpennodes() {
		return opennodes;
	}

	public void setOpennodes(int opennodes) {
		this.opennodes = opennodes;
	}
}

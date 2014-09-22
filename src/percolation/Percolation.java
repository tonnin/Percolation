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
	private static int FULL = 2;
	private int opennodes;
	int[][] site;
	WeightedQuickUnionUF xxx;

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
			xxx = new WeightedQuickUnionUF(N * N);
			opennodes = 0;
		}
	}

	public void open(int i, int j) {
		// TODO
		if (isIndexValid(i) && isIndexValid(j)) {
			if (!isOpen(i, j)) {
				// tengo que comprobar si es full open?
				// si toca linea de arriba
				// entonces FULL
				// sino
				opennodes++;
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
				//si tiene conexion con el nodo raiz entonces FULL si no OPEN
				site[i][j] = OPEN;
			}
			// Should i add the else
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
		// TODO
		boolean flag = false;
		if (isIndexValid(i) && isIndexValid(j)) {
			if (site[i][j] == FULL) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean percolate() {
		// TODO
		return true;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private boolean isIndexValid(int i) {
		if (i <= 0 || i > N)
			return false;
		else
			return true;
	}

	/**
	 * 
	 */
	private void cagada() {
		int i = 0;
		int j = 0;
		if (!isIndexValid(i) || !isIndexValid(j))
			throw new IndexOutOfBoundsException("Illegal parameter value.");
		// TODO
	}

	private int xyTO1D(int i, int j) {
		// TODO
		return 0;
	}

	public static void main(String[] args) {
		// TODO
	}
}

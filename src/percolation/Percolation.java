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
	int[][] gride;

	/**
	 * @param N
	 */
	public Percolation(int N) {
		if (N <= 0) {
			throw new IllegalArgumentException("Illegal parameter value.");
		} else {
			for (int i = 0; i < N; i++) {
				gride[i][i] = CLOSE;
			}
			opennodes = 0;
		}
	}

	public void open(int i, int j) {
		// TODO
		if (isIndexValid(i) && isIndexValid(j)) {
			if (!isOpen(i, j)) {
				gride[i][j] = OPEN;
				opennodes++;
			}
			// Should i add the else
		}
	}

	public boolean isOpen(int i, int j) {
		boolean flag = false;
		if (isIndexValid(i) && isIndexValid(j)) {
			if (gride[i][j] == OPEN) {
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
			if (gride[i][j] == FULL) {
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

	public static void main(String[] args) {
		// TODO
	}
}

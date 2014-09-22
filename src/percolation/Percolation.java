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
	int[][] gride;

	/**
	 * @param N
	 */
	public Percolation(int N) {
		if (N <= 0) {
			throw new IndexOutOfBoundsException("Illegal parameter value.");
		} else {
			for (int i = 0; i < N; i++) {
				gride[i][i] = CLOSE;
			}
		}

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

}

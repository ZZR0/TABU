public class Test {
    public static void allRowLoc() {
		int row = 0;
		int loc = 0;
		int dist = 0;
        int nL = 5;
        int nS = 4;

		while (row < nS && loc < nL) {
            System.out.println(String.format("%d %d", row, loc));

			if (row > 0 && (loc + 1) < nL) {
				row--;
				loc++;
			} else {
				dist++;
				row = Math.min(nS - 1, dist);
				loc = dist - row;
			}
		}
	}
    public static void main(String[] args) {
        allRowLoc();
    }
}

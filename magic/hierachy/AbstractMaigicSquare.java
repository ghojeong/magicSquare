package magic.hierachy;

public abstract class AbstractMaigicSquare implements IMagicSquare {
	protected int[][] grid; // 마방진을 저장할 2차원 배열
	protected int max;

	public void init(int n) {
		this.grid = new int[n][n]; // 배열의 초기화
		this.max = n - 1;
	}

	// 자식 클래스에서 따로 구현될 메소드 선언!!
	public abstract void make();

	// 마방진 출력
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int count = max + 1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				sb.append(grid[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// 마방진 검증로직 구현
	public boolean isMagicSquare() {
		boolean isCheck = true;
		int count = max + 1;

		// 2*n+2 방을 만든다. 1차원배열
		int[] mcheck = new int[2 * count + 2];

		// 2*n+2 개의 각각의 합을 구현한다.
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				mcheck[i] += grid[i][j];
				mcheck[i + count] += grid[j][i];
				if (i == j) {
					mcheck[2 * count] += grid[i][j];
				}
				if (i + j == count - 1) {
					mcheck[2 * count + 1] += grid[i][j];
				}
			}
		}

		// 최종 검증
		for (int i = 1; i < mcheck.length; i++) {
			if (mcheck[0] != mcheck[i]) {
				isCheck = false;
				break;
			}
		}

		return isCheck;
	}
}

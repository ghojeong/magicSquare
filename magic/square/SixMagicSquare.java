package magic.square;

import magic.hierachy.AbstractMaigicSquare;

/*
 * 짝수 6 마방진 만들기
 * 6, 10 ...
 * 1) A영역 : j의 n/4 두께만큼을 3로 채우고, i의 센터(n/4)위치면 오른쪽으로 한칸 민다.
 * 2) B영역 : j의 n/2 - n/4 두께만큼을 2로 채운다. 나머지는 1로 채운다.
 *           j의 n/2 두께에 1로 먼저 다채우고, j의 n/2-n/4 만큼을 2로채운다.
 * 3) CD영역 : A영역의 0->3, 3->0로 변환, D영역은 B영역의 1->2, 2->1로 변환
 * 4) 전체 * (n/2)*(n/2)
 * 5) n/2의 홀수마방진 만들어서 A,B,C,D영역에 더하기
 * */
public class SixMagicSquare extends AbstractMaigicSquare {

	public SixMagicSquare() {
		this(6);
	}

	public SixMagicSquare(int n) {
		this.init(n);
	}

	// 마방진 로직 구현하기 (6마방진)
	public void make() {
		makeA();
		makeB();
		makeCD();
		multiple();
		addABCD();
	}

	// n/2 홀수 마방진을 만들어 가져와서
	// A,B,C,D 영역에 위치에 맞게 더해준다.
	private void addABCD() {
		int count = max + 1;
		OddMagicSquare odd = new OddMagicSquare(count / 2);
		odd.make();
		int[][] oddM = odd.getMagic();

		for (int i = 0; i < count / 2; i++) {
			for (int j = 0; j < count / 2; j++) {
				super.grid[i][j] += oddM[i][j];// A
				super.grid[i][j + count / 2] += oddM[i][j];// B
				super.grid[i + count / 2][j] += oddM[i][j];// C
				super.grid[i + count / 2][j + count / 2] += oddM[i][j];// D
			}
		}
	}

	// A,B,C,D에 전체 곱하는데 값은 (n/2*n/2)을 곱한다.
	private void multiple() {
		int count = max + 1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				super.grid[i][j] *= (count / 2) * (count / 2);
			}
		}
	}

	// C와 D 영역을 만든다.
	// C: A : 0 ->3, 3->0
	// D: B : 1 ->2, 2->1
	private void makeCD() {
		int count = max + 1;
		for (int i = 0; i < count / 2; i++) {
			// C
			for (int j = 0; j < count / 2; j++) {
				if (super.grid[i][j] == 0) {
					super.grid[i + count / 2][j] = 3;
				} else {
					super.grid[i + count / 2][j] = 0;
				}
			}

			// D(B)
			for (int j = 0; j < count / 2; j++) {
				if (super.grid[i][j + count / 2] == 1) {
					super.grid[i + count / 2][j + count / 2] = 2;
				} else {
					super.grid[i + count / 2][j + count / 2] = 1;
				}
			}
		}
	}

	// B영역 만들기
	// n/2 -> 1로 먼저 채운다.
	// n/2 - (n/4-1) 제외한 만큼을 2로 채운다.
	private void makeB() {
		int count = max + 1;
		for (int i = 0; i < count / 2; i++) {
			for (int j = 0; j < count / 2; j++) {
				super.grid[i][j + count / 2] = 1;
			}
		}
		for (int i = 0; i < count / 2; i++) {
			for (int j = 0; j < count / 2 - (count / 4 - 1); j++) {
				super.grid[i][j + count / 2] = 2;
			}
		}
	}

	// A영역 만들기
	// 6마방진 -> 6/2->3
	private void makeA() {
		int count = max + 1;
		for (int i = 0; i < count / 2; i++) {
			for (int j = 0; j < count / 4; j++) {
				if (i == count / 4) {
					super.grid[i][j + 1] = 3;
				} else {
					super.grid[i][j] = 3;
				}
			}
		}
	}
}

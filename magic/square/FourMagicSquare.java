package magic.square;

import magic.hierachy.AbstractMaigicSquare;

/*
 * 짝수 마방진중에 4 마방진 만들기
 * 4*n, 4, 8, 12, 16
 * 정방향 1 ~ 16 해당위치에 넣는다.
 * 역방향 1 ~ 16을 비어있는 위치에 넣는데 역순으로 넣는다.
 *
 * if (i>=0 && i< count/4) || (i>=count/4*3 && i<count)
    (j>=count/4 && j<count/4*3)
   else
    (j>=0 && j<count/4*3) || (j>=count/4*3 && j<count)
 * */
public class FourMagicSquare extends AbstractMaigicSquare {

	public FourMagicSquare() {
		this(4);
	}

	public FourMagicSquare(int n) {
		this.init(n);
	}

	// 4마방진 로직 구현
	public void make() {
		makeRight();
		makeLeft();
	}

	// 역방항 로직 구현
	private void makeLeft() {
		int count = max + 1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if ((i >= 0 && i < count / 4) || (i >= count / 4 * 3 && i < count)) {
					if ((j >= count / 4 && j < count / 4 * 3)) {
						super.grid[i][j] = (count * count) - (i * count + j);
					}
				} else {
					if ((j >= 0 && j < count / 4) || (j >= count / 4 * 3 && j < count)) {
						super.grid[i][j] = (count * count) - (i * count + j);
					}
				}

			}
		}
	}

	// 정방향 마방진 구현
	private void makeRight() {
		int count = max + 1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				// 알칼제이 : 2차원 -> 1차원으로 변경하는 공식
				// i * count + j -> 2차원이 1차원으로 바뀐다. 0~15(n-1)
				super.grid[i][j] = i * count + j + 1;
			}
		}
	}
}

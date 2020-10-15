package magic.square;

import magic.hierachy.AbstractMaigicSquare;

/*
 * 홀수 마방진 구현하기
 * 홀수마방진의 초항 3, 기본값을 3으로 준다. ->생성자
 * 1) m(0,[n/2]) = 1 시작
 * 2) 기본 흐름 : x--, y-- 이다.
 * 3) x-1<0,x위치의 최대값의 위치로 이동, y도 마찬가지
 * 4) 입력하려는 위치에 값이 존재하면, 원래 위치로 이동해서 한칸 아래로 위치
 *     tempX + 1
 *     tempY
 * 5) 데이터 검증을 해야한다.
 *    2 * n + 2 여기에 들어있는 각각의 합이 모두 동일해야 한다.
 * |||
 * ---
 * / \
 * */
public class OddMagicSquare extends AbstractMaigicSquare {

	public OddMagicSquare() { // 생성자에 기본 3이 셋팅되도록 구현하기
		this(3);
	}

	public OddMagicSquare(int n) {
		this.init(n);
	}

	// 마방진 로직 적용
	public void make() {
		int x = 0;
		int y = max / 2; // (0,[n/2])
		super.grid[x][y] = 1; // 시작 1 ~ n*n 까지 숫자를 넣는다.

		for (int i = 2; i <= (max + 1) * (max + 1); i++) {

			// 값이 있을경우 위치를 가져갈 변수
			int tempX = x;
			int tempY = y;

			// x의 흐름
			if (x - 1 < 0) {
				x = max;
			} else {
				x--;
			}

			// y의 흐름
			if (y - 1 < 0) {
				y = max;
			} else {
				y--;
			}

			if (super.grid[x][y] != 0) {
				x = tempX + 1;
				y = tempY;
			}

			super.grid[x][y] = i;
		}
	}

	// 외부에서 만들어진 마방진을 가져가는 getter메소드
	public int[][] getMagic() {
		return grid;
	}

}

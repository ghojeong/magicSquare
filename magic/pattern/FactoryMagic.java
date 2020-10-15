package magic.pattern;

import magic.square.FourMagicSquare;
import magic.square.OddMagicSquare;
import magic.square.SixMagicSquare;
import magic.hierachy.IMagicSquare;

// 3이상의 어떤 정수가 와도 마방진을 만드는 메소드 구현가능
public class FactoryMagic {
	public static IMagicSquare imagicSquare;

	public static IMagicSquare factory(int n) {
		if (n < 3) {
			System.out.println("마방진을 만들 수 없는 숫자입니다.");
		} else if (n % 2 == 1) {
			imagicSquare = new OddMagicSquare(n);
		} else if (n % 4 == 0) {
			imagicSquare = new FourMagicSquare(n);
		} else {
			imagicSquare = new SixMagicSquare(n);
		}
		return imagicSquare;
	}
}

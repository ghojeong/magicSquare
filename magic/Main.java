package magic;

import magic.square.FourMagicSquare;
import magic.square.OddMagicSquare;
import magic.square.SixMagicSquare;
import magic.hierachy.AbstractMaigicSquare;
import magic.hierachy.IMagicSquare;
import magic.pattern.FactoryMagic;

public class Main {

	public static void main(String[] args) {

		IMagicSquare im;

		for (int i = 3; i < 10; i++) {
			im = FactoryMagic.factory(i);
			im.make();
			System.out.println("\n" + i);
			System.out.println(im.isMagicSquare());
			System.out.println(im);
		}

		// OddMagicSquare odd = new OddMagicSquare(7);
		// odd.make();
		// System.out.println(odd.isMagicSquare());
		// System.out.println(odd);

		// FourMagicSquare four = new FourMagicSquare();
		// four.make();
		// System.out.println(four.isMagicSquare());
		// System.out.println(four);

		// IMagicSquare six = new SixMagicSquare();
		// six.make();
		// System.out.println(six.isMagicSquare());
		// System.out.println(six);

		// SixMagicSquare sixTen = new SixMagicSquare(10);
		// sixTen.make();
		// System.out.println(sixTen.isMagicSquare());
		// System.out.println(sixTen);

		// AbstractMaigicSquare ams = new SixMagicSquare();
		// ams.make();
		// System.out.println(ams.isMagicSquare());
		// System.out.println(ams);
	}
}

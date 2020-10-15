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
			System.out.println(im.isCheck());
			System.out.println(im);
		}

		// OddMagicSquare odd = new OddMagicSquare(7);
		// odd.make();
		// odd.print();
		// System.out.println(odd.isCheck());

		// FourMagicSquare four = new FourMagicSquare();
		// four.make();
		// four.print();
		// System.out.println(four.isCheck());

		// SixMagicSquare six = new SixMagicSquare(10);
		// six.make();
		// six.print();
		// System.out.println(six.isCheck());

		// AbstractMaigicSquare ams = new SixMagicSquare();
		// ams.make();
		// ams.print();
		// System.out.println(ams.isCheck());

		// IMagicSquare im = new SixMagicSquare();
		// im.make();
		// im.print();
		// System.out.println(im.isCheck());
	}
}

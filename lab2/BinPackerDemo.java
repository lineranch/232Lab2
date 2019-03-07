package lab2;

import java.util.Arrays;

public class BinPackerDemo {

	public static void main(String[] args) {
		In in = new In(args[1]);
		int arr[] = in.readAllInts();
		int cap = Integer.parseInt(args[0]);
		BinPacker bins = new BinPacker(cap, arr.length);

		//bins.firstFit(arr);
		bins.bestFitDecreasing(arr);

	}

}

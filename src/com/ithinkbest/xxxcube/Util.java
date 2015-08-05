package com.ithinkbest.xxxcube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {


	public static final String[] sampleCmd = {
			// "Z21 X12 Z20 X11 Z21 X13 Z21 X12 Z23 X13 Z23 X13 Z23 X12",
			"Z21 X12 Z23 Z21 X12 X13 Z21 X13 Z21 X12 Z23 X13 Z23 X13 Z23 X12",
			"X13 X13 Z23 X13 Z23 X13 Z23 X13 X13 X13 X12 X13 Z21 X13 Z23 Z23 Z23 X13 Z21",
			"X13 X13 Z21 X12 X13 X12 Z21 X13 Z21 X12 Z23 Z23 Z21 X13 Z23 X13 Z23",
			"Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 X12 X13 X13 X13 X12 X13 Z21 X13 X13",
			"X12 X12 Z23 X13 Z23 X13 Z23 Z23 Z23 Z23 Z23 Z21 Z23 X12 Z21 X13 Z21 X13 Z21 X12",
			"X12 Z23 X13 Z23 X13 X12 X12 Z23 X12 X12 X12 Z21 X13 Z21 X13 Z23 Z21 Z21",
			"X13 X13 Z21 X13 Z21 X13 Z23 Z23 Z21 Z21 Z21 X12 Z23 X13 Z23 X13 Z23",
			"X12 Z23 X13 Z23 X12 X13 X12 X13 X12 X13 Z23 Z21 Z23 X12 Z21 X13 Z21 X13 Z21",
			"X12 Z21 X13 Z21 X13 Z21 Z23 X12 X12 Z21 X13 X13 Z23 X12 X13 X13 X13 Z23 X13 Z23",
			"X13 X13 Z21 X13 Z21 X13 Z23 Z21 Z21 X12 Z23 X12 Z23 Z21 X12 X13 Z23 X13 Z23", };

	Map<String, String> mapXyz2Chinese;
	// http://w.astro.berkeley.edu/~converse/rubiks.php?id1=basics&id2=notation
	String[][] dataXyz2Chinese = { { "X11", "右上" }, { "X12", "右翻" }, { "X13", "右下" }, { "X21", "中上" }, { "X22", "X翻" },
			{ "X23", "中下" }, { "X31", "左上" }, { "X32", "左翻" }, { "X33", "左下" },

			{ "Y11", "前順" }, { "Y12", "前翻" }, { "Y13", "前逆" }, { "Y21", "中順" }, { "Y22", "Y翻" }, { "Y23", "中逆" },
			{ "Y31", "後順" }, { "Y32", "後翻" }, { "Y33", "後逆" },

			{ "Z11", "上左" }, { "Z12", "上翻" }, { "Z13", "上右" }, { "Z21", "中左" }, { "Z22", "Z翻" }, { "Z23", "中右" },
			{ "Z31", "下左" }, { "Z32", "下翻" }, { "Z33", "下右" }

	};

	String[] cmdCn = {
			// X
			"右上", "右翻", "右下", "中上", "Ｘ翻", "中下", "左上", "左翻", "左下",
			// Y
			"前順", "前翻", "前逆", "中順", "Ｙ翻", "中逆", "後順", "後翻", "後逆",
			// Z
			"上左", "上翻", "上右", "中左", "Ｚ翻", "中右", "下左", "下翻", "下右"

	};

	int[] seqA = {
			// X
			1, 1, 1, 2, 2, 2, 3, 3, 3,
			// Y
			4, 4, 4, 5, 5, 5, 6, 6, 6,
			// Z
			7, 7, 7, 8, 8, 8, 9, 9, 9

	};
	int[] seqX = {
			// X
			1, 1, 1, 1, 1, 1, 1, 1, 1,
			// Y
			2, 2, 2, 2, 2, 2, 2, 2, 2,
			// Z
			3, 3, 3, 3, 3, 3, 3, 3, 3

	};
	int[] seqY = {
			// X
			1, 1, 1, 2, 2, 2, 3, 3, 3,
			// Y
			1, 1, 1, 2, 2, 2, 3, 3, 3,
			// Z
			1, 1, 1, 2, 2, 2, 3, 3, 3

	};
	int[] seqZ = {
			// X
			1, 2, 3, 1, 2, 3, 1, 2, 3,
			// Y
			1, 2, 3, 1, 2, 3, 1, 2, 3,
			// Z
			1, 2, 3, 1, 2, 3, 1, 2, 3

	};

	public String getCmdCn(int face, int ring, int angle) {
		int k = face * 9 + ring * 3 + angle - 1;
		return cmdCn[k];
	}

	public Util() {
		int temp, ringNum, angle;
		// System.out.printf("\n");
		for (int i = 0; i < 27; i++) {

			// System.out.printf(" %2d %s %d%d%d
			// %2d%d\n",i,cmdCn[i],seqX[i],seqY[i],seqZ[i],(seqX[i]-1)*3+seqY[i],seqZ[i]);
		}

		mapXyz2Chinese = new HashMap<>();
		for (int i = 0; i < dataXyz2Chinese.length; i++) {

			mapXyz2Chinese.put(dataXyz2Chinese[i][0], dataXyz2Chinese[i][1]);

		}
		// System.out.println(mapXyz2Chinese);
		// mapXyz2Chinese.put(key, value)
	}

	class Command {
		char face;
		int ring;
		int degree;

		public Command(String str) {
			face = str.charAt(0);
			int temp = Integer.parseInt(str.substring(1));
			ring = temp / 10;
			degree = temp - ring * 10;

		}

		@Override
		public String toString() {
			return String.format("%c%d%d", face, ring, degree);
		}

		public Command(char face, int ring, int degree) {
			super();
			this.face = face;
			this.ring = ring;
			this.degree = degree;
		}

		public char getFace() {
			return face;
		}

		public void setFace(char face) {
			this.face = face;
		}

		public int getRing() {
			return ring;
		}

		public void setRing(int ring) {
			this.ring = ring;
		}

		public int getDegree() {
			return degree;
		}

		public void setDegree(int degree) {
			this.degree = degree;
		}

	}

	public String getNormalizedCmd(String src) {
		StringBuilder sb = new StringBuilder();
		String[] items = src.split(" ");
		List<String> itemList = new ArrayList<>();
		for (int i = 0; i < items.length; i++) {
			itemList.add(items[i]);
		}
		// System.out.println(" item list is "+itemList);

		Command c1, c2;

		// Z20 X12 Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21
		// for (int i = itemList.size() - 1; i >= 1; i--) {
		for (int i = itemList.size() - 1; i >= 0; i--) {

			c1 = new Command(itemList.get(i));

			// for not completely solved cases
			if (c1.degree == 0) {
				itemList.remove(i);
				//
				// ( 1) Z23 X13 Z23 X13 Z23 X13 Z20 X13 Z21 X13 Z21 X13 Z21 X12
				// .....Z23 X13 Z23 X13 Z23 X13 X13 Z21 X13 Z21 X13 Z21 X12
				i++; // NEED TO MOVE BACK ONE STEP FOR POSSIBLE COMBINE
						//
				continue;
			}

			if (i == 0) {
				break;
			}

			c2 = new Command(itemList.get(i - 1));
			if (c1.face == c2.face && c1.ring == c2.ring) {
				int temp = c1.degree + c2.degree;
				if (temp >= 4) {
					temp = temp - 4;
				}

				// System.out.println(i + " " + c1 + " " + c2);
				itemList.remove(i);
				c2.setDegree(temp);
				if (temp == 0) {
					itemList.remove(i - 1);// more rotate in one complete circle
					i++;

				} else {
					itemList.set(i - 1, c2.toString());

				}
				// System.out.println(" ... "+itemList);

			}
			// System.out.println(c1 + " " + c2);
			// System.out.println(items[i] + " " + items[i + 1]);
		}
		for (int i = 0; i < itemList.size(); i++) {
			sb.append(itemList.get(i)).append(" ");
		}

		return sb.toString().trim();
	}

	public String getTranslatedCmd(String source, int Style) {
		// String sol001ch="[中右,右下][中右,右下][中右,右翻][中左,右下][中左,右下][中左,右翻]";
		// String sol001 = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		StringBuilder sb = new StringBuilder();

		String[] items = source.split(" ");
		for (String item : items) {
			sb.append(mapXyz2Chinese.get(item)).append(" ");
		}

		return sb.toString();
	}

	public String getBackwards(String source) {

		StringBuilder sb = new StringBuilder();
		// sb.append("XXX"+source+"XXX");

		String[] items = source.split(" ");

		for (int i = items.length - 1; i >= 0; i--) {
			// System.out.println(i+" "+items[i]);
			sb.append(items[i]).append(" ");
			//
		}

		// for (int i=(items.length-1);i==0;i--){
		// System.out.println(i+" "+items[i]);
		// sb.append(items[i]).append(" ");
		// }

		return sb.toString();
	}
}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
5
1 0 2 5 8 
2 3 4 7 9 
3 5 7 8 9 
1 2 5 4 2 
3 3 5 2 1 
*/

public class TestTwo {
	
	private static final char STARTING = 'A';

	public static void main(String args[]) throws Exception {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(in.readLine());
		int[][] array = new int[length][length];
		
		String[] strArray = null;
		
		for (int i = 0; i < length; i++) {
			strArray = in.readLine().split(" ");
			for (int j = 0; j < strArray.length; j++) {
				array[i][j] = Integer.parseInt(strArray[j]);
			}
		}
		
		calculateBasins(array);
	}
	

	
	private static void calculateBasins(int farm[][]) {
		int size = farm.length;
		Point basins[][] = new Point[size][size];
		Map<Point, Character> charTracker = new HashMap<Point, Character>();
		
		char uniqueChar = STARTING;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				
				basins[x][y] = waterFlowsTo(farm,x,y);
				
				if(!charTracker.containsKey(basins[x][y])) {
					charTracker.put(basins[x][y], uniqueChar);
					uniqueChar++;	
				}
			}
		}
		
		int[] charCount = new int[256];
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				charCount[(int)charTracker.get(basins[x][y])]++;
			}
		}
		List<Integer> counts = new ArrayList<Integer>();
		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] != 0) {
				counts.add(charCount[i]);
			}
		}
		Collections.sort(counts);
		Collections.reverse(counts);
		for (int i = 0; i < counts.size(); i++) {
			System.out.print(counts.get(i) + " ");
		}
		System.out.println();
	}
	
	
	
	private static Point waterFlowsTo(int area[][],int x, int y) {
		Point localLowPoint = new Point(x, y);
		int size = area.length;
		int leftX, leftY, rightX, rightY, topX, topY, botX, botY = 0;
		int minX, minY,minValue = 0;
		
		leftX = x;
		leftY = y - 1;
		
		rightX = x;
		rightY= y + 1;
		
		topX = x - 1;
		topY = y;
		
		botX = x + 1;
		botY = y;
		
		minX = x;
		minY = y;
		minValue = area[x][y];
		
		if (!outOfFarm(leftX, leftY, size)) {
			if (area[leftX][leftY] < minValue) {
				minX = leftX;
				minY = leftY;
				minValue = area[leftX][leftY];
			}
		}
		if (!outOfFarm(rightX, rightY, size)) {
			if (area[rightX][rightY] < minValue) {
				minX = rightX;
				minY = rightY;
				minValue = area[rightX][rightY];
			}
		}
		if (!outOfFarm(topX, topY, size)) {
			if (area[topX][topY] < minValue) {
				minX = topX;
				minY = topY;
				minValue = area[topX][topY];
			}
		}
		if (!outOfFarm(botX, botY, size)) {
			if (area[botX][botY] < minValue) {
				minX = botX;
				minY = botY;
				minValue = area[botX][botY];
			}
		}
		if(minX == x && minY == y) {
			/* Current point is the lowest */;
		} else {
			localLowPoint = waterFlowsTo(area, minX, minY);
		}
		return localLowPoint;
	}
	
	private static boolean outOfFarm(int x, int y, int size) {
		return (x < 0 || x >= size) || (y < 0 || y >= size);
	}
	
	

}
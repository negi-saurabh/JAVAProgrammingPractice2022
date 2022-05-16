package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalsTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalTriangle = new ArrayList();
		for (int i = 0; i < numRows; i++) {
			if(i!=0) {
				List<Integer> rows = pascalTriangle.get(i-1);
				List<Integer> newRows = new ArrayList<>();
				for (int j = 0; j < rows.size(); j++) {
					if(j==0) {
						newRows.add(1);
					}if (j==rows.size()-1) {
						newRows.add(1);
					}else {
						newRows.add(rows.get(j)+rows.get(j+1));
					}
				}
				pascalTriangle.add(newRows);
			}else {
				pascalTriangle.add(new ArrayList<Integer>(){
					{
					add(1);
					}
				});
			}
		}
		return pascalTriangle;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int target1 = Integer.parseInt(reader.readLine());
		generate(target1);
	}
}

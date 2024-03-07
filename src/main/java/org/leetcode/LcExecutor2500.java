package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LcExecutor2500 {

    public static void main(String args[]) {

    }
    public void deleteGreatestValue(int[][] grid) {
        //when you see a matrix, the first reaction of you need to be loop!!!!

        for (int column = 0; column < grid[0].length; column ++) {
            List<Integer> maxInEveryLine = new ArrayList<>();
            for(int line = 0; line < grid.length; line ++) {
                int[] line_data = grid[line];
                Arrays.sort(line_data);

                int line_max = line_data[line_data.length-(column + 1)];

                maxInEveryLine.add(line_max);

            }
        }


    }
}

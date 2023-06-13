package chapter2;
import java.util.*;
import java.io.*;

public class MinesweeperGame {

    static List<int[]> theList = new ArrayList<>();

    /**
     * 해당 코드로는 맥락을 파악할 수 없음, 즉 의도가 불분명함
     *
     * 1. theList에 무엇이 있는지?
     * 2. theList에 0번째 값이 어째서 중요한지?
     * 3. 값 4는 무슨 의미인지?
     * 4. 함수가 반환하는 리스트 list1을 어떻게 사용하는지?
     *
     * 문제는 코드의 함축성임, 따라서 변수를 작성할 때는 의도를 분명히 밝힐 수 있는 의미 있는 변수를 작성하자
     */
    public List<int[]>getThem() {
        List<int[]> list1 = new ArrayList<int[]>();

        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    /**
     * 위의 코드를 개선 시킨 코드
     *
     * 개선 시킨 부분은 각종 변수들의 이름임
     * 해당 이름을 통해 코드의 문맥을 쉽게 파악할 수 있음
     *
     */
    static List<int[]> gameBoard = new ArrayList<>();
    static final int FLAGGED = 4;
    static final int STATUS_VALUE = 0;

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();

        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }

        return flaggedCells;
    }

    /**
     * 위의 코드를 더욱 개선 시키면 밑에 처럼 작성할 수 있음
     * 칸을 간단한 클래스로 만들어서 isFlagged라는 명시적인 함수를 사용하여
     * 각종 상수를 감춤
     *
     */

    static class Cell {
        int[] cell;

        Cell(int[] cell) {
            this.cell = cell;
        }

        public boolean isFlagged() {
            return this.cell[STATUS_VALUE] == FLAGGED;
        }
    }

    static List<Cell> gameBoardV2 = new ArrayList<>();

    public List<Cell> getFlaggedCellsV2() {
        List<Cell> flaggedCells = new ArrayList<>();

        for (Cell cell : gameBoardV2) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }

        return flaggedCells;
    }

}

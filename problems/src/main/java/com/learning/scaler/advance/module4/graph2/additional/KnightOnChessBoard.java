package com.learning.scaler.advance.module4.graph2.additional;

import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*
*
Problem Description
    Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
    The above figure details the movements for a knight ( 8 possibilities ).
    If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
        NOTE: A knight cannot go out of the board.

Problem Constraints
    1 <= A, B <= 500

Input Format
    The first argument of input contains an integer A.
    The second argument of input contains an integer B.
    The third argument of input contains an integer C.
    The fourth argument of input contains an integer D.
    The fifth argument of input contains an integer E.
    The sixth argument of input contains an integer F.

Output Format
    If it is possible to reach the destination point, return the minimum number of moves.
    Else return -1.

Example Input
    Input 1:
         A = 8
         B = 8
         C = 1
         D = 1
         E = 8
         F = 8
    Input 2:
         A = 2
         B = 4
         C = 2
         D = 1
         E = 4
         F = 4

Example Output
    Output 1:
         6
    Output 2:
         -1

Example Explanation
    Explanation 1:
         The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
        The minimum number of moves required for this is 6.
    Explanation 2:
         It is not possible to move knight to position (4, 4) from (2, 1)

*/
public class KnightOnChessBoard {

    public static void main(String[] args) {
        KnightOnChessBoard chessBoard = new KnightOnChessBoard();

        System.out.println(chessBoard.knight(8, 8, 1, 1, 8, 8));
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A + 1][B + 1];
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(C, D, 0));
        int minStepCount = Integer.MAX_VALUE;
        int[] start = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] end = {1, -1, 1, -1, 2, 2, -2, -2};
        while (!queue.isEmpty()) {
            Triplet current = queue.poll();
            if (visited[current.i][current.j]) continue;
            if (current.i == E && current.j == F) {
                minStepCount = Math.min(minStepCount, current.steps);
            }
            visited[current.i][current.j] = true;
            // check all options and add it to queue if valid
            for (int i = 0; i < 8; i++) {
                int X = current.i + start[i], Y = current.j + end[i];
                if (isValidIndex(X, Y, A, B) && !visited[X][Y])
                    queue.add(new Triplet(X, Y, current.steps + 1));
            }
        }
        return minStepCount == Integer.MAX_VALUE ? -1 : minStepCount;
    }

    boolean isValidIndex(int i, int j, int N, int M) {
        return i > 0 && j > 0 && i <= N && j <= M;
    }
}

class Triplet {
    public int i;
    public int j;
    public int steps;

    public Triplet(int i, int j, int steps) {
        this.i = i;
        this.j = j;
        this.steps = steps;
    }
}

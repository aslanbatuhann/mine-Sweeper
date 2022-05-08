import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber;
    String[][] map;
    String[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        gameArea();

    }
    public void run() {
        int row2, col2;

        System.out.println("*************************BAŞLA*************************");
        while (game) {
            gameScreen();

            System.out.print("Seçilen satır : ");
            row2 = scan.nextInt();
            System.out.print("Seçilen sütun : ");
            col2 = scan.nextInt();

            if (checkMine(row2, col2)) {
                System.out.println("Game Over!");
                break;
            }
            board[row2][col2] = String.valueOf(checMine(row2, col2));
            if (checkWin()) {
                System.out.println("Tebrikler Oyunu Kazandınız !!!");
                break;
            }

        }
    }
    public void gameArea() {
        int randrow, randcol;
        int minePiece = (rowNumber * colNumber) / 4;
        board = new String[rowNumber][colNumber];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
        map = new String[rowNumber][colNumber];
        while (minePiece > 0) {
            randrow = rand.nextInt(rowNumber);
            randcol = rand.nextInt(colNumber);
            if (map[randrow][randcol] == null) {
                map[randrow][randcol] = "*";
                minePiece--;
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null)
                    map[i][j] = "-";
            }
        }
    }
    boolean checkMine(int x, int y) {
        return map[x][y].equals("*");
    }
    public int checMine(int rw, int cl) {
        int result = 0;
        if (map[rw][cl].equals("-")) {
            if ((cl < colNumber - 1) && (map[rw][cl + 1].equals("*"))) {
                result++;
            }
            if ((rw < rowNumber - 1) && (map[rw + 1][cl].equals("*"))) {
                result++;
            }
            if ((cl > 0) && (map[rw][cl - 1].equals("*"))) {
                result++;
            }
            if ((rw > 0) && (map[rw - 1][cl].equals("*"))) {
                result++;
            }
            if ((cl < colNumber - 1) && (rw < rowNumber - 1) && (map[rw + 1][cl + 1].equals("*"))) {
                result++;
            }
            if ((cl > 0) && (rw > 0) && (map[rw - 1][cl - 1].equals("*"))) {
                result++;
            }
            if ((rw > 0) && (cl < colNumber - 1) && (map[rw - 1][cl + 1].equals("*"))) {
                result++;
            }
            if ((cl > 0) && (rw < rowNumber - 1) && (map[rw + 1][cl - 1].equals("*"))) {
                result++;
            }
            if (board[rw][cl].equals("-")) {
                board[rw][cl] = String.valueOf(-2);
            }
        }
        return result;
    }
    public void gameScreen() {
        System.out.println("=================================");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("=================================");
    }
    boolean checkWin() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j].equals("*")) {
                    if (map[i][j].equals(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


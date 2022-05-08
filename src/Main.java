import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row,col;
        Scanner scan = new Scanner(System.in);

        System.out.println("Mayın Tarlası");
        System.out.println("Satır : ");
        row=scan.nextInt();
        System.out.println("Sütun : ");
        col=scan.nextInt();

        MineSweeper mine = new MineSweeper(row,col);

        mine.run();

    }
}




package Leetcode;


import java.util.Scanner;

public class xuanzhuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array= new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                array[i][j]=in.nextInt();
            }
        }
        int M =in.nextInt();
        for (int i=0;i<M;i++){
            xuanzhuan(array);
        }
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(array[i][j]+" ");
                if (j==N-1){
                    System.out.println();
                }
            }
        }
    }
    public static void xuanzhuan(int[][] juzhen) {
        if (juzhen == null || juzhen.length == 0 || juzhen[0].length == 0) {
            return;
        }
        int col = juzhen[0].length - 1;
        int row = juzhen.length - 1;
        int colF = col;
        int rowF = row;
        for (int r = 0; r < rowF; r++) {
            for (int c = r; c < colF; c++) {
                int x1 = r;
                int y1 = c;
                int x2 = c;
                int y2 = col - r;
                int x3 = row - r;
                int y3 = col - c;
                int x4 = row - c;
                int y4 = r;
                swap(juzhen, x1, y1, x2, y2);
                swap(juzhen, x1, y1, x3, y3);
                swap(juzhen, x1, y1, x4, y4);
            }
            rowF--;
            colF--;
        }
    }

    public static  void swap(int[][] juzhen, int x1, int y1, int x2, int y2) {
        int tmp = juzhen[x1][y1];
        juzhen[x1][y1] =juzhen[x2][y2];
        juzhen[x2][y2] = tmp;
    }
}

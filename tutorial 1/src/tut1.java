public class tut1 {
    public tut1() {
        int[][] a;
        a = new int[100][101];
        //process through each row
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 1; //makes everything equal 1 from the rows
            }
        }
        //process through each column
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j][i] = 1;
            }
        }
        //diagonal
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1; //works in column top left to bottom right
        }
        //diagonal opposite
        for (int i = a.length - 1; i > 0; i--) {
            a[i][i] = 1; //works in column top right to bottom left
        }
        //around the point x and y are the point location
        int x = 5;
        int y = 5;
        for(int i=x-1;i<x+2;i++){
            for(int j=y-1;j<y+2;j++){
                a[i][j] = 1;
            }
        }
        System.out.println(a.length);
        System.out.println(a[1].length);
    }
    public static void main(String[] args) {
        tut1 t = new tut1();
    }
}

package OCR_test;

public class OCR_Scale {
    public static int[][] scaleXDown(int[][] old, int x) {
        int[][] newA = new int[old.length][x];
        double scaleX = old[0].length / (double) x;
        for (int i = 0; i < newA.length - 1; i++) {
            for (int j = 0; j < newA[0].length - 1; j++) {
                newA[i][j] = old[i][(int) (j * scaleX)];
            }
        }
        return newA;
    }

    public static int[][] scaleYDown(int[][] old, int y) {
        int[][] newA = new int[y][old[0].length];
        double scaleY = old.length / (double) y;
        for (int i = 0; i < newA.length - 1; i++) {
            for (int j = 0; j < newA[0].length - 1; j++) {
                newA[i][j] = old[(int) (i * scaleY)][j];
            }
        }
        return newA;
    }

    public static int[][] scaleXUp(int[][] old, int x) {
        int[][] newA = new int[old.length][x];
        // code goes though small array checking big one for what value should be there
        double scaleX = old[0].length / (double) x;
        for (int i = 0; i < newA.length - 1; i++) {
            for (int j = 0; j < newA[i].length - 1; j++) {
                if ((int) (j * scaleX) < old[0].length)
                    newA[i][j] = old[i][(int) (j * scaleX)];
            }
        }
        return newA;
    }

    public static int[][] scaleYUp(int[][] old, int y) {
        int[][] newA = new int[y][old[0].length];
        // code goes though small array checking big one for what value should be there
        double scaleY = old.length / (double) y;
        // System.out.println(y+" "+scaleY+" old"+old[0].length);
        for (int i = 0; i < newA.length - 1; i++) {
            for (int j = 0; j < old[(int) (i * scaleY)].length; j++) {
                if ((int) (i * scaleY) < old.length)
                    newA[i][j] = old[(int) (i * scaleY)][j];
            }
        }
        return newA;
    }
}

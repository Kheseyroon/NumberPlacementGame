public class NumberPlacementGame {
    static int c=0;
    static int N = 5; // length
    static String[][] tile = new String[N][N];
    static int[] xPositions = {0, 3, 0, -3, 2, 2, -2, -2};
    static int[] yPositions = {3, 0, -3, 0, 2, -2, 2, -2};
static int printCount= 0;
    public static void main(String[] args) {
        double start =  System.currentTimeMillis();
        int startX = (int) ((Math.random() * N));
        int startY = (int) ((Math.random() * N));
        createField();
        tile[startY][startX] = "00";
        go(startX, startY,1);
        System.out.println("visited path count: " + c);
        double finish =  System.currentTimeMillis();
        System.out.println("calisma suresi > "+(finish-start)/1000);
    }

    public static void createField() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++)
                tile[y][x] = null;
    }

    public static void printArea() {
    printCount++;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++)
                System.out.print(tile[y][x] + " ");
            System.out.println();
        }
        System.out.println("Possiblity :"+printCount);
    }
    public static boolean check(int x,int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && tile[y][x] == null);
    }


    public static boolean go(int x, int y, int count) {
        c++;
        int futureX,futureY;

        if (count == N * N) {
            printArea();
            tile[y][x]=null;
        }

        for (int i = 0; i < 8; i++) {
            futureX = x + xPositions[i];
            futureY = y + yPositions[i];
            if (check(futureX,futureY)) {
                tile[futureY][futureX] = (count >= 10) ? String.valueOf(count) : "0" + count;
                if (go(futureX, futureY, count + 1))
                    return true;
                else
                    tile[futureY][futureX] = null;
            }
        }
        return false;
    }
}
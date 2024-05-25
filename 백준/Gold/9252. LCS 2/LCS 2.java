import java.util.Scanner;
import java.lang.String;

public class Main {
    private static void getStr(int[][] arr, String str, int x, int y) {

    }
    public static void main(String[] args) {
        int [][]dp;

        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();

        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int x = s1.length();
        int y = s2.length();
        String answer = "";

        while (x != 0 && y != 0) {
            if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
                answer = s1.charAt(x - 1) + answer;
                x--;
                y--;
            }
            else if (dp[x - 1][y] > dp[x][y - 1])
                x--;
            else
                y--;
        }

        System.out.println(dp[s1.length()][s2.length()] + "\n" + answer);
        s.close();
    }
}
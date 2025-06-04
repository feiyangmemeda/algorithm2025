package leetcode.day4;

/**
 * @author feiyang.duan
 * @date 2025/4/24
 * @description z字变换
 */
public class Z {

    public static void main(String[] args) {
        String a = convert("AB", 1);
        System.out.println(a);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] table = new char[numRows][s.length()];
        char[] charArray = s.toCharArray();
        int row = 0;
        int col = 0;
        loop1:
        for (int i = 0; i < charArray.length; i++) {
            while (row < numRows) {
                table[row][col] = charArray[i];
                i++;
                row++;
                if (i == charArray.length) {
                    break loop1;
                }
            }
            row--;
            if (row == numRows - 1) {
                row--;
                while (row >= 0) {
                    col++;
                    table[row][col] = charArray[i];
                    i++;
                    row--;
                    if (i == charArray.length) {
                        break loop1;
                    }
                }
                i--;
                row = 1;
            }
        }


        // 遍历二维数组
        StringBuilder sb = new StringBuilder();
        for (char[] chars : table) {
            for (char aChar : chars) {
                if (aChar != '\u0000') {
                    sb.append(aChar);
                }
            }
        }
        return sb.toString();

    }
}

import java.util.Arrays;

/**
 * @author feiyang.duan
 * @date 2025/6/3
 * @description 类的描述信息
 */
public class TestMain {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ints = Arrays.copyOfRange(array, 3, 5);
        System.out.println(Arrays.toString(ints));
    }
}

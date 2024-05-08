import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @Author 王骞
 * @Date 2023/7/28 17:58
 * @Version 1.0
 */
@Slf4j
public class StudentTest {
    public static void main(String[] args) {

        int sum,multiplier1,multiplier2;
        Scanner scanner = new Scanner(System.in);
        do {
            multiplier1 = Integer.parseInt(scanner.next());
        } while (multiplier1<=0);
        do {
            multiplier2 = Integer.parseInt(scanner.next());
        } while (multiplier2 <0);
        sum=multiplier1*multiplier2;
        log.info(String.valueOf(sum));
    }

}

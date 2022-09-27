package Examples.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtils {

    public InputUtils() {
    }

    public static String getString(String prompt) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        boolean flag = true;
        while (flag){
            System.out.print(prompt);
            try {
                str = reader.readLine();
                if (!"".equals(str)){
                    flag = false;
                }else {
                    System.out.println("输入的内容不允许为空！");
                }
            } catch (IOException e) {
                System.out.println("输入的内容不允许为空！");
            }
        }
        return str;
    }

    public static int getInt(String prompt) {

        int num = 0;
        boolean flag = true;

        while (flag) {

            Scanner INPUT = new Scanner(System.in);
            System.out.print(prompt);
            if (INPUT.hasNext("\\d+")) {

                num = Integer.parseInt(INPUT.next("\\d+"));
                flag = false;
            } else {
                System.out.println("输入的内容不是数字！");
            }
        }

        return num;
    }

    public static int getIntBuf(String prompt) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean flag = true;

        while (flag) {

            System.out.print(prompt);
            String str = null;

            try {
                str = reader.readLine();
                if (str.matches("\\d+")) {

                    num = Integer.parseInt(str);
                    flag = false;
                } else {
                    System.out.println("输入的内容不是数字！");
                }
            } catch (IOException e) {
                System.out.println("输入的内容不是数字！");
            }
        }

        return num;
    }
}

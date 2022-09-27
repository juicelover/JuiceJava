package Examples;

import java.io.File;
import java.io.IOException;

public class JavaFileDemo {
    public static void main(String[] args) {
        File file = new File("D:"
                + File.separator + "program"
                + File.separator + "资料"
                + File.separator + "短信通知"
                + File.separator + "首页_slices"
                + File.separator + "mipmap-hdpi"
                + File.separator + "test.txt");

        if (file.exists()) {

            System.out.println("文件删除：" + file.delete());
        } else {

            try {

                if (!file.getParentFile().exists()) {
                    System.out.println("文件夹创建：" + file.getParentFile().mkdirs());
                }
                System.out.println("文件创建" + file.createNewFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

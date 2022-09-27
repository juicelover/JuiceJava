package Examples;

import java.io.File;
import java.io.IOException;

public class JavaFileDemo {
    public static void main(String[] args) {
        File file = new File("D:"
                + File.separator + "program"
                + File.separator + "����"
                + File.separator + "����֪ͨ"
                + File.separator + "��ҳ_slices"
                + File.separator + "mipmap-hdpi"
                + File.separator + "test.txt");

        if (file.exists()) {

            System.out.println("�ļ�ɾ����" + file.delete());
        } else {

            try {

                if (!file.getParentFile().exists()) {
                    System.out.println("�ļ��д�����" + file.getParentFile().mkdirs());
                }
                System.out.println("�ļ�����" + file.createNewFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

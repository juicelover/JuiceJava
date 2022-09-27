package Examples.util;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private File srcFile;//Դ�ļ�·��
    private File desFile;//Ŀ���ļ�·��

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public boolean copy() throws Exception {//�ļ���������

        if (!this.srcFile.exists()) {//Դ�ļ��������
            System.out.println("������Դ�ļ�������");
            return false;
        }

        if (!this.desFile.getParentFile().exists()) {
            this.desFile.getParentFile().mkdirs();//������Ŀ¼
        }

        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(this.srcFile);
            outputStream = new FileOutputStream(this.desFile);
//            int len = 0;
//            while ((len = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, len);
//            }
            inputStream.transferTo(outputStream);
            return true;
        } catch (IOException e) {

            throw e;
        } finally {
            if (null != inputStream) {

                inputStream.close();
            }
            if (null != outputStream) {

                outputStream.close();
            }
        }
    }

    public static String load(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            if (scanner.hasNext()) {
                return scanner.next();
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (null != scanner) {

                scanner.close();
            }
        }
        return null;
    }

    public static boolean append(File file, String content) {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(file, true));
            out.print(content);
            return true;
        } catch (FileNotFoundException e) {

        } finally {
            if (null != out) {
                out.close();
            }
        }
        return false;
    }
}

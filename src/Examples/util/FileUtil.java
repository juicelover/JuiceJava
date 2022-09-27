package Examples.util;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private File srcFile;//源文件路径
    private File desFile;//目标文件路径

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public boolean copy() throws Exception {//文件拷贝处理

        if (!this.srcFile.exists()) {//源文件必须存在
            System.out.println("拷贝的源文件不存在");
            return false;
        }

        if (!this.desFile.getParentFile().exists()) {
            this.desFile.getParentFile().mkdirs();//创建父目录
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

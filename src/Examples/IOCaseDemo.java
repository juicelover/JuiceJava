package Examples;

import Examples.factory.Factory;
import Examples.service.IFileService;

import java.io.File;
import java.util.Arrays;

public class IOCaseDemo {
    static {

        File file = new File(Constants.TEST_JAVA_PATH);

        if (!file.exists()) {

            file.mkdirs();
        }
    }

    public static void main(String[] args) {
//        INumberService numberService = Factory.getInstance();
//        int[] result = numberService.stat(5);
//        System.out.println("最大值：" + result[0] + ",最小值：" + result[1]);

//        IFileService fileService = Factory.getFileInstance();
//        fileService.save();

//        new Menu();

//        System.out.println(Arrays.toString(Factory.getStudentInstance().getData()));
        System.out.println(Arrays.toString(Factory.getInstance().stat()));
    }
}

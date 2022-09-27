package Examples;

import Examples.factory.Factory;
import Examples.service.IStringService;
import Examples.service.IStudentService;
import Examples.util.InputUtils;

import java.util.Arrays;

public class Menu {
    private IStringService stringService;

    public Menu() {
        this.stringService = Factory.getStringInstance();
        choose();
    }

    public void choose() {
        this.show();
        String choose = InputUtils.getString("请进行选择：");
        switch (choose) {
            case "1":

                String str = InputUtils.getString("请输入要追加的数据：");
//                this.stringService.append(str);
                IStudentService service = Factory.getStudentInstance();
                service.append(str);
                choose();
                break;
            case "2":

                IStudentService studentService = Factory.getStudentInstance();
//                String[] result = this.stringService.reverse();
                System.out.println(Arrays.toString(studentService.getData()));
                choose();
                break;
            case "0":
                System.out.println("下次再见，拜拜");
                System.exit(1);
                break;
            default:
                System.out.println("您输入了非法的选项，无法进行处理，请确认后再次执行程序！");
                choose();
        }
    }

    public void show() {

        System.out.println("【1】追加字符串数据\n");
        System.out.println("【2】显示所有的学生数据\n");
        System.out.println("【0】结束程序执行\n");
    }
}

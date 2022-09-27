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
        String choose = InputUtils.getString("�����ѡ��");
        switch (choose) {
            case "1":

                String str = InputUtils.getString("������Ҫ׷�ӵ����ݣ�");
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
                System.out.println("�´��ټ����ݰ�");
                System.exit(1);
                break;
            default:
                System.out.println("�������˷Ƿ���ѡ��޷����д�����ȷ�Ϻ��ٴ�ִ�г���");
                choose();
        }
    }

    public void show() {

        System.out.println("��1��׷���ַ�������\n");
        System.out.println("��2����ʾ���е�ѧ������\n");
        System.out.println("��0����������ִ��\n");
    }
}

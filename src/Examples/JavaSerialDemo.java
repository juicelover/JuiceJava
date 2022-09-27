package Examples;

import java.io.*;

public class JavaSerialDemo {

    public static void main(String[] args) {

    }

    /**
     * ����洢
     *
     * @param obj ��Ҫ�洢�Ķ���
     * @throws IOException �쳣�׳�
     */
    public static void saveObject(Object obj) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.TEST_FILE_PATH));
        oos.writeObject(obj);
        oos.close();
    }

    public static Object loadObject() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.TEST_FILE_PATH));
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}

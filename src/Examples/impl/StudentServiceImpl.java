package Examples.impl;

import Examples.Bean.Student;
import Examples.Constants;
import Examples.service.IStudentService;
import Examples.util.FileUtil;

import java.io.File;
import java.util.Arrays;

public class StudentServiceImpl implements IStudentService {

    private static final File SAVE_FILE = new File(Constants.TEST_JAVA_PATH + "student.txt");
    private String content;
    private Student[] students;

    public StudentServiceImpl() {
        this.content = FileUtil.load(SAVE_FILE);
        this.handle();
    }

    public StudentServiceImpl(String content) {
        this.content = content;
        this.handle();
    }

    @Override
    public Student[] getData() {

        Arrays.sort(this.students);
        return this.students;
    }

    @Override
    public void append(String str) {
        if (str.startsWith("|")) {
            str = str.substring(1);
        }
        if (!str.endsWith("|")) {
            str += "|";
        }
        FileUtil.append(SAVE_FILE, str);
    }

    private void handle() {
        if (null == this.content || "".equals(this.content)) {
            return;
        }
        String[] result = this.content.split("\\|");
        this.students = new Student[result.length];
        for (int i = 0; i < result.length; i++) {

            String[] temp = result[i].split(":");
            this.students[i] = new Student(temp[0], Double.parseDouble(temp[1]));
        }
    }
}

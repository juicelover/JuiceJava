package Examples.impl;

import Examples.Constants;
import Examples.service.IFileService;
import Examples.util.InputUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileServiceImpl implements IFileService {

    private String name;
    private String content;

    public FileServiceImpl() {
        this.name = InputUtils.getString("请输入保存文件名称：");
        this.content = InputUtils.getString("请输入保存文件内容：");
    }

    @Override
    public boolean save() {
        File file = new File(Constants.TEST_JAVA_PATH + this.name);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(file));
            writer.print(this.content);
        } catch (FileNotFoundException e) {
            return false;
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
        return true;
    }
}

package Examples.factory;

import Examples.impl.FileServiceImpl;
import Examples.impl.NumberServiceImpl;
import Examples.impl.StringServiceImpl;
import Examples.impl.StudentServiceImpl;
import Examples.service.IFileService;
import Examples.service.INumberService;
import Examples.service.IStringService;
import Examples.service.IStudentService;

public class Factory {

    private Factory() {
    }

    public static INumberService getInstance() {
        return new NumberServiceImpl();

    }

    public static IFileService getFileInstance() {
        return new FileServiceImpl();
    }

    public static IStringService getStringInstance() {
        return new StringServiceImpl();
    }

    public static IStudentService getStudentInstance() {
        return new StudentServiceImpl();
    }
}

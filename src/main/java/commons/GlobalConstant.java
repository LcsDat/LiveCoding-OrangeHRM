package commons;

import java.io.File;

public class GlobalConstant {
    public static final String LOCAL_URL = "http://datautomate.testing:90/orangehrm";
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 5;
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_PATH = System.getProperty("user.dir") + File.separator + "uploadFiles";
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String SCREENSHOT_PATH = RELATIVE_PROJECT_PATH + File.separator + "screenshots";
    public static final String ADMIN_USERNAME = "hideyashy";
    public static final String ADMIN_PASSWORD = "#Onimusha00";

}

package commons;

import java.io.File;

public class GlobalConstant {
    public static final String URL = "http://datautomate.testing:90/orangehrm";
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 5;
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_PATH = System.getProperty("user.dir") + File.separator + "uploadFiles";

}

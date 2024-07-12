package interfaces;

public class UserManagementPageUI {
    public static final String ADD_BUTTON = "xpath=//button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON = "xpath=//button[@type='submit']";

    public static final String  USER_ROLE_DROPDOWN = "xpath=//label[text()='User Role']/parent::div/following-sibling::div";
    public static final String  STATUS_DROPDOWN = "xpath=//label[text()='Status']/parent::div/following-sibling::div";
    public static final String  USER_ROLE_OPTION = "xpath=//div[@role='option']/span";
    public static final String  STATUS_OPTION = "xpath=//div[@role='option']/span";

    public static final String EMPLOYEE_NAME_NOOPTION = "xpath=//div[text()='No Records Found']";
    public static final String EMPLOYEE_NAME_OPTION = "xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//span[1]";
    public static final String EMPLOYEE_NAME_TEXTBOX = "xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";

    public static final String  USERNAME_TEXTBOX = "xpath=//label[text()='Username']/parent::div/following-sibling::div//input";
    public static final String  PASSWORD_TEXTBOX = "xpath=//label[text()='Password']/parent::div/following-sibling::div//input";
    public static final String  CONFIRM_PASSWORD_TEXTBOX = "xpath=//label[text()='Confirm Password']/parent::div/following-sibling::div//input";

    public static final String EMPLOYEE_NAME_ERROR_LABEL ="xpath=//label[text()='Employee Name']/parent::div/following-sibling::span";
    public static final String USER_ROLE_ERROR_LABEL ="xpath=//label[text()='User Role']/parent::div/following-sibling::span";
    public static final String STATUS_ERROR_LABEL ="xpath=//label[text()='Status']/parent::div/following-sibling::span";
    public static final String USERNAME_ERROR_LABEL ="xpath=//label[text()='Username']/parent::div/following-sibling::span";
    public static final String PASSWORD_ERROR_LABEL ="xpath=//label[text()='Password']/parent::div/following-sibling::span";
    public static final String CONFIRM_PASSWORD_ERROR_LABEL ="xpath=//label[text()='Confirm Password']/parent::div/following-sibling::span";
}

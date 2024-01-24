package interfaces;

public class AddEmployeePageUI {
    public static final String SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";
    public static final String FIRST_NAME_REQUIRED_ERROR_MESSAGE= "xpath=//input[@placeholder='First Name']/parent::div/following-sibling::span";
    public static final String LAST_NAME_REQUIRED_ERROR_MESSAGE= "xpath=//input[@placeholder='Last Name']/parent::div/following-sibling::span";
    public static final String FIRST_NAME_CHARACTER_ERROR_MESSAGE= "xpath=//input[@placeholder='Last Name']/parent::div/following-sibling::span";
    public static final String LAST_NAME_CHARACTER_ERROR_MESSAGE= "xpath=//input[@placeholder='Last Name']/parent::div/following-sibling::span";
    public static final String ID_ERROR_MESSAGE= "xpath=//span[text()='Should not exceed 10 characters']";

    public static final String FIRST_NAME_TEXTBOX= "xpath=//input[@placeholder='First Name']";
    public static final String LAST_NAME_TEXTBOX= "xpath=//input[@placeholder='Last Name']";
    public static final String ID_TEXTBOX= "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";

}

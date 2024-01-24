package interfaces;

public class PersonalDetailsPageUI {
    public static final String PERSONAL_DETAILS_HEADER = "xpath=//h6[text()='Personal Details']";
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String ICON_LOADING = "CSS=div.oxd-loading-spinner";
    public static final String EMPLOYEE_LIST_LINK = "xpath=//a[text()='Employee List']/parent::li";
}

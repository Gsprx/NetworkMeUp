package com.example.networkmeup.view.EditAccountEmployerTest;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployerPresenter;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployerPresenter;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployerView;

public class EditAccountEmployerViewStub implements EditAccountEmployerView {
    private EditAccountEmployerPresenter presenter; // Presenter instance associated with this view stub
    private String tokenErrorMessage; // Stores the error message related to the user token
    private String lastTokenPassed; // Stores the last token passed
    private Employer currEmployer;
    private String companynameField; // Simulated input field for company name
    private String sectorField; // Simulated input field for sector
    private String emailField; // Simulated input field for email address
    private String phoneField; // Simulated input field for phone number
    private String passwordField; // Simulated input field for password

    private String tinField; // Simulated input field for Tax Identification Number (TIN)
    private String  showErrorMessageMsg; // Message to display for an error scenario
    private String showErrorMessageTitle; // Title to display for an error scenario
    private String  successfullyFinishActivityMessage; // Message to display for a successful activity completion

    /**
     * Default constructor to initialize the SignUpEmployerViewStub.
     */
    public EditAccountEmployerViewStub(){
    }

    public void setPresenter(EditAccountEmployerPresenter presenter){
        this.presenter = presenter;
    }

    public EditAccountEmployerPresenter getPresenter(){
        return this.presenter;
    }

    /**
     * Retrieves the recorded token error message.
     *
     * @return The token error message stored in the stub.
     */
    public String getTokenErrorMessage() {
        return tokenErrorMessage;
    }

    /**
     * Retrieves the last token passed.
     *
     * @return The last token passed.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Retrieves the company name information entered.
     * @return String object representing the entered company name
     * @throws RuntimeException when an invalid email format is detected
     */
    @Override
    public String getCompanyName() throws RuntimeException {
        return new String(companynameField);
    }

    /**
     * Retrieves the sector information entered.
     * @return String object representing the entered sector
     * @throws RuntimeException when an invalid email format is detected
     */
    @Override
    public String getSector() throws RuntimeException {
        return new String(sectorField);
    }

    /**
     * Retrieves the email information entered.
     * @return Email object representing the entered email
     * @throws RuntimeException when an invalid email format is detected
     */
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    /**
     * Retrieves the password information entered.
     * @return Password object representing the entered password
     * @throws RuntimeException when an invalid password format is detected
     */
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(passwordField);
    }

    /**
     * Retrieves the phone number information entered.
     * @return Phone object representing the entered phone number
     * @throws RuntimeException when an invalid phone number format is detected
     */
    @Override
    public Phone getPhoneNumber() throws RuntimeException {
        return new Phone(phoneField);
    }

    /**
     * Retrieves the TIN information entered.
     * @return TIN object representing the entered Tax Identification Number
     * @throws RuntimeException when an invalid TIN format is detected
     */
    @Override
    public TIN getTIN() throws RuntimeException {
        return new TIN(tinField);
    }

    public Employer getCurrEmployer(){
        EmployerDAO employerDAO = new EmployerDAOMemory();
        currEmployer = employerDAO.getByEmail(getEmail());
        return this.currEmployer;
    }

    /**
     * Sets the value for the company name field.
     * @param companyNameField Simulated input for email address
     */
    public void setCompanyNameField(String companyNameField) {
        this.companynameField = companyNameField;
    }

    /**
     * Sets the value for the sector field.
     * @param sectorField Simulated input for email address
     */
    public void setSectorField(String sectorField) {
        this.sectorField = sectorField;
    }

    /**
     * Sets the value for the email field.
     * @param emailField Simulated input for email address
     */
    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    /**
     * Sets the value for the phone field.
     * @param phoneField Simulated input for phone number
     */
    public void setPhoneField(String phoneField) {
        this.phoneField = phoneField;
    }

    /**
     * Sets the value for the password field.
     * @param passwordField Simulated input for password
     */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Sets the value for the TIN field.
     * @param TinField Simulated input for Tax Identification Number
     */
    public void setTinField(String TinField) {
        this.tinField = TinField;
    }

    /**
     * Displays an error message on the simulated user interface.
     * @param title Title of the error message
     * @param message Content of the error message
     */
    @Override
    public void showErrorMessage(String title, String message) {
        this.showErrorMessageTitle =title;
        this.showErrorMessageMsg = message;
    }

    /**
     * Displays a success message on the simulated user interface.
     * @param message Content of the success message
     */
    @Override
    public void successfullyFinishActivity(String message) {
        this.successfullyFinishActivityMessage = message;
    }

    /**
     * Retrieves the error message to be displayed.
     * @return Error message content
     */
    public String getShowErrorMessageMsg() {
        return showErrorMessageMsg;
    }

    /**
     * Retrieves the error message title to be displayed.
     * @return Error message title
     */
    public String getShowErrorMessageTitle() {
        return showErrorMessageTitle;
    }

    /**
     * Retrieves the success message to be displayed upon completion.
     * @return Success message content
     */
    public String getSuccessfullyFinishActivityMessage() {
        return successfullyFinishActivityMessage;
    }
}

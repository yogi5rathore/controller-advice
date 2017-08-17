/**
* Copyright © Altimetrik 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of Altimetrik. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms and conditions
* entered into with Altimetrik.
*
* Id: CHPErrorConstants.java,v 1.1
*
* Date Author Changes
* 3 Dec, 2015, 11:55:09 AM dkorah Created
*/
package com.altimetrik.chp.healthcare.error;

import org.springframework.http.HttpStatus;

/**
 * The Interface CHPErrorConstants.
 */
public enum CHPErrorEnum {
	
	/** The fatal error. */
	FATAL_ERROR(10, HttpStatus.INTERNAL_SERVER_ERROR, "Fatal"),
	
	/** The validation error. */
	VALIDATION_ERROR(11, HttpStatus.BAD_REQUEST),
	
	/** The Participant not found. */
	PARTICIPANT_NOT_FOUND(12, HttpStatus.BAD_REQUEST, "Patient not found"),
	
	/** The duplicate program name. */
	DUPLICATE_PROGRAM_NAME(13, HttpStatus.BAD_REQUEST, "Another program with the same name exists. Please choose another name"),
	
	/** The invalid participant contact mode. */
	INVALID_PARTICIPANT_CONTACT_MODE(14, HttpStatus.BAD_REQUEST, "Invalid Contact mode"),
	
	/** The invalid start date and end date. */
	INVALID_START_DATE_AND_END_DATE(15, HttpStatus.BAD_REQUEST, "Invalid Start date and End date"),
	
	/** The program not found. */
	PROGRAM_NOT_FOUND(16, HttpStatus.BAD_REQUEST, "No programs found"),
	
	/** The invlid otp. */
	INVLID_OTP(17, HttpStatus.BAD_REQUEST, "Invalid Code, Please enter the correct code."),
	
	/** The duplicate participant emailid. */
	DUPLICATE_PARTICIPANT_EMAILID(18, HttpStatus.BAD_REQUEST, "Email ID is already registered, please login using your email ID"),
	
	/** The duplicate participant mobilenum. */
	DUPLICATE_PARTICIPANT_MOBILENUM(19, HttpStatus.BAD_REQUEST, "Mobile number is already registered, please login using your mobile number"),
	
	/** The program invition not found. */
	PROGRAM_INVITION_NOT_FOUND(20, HttpStatus.BAD_REQUEST, "Program invitation not found"),
	
	/** The user details not found. */
	USER_DETAILS_NOT_FOUND(21, HttpStatus.BAD_REQUEST, "User details not found"),
	
	/** The staff not found. */
	STAFF_NOT_FOUND(22, HttpStatus.BAD_REQUEST, "Staff not Found"),
	
	/** The json parse error. */
	JSON_PARSE_ERROR(23, HttpStatus.BAD_REQUEST, "Unable to parse JSON"), 
	
	/** The multiple users found. */
	MULTIPLE_USERS_FOUND(24, HttpStatus.INTERNAL_SERVER_ERROR, "Mutiple Users found"),
	
	/** The medication not found. */
	MEDICATION_NOT_FOUND(25, HttpStatus.BAD_REQUEST, "Medication not found"),
	
	/** The program enrolment expired. */
	PROGRAM_ENROLMENT_EXPIRED(26, HttpStatus.BAD_REQUEST, "Program Enrolment Date Expired!"),
	
	/** The duplicate staff emailid. */
	DUPLICATE_STAFF_EMAILID(27, HttpStatus.BAD_REQUEST, "Email ID is already registered, please login Using your email ID"),
	
	/** The duplicate staff mobilenum. */
	DUPLICATE_STAFF_MOBILENUM(28, HttpStatus.BAD_REQUEST, "Mobile number is already registered, please login Using your mobile number"),
	
	/** The program participant staff exist. */
	PROGRAM_PARTICIPANT_STAFF_EXIST(29, HttpStatus.BAD_REQUEST, "Patient already enrolled for this program by this staff"),
	
	/** The program participant exist. */
	PROGRAM_PARTICIPANT_EXIST(30, HttpStatus.BAD_REQUEST, "Patient already enrolled for this program"),
	
	/** The staff not part of this program. */
	STAFF_NOT_PART_OF_THIS_PROGRAM(31, HttpStatus.BAD_REQUEST, "Physician is not part of this program"),
	
	/** The invalid status code. */
	INVALID_STATUS_CODE(32, HttpStatus.BAD_REQUEST, "Invalid status code"),
	
	STAFF_APPROVAL_EMAIL_ID_BLANK(33, HttpStatus.BAD_REQUEST, "Email Id is empty"),
	
	STAFF_APPROVAL_INVALID_EMAIL_ID(34, HttpStatus.BAD_REQUEST, "Invalid Email Id"),
	
	MEDICATION_DRUG_NAME_EXIST(35, HttpStatus.BAD_REQUEST, "Drug name already exist"),
	
	INVALID_VITAL_TYPE(36, HttpStatus.BAD_REQUEST, "Invalid Vital Type"),
	
	INVALID_MONITORING_TYPE(37, HttpStatus.BAD_REQUEST, "Invalid Monitoring Type"),
	
	INVALID_VITAL_VALUE(38, HttpStatus.BAD_REQUEST, "Invalid Vital Value"),
	
	INVALID_VITAL_DATE(39, HttpStatus.BAD_REQUEST, "Invalid Vital Date"),
	
	INVALID_CCDA_FORM(40, HttpStatus.BAD_REQUEST, "Invalid C-CDA Form"),
	
	CCDA_DATA_EXIST(41, HttpStatus.BAD_REQUEST, "For this patient C-CDA data already exist!!"),
	
	INVALID_DOB(42, HttpStatus.BAD_REQUEST, "Invalid date of birth"),
	
	INVALID_EMAILID(43, HttpStatus.BAD_REQUEST, "This email Id is not registered"),
	
	EXPIRED_OTP(44,HttpStatus.BAD_REQUEST, "The Verfication Password has expired, Please regenerate new one."),
	
	MEDICATION_DOSAGE_EXIST(45, HttpStatus.BAD_REQUEST, "Drug dosage already exists"),

	OTP_VERIFICATION_DONE(46, HttpStatus.BAD_REQUEST, "Account successfully verified. Click Cancel to Login."),
	
	MIN_MAX_AGE_GENDER_REQUIRED(47, HttpStatus.BAD_REQUEST, "Min Age, Max Age, Gender cannot be empty"),
	
	INVALID_MIN_MAX_AGE(48, HttpStatus.BAD_REQUEST, "Min Age, Max Age should be between 0 to 999. Min Age cannot be greater than Max Age"),
	
	INVALID_GENDER(49, HttpStatus.BAD_REQUEST, "Gender should be either Male, Female or Both"),
	
	REG_OTP_EXPIRED(50, HttpStatus.BAD_REQUEST, "OTP code has been expired! Please click on link  'click here to resend OTP'"),
	
	SECURE_CHAT_ERROR(51, HttpStatus.BAD_REQUEST, "You cannot chat with this user, this user not registered for chat.")	,
	
	INVALID_AUTH_PROVIDER(52, HttpStatus.BAD_REQUEST, "Invalid Auth Provider"),
	
	INVALID_NEXT_OF_KIN_INVITATION(53, HttpStatus.BAD_REQUEST, "First Name, Last Name, Relationship, Email cannot be empty"),
	
	NEXT_OF_KIN_INVITATION_EXIST(54, HttpStatus.BAD_REQUEST, "Next of Kin already invited"),
	
	EMAIL_ALREADY_REGISTERED(55, HttpStatus.BAD_REQUEST, "Email ID is already registered, please try another Email"),
	
	INVITATION_NOT_FOUND(56, HttpStatus.BAD_REQUEST, "Invitation not found"),
	
	NEXT_OF_KIN_NOT_FOUND(57, HttpStatus.BAD_REQUEST, "Next of Kin not found"),
	
	NEXT_OF_KIN_EXIST(58, HttpStatus.BAD_REQUEST, "Next of Kin already registered"),
	
	SYMPTOM_ASSESSMENT_ANSWER_ALL(59, HttpStatus.BAD_REQUEST, "Please answer all the symptoms"),
	
	MORE_THAN_ONE_PARTICIPANT_AVAILABLE(60, HttpStatus.BAD_REQUEST, "More than one patient is available with the same details."),
	
	INVALID_PASSCODE(61, HttpStatus.BAD_REQUEST, "Incorrect pin. Please try again."),
	
	INVALID_GRANT_TYPE(62, HttpStatus.BAD_REQUEST, "Invalid Grant Type."),
	
	INVALID_REFRESH_TOKEN(63, HttpStatus.BAD_REQUEST, "Invalid Refresh Token."),
	
	TOKEN_GENERATION_FAILED(64, HttpStatus.BAD_REQUEST, "Token Generation failed."),
	
	AUTHENTICATION_FAILED(65, HttpStatus.BAD_REQUEST, "Enter the Correct Email id and Password."),
	
	PROGRAM_DELETION_NOT_ALLOWED_PARTICIPANT_EXIST(66, HttpStatus.BAD_REQUEST, "Program deletion not allowed, patient(s) exist"),

	ADMIN_SETTINGS_SAVE_FAILED(67, HttpStatus.BAD_REQUEST, "Save Settings Failed."),
	
	ADMIN_SETTINGS_SAVE_INVALID_INPUT(68, HttpStatus.BAD_REQUEST, "Invalid Input."),
	
	ADMIN_FACILITY_STATUS_UPDATE_INVALID_CURRENT_STATUS(69, HttpStatus.BAD_REQUEST, "Invalid Current Client Status"),
	
	ADMIN_FACILITY_INVALID_CLIENT(70, HttpStatus.BAD_REQUEST, "Invalid Client"),
	
	CARE_PLAN_NO_LONGER_ACTIVE(71, HttpStatus.BAD_REQUEST, "This care plan is no longer active. Please contact your care team if you have any questions"),
    
	DUPLICATE_CLIENT_ADMIN(72, HttpStatus.BAD_REQUEST, "Duplicate client admin details found"),
	
	FACILITY_EXIST(73, HttpStatus.BAD_REQUEST, "Facility already exist"),
	
	VIEW_FACILITY_FAILED(74, HttpStatus.BAD_REQUEST, "View facility details error"),
	
	MANDATORY_MODULES_NOT_SELECTED(75, HttpStatus.BAD_REQUEST, "Please select all the mandatory modules"),
	
	ADMIN_ROLE_INVALID_ROLE_ID(76, HttpStatus.BAD_REQUEST, "Invalid Role Id"),
	
	ADMIN_ROLE_INVALID_ROLE(77, HttpStatus.BAD_REQUEST, "Invalid Role"),
	
	ADMIN_ROLE_VIEW_ROLE_PRIVILEGE_FAILED(78, HttpStatus.BAD_REQUEST, "View Role and Privileges Failed"), 
	
	ADMIN_ROLE_SYSTEM_ROLE_CANNOT_EDIT(79, HttpStatus.BAD_REQUEST, "System Role Cannot be editable"),
	
	ROLE_AND_USER_MAPPING_EXIST(80, HttpStatus.BAD_REQUEST, "You are about to remove a role assigned to existing users"),
	
	ROLE_EXIST(81, HttpStatus.BAD_REQUEST, "Role name already exists"),
	
	SYSTEM_ROLE_CANNOT_REMOVE(82, HttpStatus.BAD_REQUEST, "System Role cannot be removed"),
	
	OUTREACH_SELECTION_MANDATORY(83, HttpStatus.BAD_REQUEST, "Outreach selection is mandatory"),
	
	INTERVENTION_SELECTION_MANDATORY(84, HttpStatus.BAD_REQUEST, "At least one intervention should be selected."),
	
	OUTCOME_SELECTION_MANDATORY(85, HttpStatus.BAD_REQUEST, "Outcome selection is mandatory."),
	
	NOTES_LENGTH_EXCEEDS(86, HttpStatus.BAD_REQUEST, "Notes length exceeds 500 characters."),
	
	INTERVENTION_DETAILS_ARE_NOT_AVAILABLE(87, HttpStatus.BAD_REQUEST, "No intervention details provided."),

	SNOOZE_DETAILS_REQUIRED(88, HttpStatus.BAD_REQUEST, "Please enter correct values for snooze duration."),
	
	REASSIGN_DETAILS_REQUIRED(89, HttpStatus.BAD_REQUEST, "Assign To details required"),
	
	SYMPTOM_ASSESSMENT_ANSWERED(90, HttpStatus.BAD_REQUEST, "Responses were already recorded for this assessment"),
	
	INTERVENTION_LOG_SUBMITTER_ID_MANDATORY(91, HttpStatus.BAD_REQUEST, "Staff ID is required to submit intervention log"),
	
	INCORRECT_SNOOZE_VALUE(92, HttpStatus.BAD_REQUEST, "Please enter a whole number for snooze duration"),

	SNOOZE_HOUR_BW_1_AND_72(93, HttpStatus.BAD_REQUEST, "Please enter snooze duration between 1 and 72 hours"),
	
	SNOOZE_DAY_BW_1_AND_3(94, HttpStatus.BAD_REQUEST, "Please enter snooze duration between 1 and 3 days"),
	
	INTERVENTION_LOG_TASK_ID_MANDATORY(95, HttpStatus.BAD_REQUEST, "Task ID is required to create intervention log"),

	TASK_COMPLETED_SUCCESSFULLY(96, HttpStatus.BAD_REQUEST, "Task Completed Successfully") ,
	
	APPROVAL_REQUIRED_BY_CARE_TEAM(97, HttpStatus.BAD_REQUEST, "Enrollment approval required by Care Team"), 
	
	MEDICATION_REMINDER_RESPONSE_RECORDED(98, HttpStatus.BAD_REQUEST, "Medication reminder response has been recorded"),
	
	NO_TASK_DATA(99, HttpStatus.BAD_REQUEST, "No Tasks Available"),
	
	ENROLLMENT_INVITATION_REJECTED(100, HttpStatus.BAD_REQUEST, "Enrollment invitation already rejected"),

	INVALID_INVITATION_CODE(101, HttpStatus.BAD_REQUEST, "Invalid invitation code"),
	
	INVALID_DOB_AND_GENDER_CODE(102, HttpStatus.BAD_REQUEST, "Invalid dob and gender"),
	
	INVALID_PARTICIPANT_INVITATION_DETAILS(103, HttpStatus.BAD_REQUEST, "A patient with the email address already exists. Please check the information on the invite form."),
	
	INVALID_MAPPING_ID(104, HttpStatus.BAD_REQUEST, "Invalid mapping id"),
	
	INVALID_EMAIL(105, HttpStatus.BAD_REQUEST),
	
	EMAIL_ID_EXISTS(106, HttpStatus.BAD_REQUEST),
	ADMIN_NOT_FOUND(107, HttpStatus.BAD_REQUEST, "Admin not Found");



	/** The error code. */
	private int errorCode;
	
	/** The http status. */
	private HttpStatus httpStatus;
	
	/** The default error message. */
	private String defaultErrorMessage;

	/**
	 * Instantiates a new cHP error enum.
	 *
	 * @param errorCode the error code
	 * @param httpStatus the http status
	 */
	private CHPErrorEnum(int errorCode, 
			HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}
	
	/**
	 * Instantiates a new cHP error enum.
	 *
	 * @param errorCode the error code
	 * @param httpStatus the http status
	 * @param defaultErrorMessage the default error message
	 */
	private CHPErrorEnum(int errorCode, 
			HttpStatus httpStatus, String defaultErrorMessage) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.defaultErrorMessage = defaultErrorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}
	
	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	/**
	 * Gets the default error message.
	 *
	 * @return the default error message
	 */
	public String getDefaultErrorMessage() {
		return defaultErrorMessage;
	}
}

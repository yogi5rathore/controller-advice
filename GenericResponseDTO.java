/**
* Copyright © Altimetrik 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of Altimetrik. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms and conditions
* entered into with Altimetrik.
*
* Id: ErrorDTO.java,v 1.1
*
* Date Author Changes
* 3 Dec, 2015, 5:45:37 PM dkorah Created
*/
package com.altimetrik.chp.healthcare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ErrorDTO.
 */
@JsonInclude(Include.NON_NULL)
public class GenericResponseDTO {

	/** The success message. */
	@JsonProperty("success_message")
	private String successMessage = "OK";
	
	/** The error code. */
	@JsonProperty("error_code")
	private Integer errorCode;
	
	/** The error message. */
	@JsonProperty("error_message")
	private String errorMessage;
	
	
	/**
	 * Instantiates a new base dto.
	 */
	public GenericResponseDTO() {}

	
	/**
	 * Instantiates a new base dto.
	 *
	 * @param responseCode the response code
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 */
	public GenericResponseDTO(Integer errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.successMessage = null;
	}
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Gets the success message.
	 *
	 * @return the success message
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * Sets the success message.
	 *
	 * @param successMessage the new success message
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
}

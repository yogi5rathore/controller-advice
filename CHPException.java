/**
* Copyright © Altimetrik 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of Altimetrik. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms and conditions
* entered into with Altimetrik.
*
* Id: CHPException.java,v 1.1
*
* Date Author Changes
* 3 Dec, 2015, 11:54:41 AM dkorah Created
*/
package com.altimetrik.chp.healthcare.error;

import org.springframework.http.HttpStatus;

/**
 * The Class CHPException.
 */
public class CHPException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3842828367608582619L;
	
	/** The error enum. */
	public final CHPErrorEnum errorEnum;
	
	/**
	 * Instantiates a new cHP exception.
	 *
	 * @param errorEnum the error enum
	 * @param errorMessage the error message
	 */
	public CHPException( CHPErrorEnum errorEnum, String errorMessage ) {
		
		super(errorMessage == null ? errorEnum.getDefaultErrorMessage() : errorMessage);
		this.errorEnum = errorEnum;
	}
	
	/**
	 * Instantiates a new cHP exception.
	 *
	 * @param errorEnum the error enum
	 */
	public CHPException( CHPErrorEnum errorEnum ) {
		
		super(errorEnum.getDefaultErrorMessage());
		this.errorEnum = errorEnum;
	}

	/**
	 * Gets the error enum.
	 *
	 * @return the error enum
	 */
	public int getErrorCode() {
		return errorEnum.getErrorCode();
	}
	
	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {

		return errorEnum.getHttpStatus();
	}
}

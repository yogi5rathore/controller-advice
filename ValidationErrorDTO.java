/**
* Copyright © Altimetrik 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of Altimetrik. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms and conditions
* entered into with Altimetrik.
*
* Id: ValidationErrorDTO.java,v 1.1
*
* Date Author Changes
* 5 Dec, 2015, 12:43:36 AM DKorah Created
*/
package com.altimetrik.chp.healthcare.dto;

import java.util.ArrayList;
import java.util.List;

import com.altimetrik.chp.healthcare.error.CHPErrorEnum;

/**
 * The Class ValidationErrorDTO.
 */
public class ValidationErrorDTO extends GenericResponseDTO {
	
	/** The field errors. */
	private List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();
	
	public ValidationErrorDTO() {
		
		super(CHPErrorEnum.VALIDATION_ERROR.getErrorCode(), "Bad Input Parameters");
	}
    /**
     * Adds the field error.
     *
     * @param path the path
     * @param message the message
     */
    public void addFieldError(String path, String message) {
    	
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }
    
    /**
     * Gets the field errors.
     *
     * @return the field errors
     */
    public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}
 
	/**
	 * The Class FieldErrorDTO.
	 */
	public class FieldErrorDTO {
		 
	    /** The field. */
    	private String field;
	 
	    /** The message. */
    	private String message;
	 
	    /**
    	 * Instantiates a new field error dto.
    	 *
    	 * @param field the field
    	 * @param message the message
    	 */
    	public FieldErrorDTO(String field, String message) {
	        this.field = field;
	        this.message = message;
	    }
	 
	    /**
    	 * Gets the field.
    	 *
    	 * @return the field
    	 */
    	public String getField() {
			return field;
		}
	    
	    /**
    	 * Gets the message.
    	 *
    	 * @return the message
    	 */
    	public String getMessage() {
			return message;
		}
	}
}

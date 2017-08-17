/**
* Copyright © Altimetrik 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of Altimetrik. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms and conditions
* entered into with Altimetrik.
*
* Id: ControllerAdvisor.java,v 1.1
*
* Date Author Changes
* 3 Dec, 2015, 6:02:26 PM dkorah Created
*/
package com.altimetrik.chp.healthcare.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.altimetrik.chp.healthcare.auth.error.AuthException;
import com.altimetrik.chp.healthcare.dto.GenericResponseDTO;
import com.altimetrik.chp.healthcare.dto.ValidationErrorDTO;
import com.altimetrik.chp.healthcare.error.CHPErrorEnum;
import com.altimetrik.chp.healthcare.error.CHPException;

/**
 * The Class ControllerAdvisor.
 */
@ControllerAdvice
public class ControllerAdvisor {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MessageSource msgSource;
	/**
	 * Process chp exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(CHPException.class)
	public @ResponseBody ResponseEntity<GenericResponseDTO> processCHPException(HttpServletRequest req, CHPException ex) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String errorMessage;
		try {
    		errorMessage = msgSource.getMessage("chperrorenum."+ex.errorEnum.toString().toLowerCase(),null, currentLocale);
    	} catch(Exception e){
    		errorMessage = ex.getMessage();
    		logger.info("Message not found "+e);
    	}
		logError(req, ex, ex.getErrorCode());
	    return new ResponseEntity<GenericResponseDTO>(new GenericResponseDTO(
	    		ex.getErrorCode(), errorMessage), ex.getHttpStatus());
	}
	
	/**
	 * Process validation error.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the generic response dto
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody ResponseEntity<ValidationErrorDTO> processValidationError(HttpServletRequest req,
    		MethodArgumentNotValidException ex) {
		Locale currentLocale = LocaleContextHolder.getLocale();
        BindingResult result = ex.getBindingResult();
        ValidationErrorDTO dto = new ValidationErrorDTO();
        String errorMessage;
        for (FieldError fieldError: result.getFieldErrors()) {
			try {
				errorMessage = msgSource.getMessage(fieldError.getCodes()[0].toLowerCase(), null, currentLocale);
			} catch (Exception e) {
				try {
					errorMessage = msgSource.getMessage(fieldError.getCodes()[1].toLowerCase(), null, currentLocale);
				} catch (Exception exception) {
					errorMessage = fieldError.getDefaultMessage();
					logger.info("Message not found " + exception);
				}

			}
        	
        	dto.addFieldError(StringUtils.join(
            	     StringUtils.splitByCharacterTypeCamelCase(StringUtils.capitalize(fieldError.getField())),
            	     ' '
            	), errorMessage);
        }
        logError(req, ex, CHPErrorEnum.VALIDATION_ERROR.getErrorCode(), ex.getMessage(), null);
        return new ResponseEntity<ValidationErrorDTO>(dto, CHPErrorEnum.VALIDATION_ERROR.getHttpStatus());
    }
	
	/**
	 * Process auth exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(AuthException.class)
    public @ResponseBody ResponseEntity<GenericResponseDTO> processAuthException(HttpServletRequest req, AuthException ex) {
        logError(req, ex, CHPErrorEnum.FATAL_ERROR.getErrorCode());
        return new ResponseEntity<GenericResponseDTO>(
        		new GenericResponseDTO(CHPErrorEnum.FATAL_ERROR.getErrorCode(), CHPErrorEnum.FATAL_ERROR.getDefaultErrorMessage()),  CHPErrorEnum.FATAL_ERROR.getHttpStatus());
    }
	
	/**
	 * Process servlet exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the generic response dto
	 */
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ServletException.class)
	public @ResponseBody GenericResponseDTO processServletException( HttpServletRequest req, ServletException ex ) {

		logError(req, ex, null);
		return new GenericResponseDTO(null, ex.getMessage() );
	}
	
	/**
	 * Process hibernate exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the generic response dto
	 */
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(HibernateException.class)
	public @ResponseBody GenericResponseDTO processHibernateException( HttpServletRequest req, HibernateException ex ) {

		logError(req, ex, null);
		return new GenericResponseDTO(null, "Database Error" );
	}
	
	/**
	 * Process json parse exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the generic response dto
	 */
	/*@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public @ResponseBody ResponseEntity<GenericResponseDTO> processJSONParseException( HttpServletRequest req, HttpMessageNotReadableException ex ) {

		logError(req, ex, null);
        return new ResponseEntity<GenericResponseDTO>(
        		new GenericResponseDTO(CHPErrorEnum.JSON_PARSE_ERROR.getErrorCode(), ex.getMessage()), 
        		CHPErrorEnum.JSON_PARSE_ERROR.getHttpStatus());
	}*/
	
	/**
	 * Process general error.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(Throwable.class)
    public @ResponseBody ResponseEntity<GenericResponseDTO> processGeneralError(HttpServletRequest req,
    		Throwable ex) {
        
        logError(req, ex, CHPErrorEnum.FATAL_ERROR.getErrorCode());
        return new ResponseEntity<GenericResponseDTO>(
        		new GenericResponseDTO(CHPErrorEnum.FATAL_ERROR.getErrorCode(), "Internal Server Error"), 
        		CHPErrorEnum.FATAL_ERROR.getHttpStatus());
    }
	
	/**
	 * Log error.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @param errorCode the error code
	 */
	private void logError(HttpServletRequest req, Throwable ex, Integer errorCode) {

		String errorPoint = null;
		for (StackTraceElement	traceElement : ex.getStackTrace()) {
			
			if( traceElement.getClassName().startsWith("com.altimetrik") && 
					!traceElement.getClassName().contains("RestEmptyResponseFilter")) {
				
				errorPoint = traceElement.getClassName() + "." + traceElement.getMethodName() + 
						"; Line: " + traceElement.getLineNumber();
				break;
			}
		}
		logError(req, ex, errorCode, ex.getMessage(), errorPoint);
	}
	
	/**
	 * Log error.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @param errorCode the error code
	 * @param errorMsg the error msg
	 * @param errorPoint the error point
	 */
	private void logError(HttpServletRequest req, Throwable ex, Integer errorCode, String errorMsg, String errorPoint) {

		String username = SecurityContextHolder.getContext().getAuthentication() != null ? 
				SecurityContextHolder.getContext().getAuthentication().getName() : null;
		logger.error(username + "@" + req.getRequestURI().substring(req.getContextPath().length()) + 
				 "; ErrorCode: " + errorCode + "; Exception: " + ex.getClass().getCanonicalName() +
				"; ErrorMsg: " + errorMsg + "; ErrorPoint: " + errorPoint);
	}
 
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
        	
        	@Override
        	public String getAsText() {
        		
        		Date value = (Date)getValue();
                return value == null ? "" : String.valueOf(value.getTime());
        	}
        	
        	@Override
        	public void setAsText(String text) throws IllegalArgumentException {
        		
        		 try
                 {
                     setValue(new Date(Long.parseLong(text)));
                 }
                 catch(Exception ex)
                 {
                     throw new CHPException(CHPErrorEnum.VALIDATION_ERROR, (new StringBuilder()).append("Could not parse date: ").append(ex.getMessage()).toString());
                 }
        	}
        });
    }

	/*@ExceptionHandler(CHPException.class)
	@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public ResponseEntity<String> unauthorized(HttpServletRequest req, CHPException ex) {
		System.out.println("ErrorHandler.unauthorized()");
	    return new ResponseEntity<String>("{\"error_message\" : \"User not authorized.\" }", HttpStatus.UNAUTHORIZED);
	}*/
}

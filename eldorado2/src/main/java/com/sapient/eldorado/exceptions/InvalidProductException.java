/**
 * 
 */
package com.sapient.eldorado.exceptions;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * @author HP
 *
 */
public class InvalidProductException extends Exception {

	/**
	 * 
	 * 
	 */
	private List<ObjectError> errors;

	public InvalidProductException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public InvalidProductException(List<ObjectError> errors)
    {
        super("Following field has errors");
        this.errors =errors;
    }

    public List<ObjectError> getErrors(){return errors;}


}

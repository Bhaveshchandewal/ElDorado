/**
 * 
 */
package com.sapient.eldorado.exceptions;

/**
 * @author HP
 *
 */
public class DBConnectionException extends Exception {
	public DBConnectionException(String message) {
		super(message + " DB Connection Error");
	}
}

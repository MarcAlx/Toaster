/*
 * TooManyToastException.java
 *
 * 08/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.exceptions;

/**
 * Exception throws when the size of the specified icon is larger or wider than
 * 40pixels
 *
 * @author Marc-Alexandre Blanchard
 * @version 1.0
 */
public class InvalidIconSizeException extends RuntimeException
{

    /**
     * Constructor to allow Exception with message
     *
     * @param message
     */
    public InvalidIconSizeException(String message)
    {
        super(message);
    }
}

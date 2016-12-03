/*
 * TooManyToastException.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.exceptions;

/**
 *
 * Exception throws when there's too many toast in the toaster
 *
 * @author Marc-Alexandre Blanchard
 * @version 1.0
 *
 */
public class TooManyToastException extends Exception
{

    /**
     * Constructor to allow Exception with message
     *
     * @param message
     */
    public TooManyToastException(String message)
    {
        super(message);
    }
}

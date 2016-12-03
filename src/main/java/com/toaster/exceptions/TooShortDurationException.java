/*
 * TooShortDurationException.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.exceptions;

/**
 * Exception throws when the Duration of a message is shorter than
 * Parameters.MIN_DURATION
 *
 * @author Marc-Alexandre Blanchard
 * @version 1.0
 */
public class TooShortDurationException extends RuntimeException
{

    /**
     * Constructor to allow Exception with message
     *
     * @param message
     */
    public TooShortDurationException(String message)
    {
        super(message);
    }
}

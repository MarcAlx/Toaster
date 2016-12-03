/*
 * Toaster.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.engine;

import com.toaster.exceptions.TooManyToastException;
import com.toaster.enums.ApparitionStyle;
import com.toaster.enums.AppearanceStyle;
import com.toaster.enums.RemoveStyle;
import java.awt.Color;
import java.awt.GraphicsDevice;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 * Toaster wich manage ToastMessage
 *
 * This class is meant to be use like a singleton
 *
 */
final public class Toaster
{

    /**
     * Number of toast actually on screen
     */
    protected static int NB_TOAST_IN_TOASTER = 0;
    /**
     * A non initialise INSTANCE of a Toaster
     */
    private static Toaster TOASTER_INSTANCE = null;

    /**
     *
     * Display a toast message
     *
     * @param message The message to display
     * @param bgColor Background color of the toast
     * @param fontColor Font color of the toast
     * @param apparitionstyle Apparition style (Teleport/Tray)
     * @param removestyle Disapparition style (Teleport/Tray)
     * @param appearanceStyle Appearance style (Round/square) (if round is not
     * supported square is automatically sets)
     * @param DurationInMillisecond Duration of display of the toast (in
     * millisecond) (Appearance animation and Disapearance animation not
     * counted)
     * @throws TooManyToastException Throws if there's too many toasts on
     * screen.
     *
     */
    public void Toast(String message, Color bgColor, Color fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, AppearanceStyle appearanceStyle, int DurationInMillisecond) throws TooManyToastException
    {
        if (NB_TOAST_IN_TOASTER < Parameters.TOASTER_SIZE)
        {
            if (appearanceStyle == AppearanceStyle.RoundCorners && !Parameters.gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT))
            {
                appearanceStyle = AppearanceStyle.SquareCorners;
            }
            SwingUtilities.invokeLater(new RunnableToast(message, null, bgColor, fontColor, apparitionstyle, removestyle, appearanceStyle, DurationInMillisecond));
        }
        else
        {
            throw new TooManyToastException("There's too many toasts on screen, more than the limit allows which is (for your type of screen) equal to " + Parameters.TOASTER_SIZE);
        }
    }

    /**
     * Display a toast message with an icon
     *
     * @param icon Icon of the toast
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     *
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, Color fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, AppearanceStyle appearanceStyle, int DurationInMillisecond) throws TooManyToastException
    {
        if (NB_TOAST_IN_TOASTER < Parameters.TOASTER_SIZE)
        {
            if (appearanceStyle == AppearanceStyle.RoundCorners && !Parameters.gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT))
            {
                appearanceStyle = AppearanceStyle.SquareCorners;
            }
            SwingUtilities.invokeLater(new RunnableToast(message, icon, bgColor, fontColor, apparitionstyle, removestyle, appearanceStyle, DurationInMillisecond));
        }
        else
        {
            throw new TooManyToastException("There's too many toasts on screen, more than the limit allows which is (for your type of screen) equal to " + Parameters.TOASTER_SIZE);
        }
    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message) throws TooManyToastException
    {
        Toast(message, Color.white, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);
    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor) throws TooManyToastException
    {

        Toast(message, bgColor, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);

    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor, Color fontColor) throws TooManyToastException
    {
        Toast(message, bgColor, fontColor, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);
    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, int durationInMillisecond) throws TooManyToastException
    {
        Toast(message, Color.white, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);
    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, bgColor, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor, Color fontColor, int durationInMillisecond) throws TooManyToastException
    {
        Toast(message, bgColor, fontColor, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);
    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, Color.white, Color.black, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, bgColor, Color.black, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle apparitionstyle,RemoveStyle disapparitionstyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, Color bgColor, Color fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, bgColor, fontColor, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon) throws TooManyToastException
    {
        Toast(message, icon, Color.white, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);
    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor) throws TooManyToastException
    {

        Toast(message, icon, bgColor, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);

    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, int durationInMillisecond) throws TooManyToastException
    {
        Toast(message, icon, Color.white, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);
    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, icon, bgColor, Color.black, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);
    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, Color fontColor) throws TooManyToastException
    {
        Toast(message, icon, bgColor, fontColor, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, Parameters.DEFAULT_DURATION);
    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, Color fontColor, int durationInMillisecond) throws TooManyToastException
    {
        Toast(message, icon, bgColor, fontColor, ApparitionStyle.Teleport, RemoveStyle.Teleport, AppearanceStyle.SquareCorners, durationInMillisecond);
    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, icon, Color.white, Color.black, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, icon, bgColor, Color.black, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * @see Toast(String message, ImageIcon icon, Color bgColor, Color
     * fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle,
     * AppearanceStyle appearanceStyle, int DurationInMillisecond)
     */
    public void Toast(String message, ImageIcon icon, Color bgColor, Color fontColor, ApparitionStyle apparitionstyle, RemoveStyle removestyle, int durationInMillisecond) throws TooManyToastException
    {

        Toast(message, icon, bgColor, fontColor, apparitionstyle, removestyle, AppearanceStyle.SquareCorners, durationInMillisecond);

    }

    /**
     * Return the current number of toast inside the toaster
     *
     * @return The number of toast on screen
     */
    public int getNbToastOnScreen()
    {
        return NB_TOAST_IN_TOASTER;
    }

    /**
     * Return the maximum number of toast displayable at the same time
     *
     * @return The number of toast on screen
     */
    public int getMaxNbToastOnScreen()
    {
        return Parameters.TOASTER_SIZE;
    }

    /**
     * @see Toaster Toast(String message, Color bgColor, Color fontColor,
     * ApparitionStyle style1, AppearanceStyle style2, int
     * DurationInMillisecond) throws TooManyToastException
     */
    private Toaster()
    {
    }

    /**
     *
     * Allow the implementation of the singleton pattern
     *
     * @return TOASTER_INSTANCE or new TOASTER_INSTANCE if TOASTER_INSTANCE is
     * null
     */
    public static synchronized Toaster getInstance()
    {
        if (TOASTER_INSTANCE == null)
        {
            TOASTER_INSTANCE = new Toaster();
        }
        return TOASTER_INSTANCE;
    }

    @Override
    public String toString()
    {
        return "Version : " + Parameters.VERSION_NUMBER;
    }
}

/**
 *
 * RunnableToast.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.toaster.engine;

import com.toaster.enums.ApparitionStyle;
import com.toaster.enums.AppearanceStyle;
import com.toaster.enums.RemoveStyle;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * To allow swingutilies.invokelater on toasts
 *
 * @author Crée par Marc-Alexandre Blanchard
 * @version 1.0
 */
class RunnableToast implements Runnable
{

    /**
     * Create a toast
     *
     * @see Toaster Toast(String message,ImageIcon, icon, Color bgColor, Color
     * fontColor, ApparitionStyle style1, AppearanceStyle style2, int
     * DurationInMillisecond) throws TooManyToastException
     */
    public RunnableToast(String message, ImageIcon icon, Color bgColor, Color fontColor, ApparitionStyle as1, RemoveStyle as2, AppearanceStyle as3, int Duration)
    {
        if (icon == null)
        {
            ToastMessage tm = new ToastMessage(message, bgColor, fontColor, as1, as2, as3, Duration);
        }
        else
        {
            ToastMessageWithIcon tmwi = new ToastMessageWithIcon(message, icon, bgColor, fontColor, as1, as2, as3, Duration);
        }
    }

    @Override
    public void run()
    {
    }
}

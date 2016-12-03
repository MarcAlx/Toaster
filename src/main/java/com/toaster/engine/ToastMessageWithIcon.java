/*
 * ToastMessageWithIcon.java
 *
 * 08/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.engine;

import com.toaster.exceptions.InvalidIconSizeException;
import com.toaster.exceptions.TooShortDurationException;
import com.toaster.enums.ApparitionStyle;
import com.toaster.enums.AppearanceStyle;
import com.toaster.enums.RemoveStyle;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Toastmessage with an icon
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
final class ToastMessageWithIcon extends ToastMessage
{

    /**
     * The icon itself
     */
    private final ImageIcon icon;
    /**
     * The JLabel wich hold the Image icon
     */
    private JLabel iconHolder;

    /**
     *
     * @see ToastMessage(String message, Color BGColor, Color FONTColor,
     * ApparitionStyle as1, AppearanceStyle as2, int Duration) throws
     * TooShortDurationException
     * @param ic the icon to be set
     * @throws InvalidIconSizeException throws if the icon is larger or longer
     * than Parameters.ICON_HEIGHT or Parameters.ICON_WIDTH
     */
    ToastMessageWithIcon(String message, ImageIcon ic, Color bgColor, Color fontColor, ApparitionStyle apparitionStyle, RemoveStyle removeStyle, AppearanceStyle appearanceStyle, int duration) throws TooShortDurationException, InvalidIconSizeException
    {
        super(message, bgColor, fontColor, apparitionStyle, removeStyle, appearanceStyle, duration);
        this.icon = ic;
        if (icon.getIconWidth() == Parameters.ICON_WIDTH && icon.getIconHeight() == Parameters.ICON_HEIGTH)
        {
            this.iconHolder = new JLabel(icon);
            this.iconHolder.setOpaque(false);
            this.iconHolder.addMouseListener(this);
            super.getPanel().add(iconHolder, BorderLayout.WEST);
            super.setLocation(super.getX() - Parameters.ICON_WIDTH, super.getY());
        }
        else
        {
            throw new InvalidIconSizeException("Icon Width or Height is not equal to " + Parameters.ICON_WIDTH);
        }
    }

    @Override
    protected void BakeToast()
    {
        super.BakeToast();
        super.setSize(super.getWidth() + Parameters.ICON_WIDTH, super.getHeight());
    }
}

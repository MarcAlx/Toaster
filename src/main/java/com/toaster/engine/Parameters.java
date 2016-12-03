/*
 * Parameters.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.engine;

import com.toaster.enums.ApparitionStyle;
import com.toaster.enums.AppearanceStyle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Marc-Alexandre Blanchard
 * @version 1.0
 *
 * Main parameters of the whole package, not meant to be modified by user
 */
final class Parameters
{

    /**
     * Version number of the Library
     */
    final static float VERSION_NUMBER = 2.0f;
    /**
     * The time to enter to get an infinite toast
     */
    final static int INFINITE_TIME = 0;
    /**
     * Max Length of the text inside a toast message
     */
    final static int MAX_MESSAGE_LENGTH = 50;
    /**
     * Minimum duration for a toast
     */
    final static int MIN_DURATION = 1000;
    /**
     * To manage transparency
     */
    final static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    /**
     * To manage transparency
     */
    final static GraphicsDevice gd = ge.getDefaultScreenDevice();
    /**
     * Dimension of your screen
     */
    final static Dimension SCREEN_RESOLUTION = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Font size of all the toast message
     */
    final static int FONT_SIZE = 14;
    /**
     * Font style of all the toast message
     */
    final static Font FONT = new Font("Lucida", Font.PLAIN, FONT_SIZE);
    /**
     * Width of all toast messages
     */
    final static int WIDTH = 250;
    /**
     * Height of all the toast message
     */
    final static int HEIGTH = 55;
    /**
     * Width of the icon inside ToastMessageWithIcon
     */
    final static int ICON_WIDTH = 40;
    /**
     * Height of the icon inside ToastMessageWithIcon
     */
    final static int ICON_HEIGTH = 40;
    /**
     * Padding X from the Right border of the screen
     */
    final static int PADDING_X = 25;
    /**
     * Padding Y from the top of the screen
     */
    final static int PADDING_Y = 20;
    /**
     * Define the internal margin of all the toast
     */
    final static int INTERNAL_MARGIN = 10;
    /**
     * Minimum opacity of all the toast message
     */
    final static float MIN_OPACITY = 0.05f;
    /**
     * Maximun opacity of all the toast message
     */
    final static float MAX_OPACITY = 0.75f;
    /**
     * Default duration for a toast
     */
    final static int DEFAULT_DURATION = 2000;
    /**
     * Default X position of all toast messages
     */
    final static int DEFAULT_POS_X = Parameters.SCREEN_RESOLUTION.width - (Parameters.WIDTH + Parameters.PADDING_X);
    /**
     * Maximun number of toast messages displayed at the same time
     */
    final static int TOASTER_SIZE = SCREEN_RESOLUTION.height / (PADDING_X + HEIGTH);
    /**
     * Default background color of toast messages
     */
    final static Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    /**
     * Default font color of toast messages
     */
    final static Color DEFAULT_FONT_COLOR = Color.BLACK;
    /**
     * Default ApparitionStyle of toast messages
     */
    final static ApparitionStyle DEFAULT_APPARITION_STYLE = ApparitionStyle.Teleport;
    /**
     * Default AppearanceStyle of toast messages
     */
    final static AppearanceStyle DEFAULT_APPEARANCE_STYLE = AppearanceStyle.SquareCorners;

    /**
     * Private constructor to disallow instanciation
     */
    private Parameters()
    {
    }

    /**
     *
     * @return String wich represents Paremeters
     */
    @Override
    public String toString()
    {
        return "Version - " + Parameters.VERSION_NUMBER + "\n"
                + "Screen Heigth - " + Parameters.SCREEN_RESOLUTION.height + "\n"
                + "Screen Width - " + Parameters.SCREEN_RESOLUTION.width + "\n"
                + "Toaster Size - " + Parameters.TOASTER_SIZE + "\n"
                + "Font size - " + Parameters.FONT_SIZE + "\n"
                + "Toast WIDTH - " + Parameters.WIDTH + "\n"
                + "Toast HEIGHT - " + Parameters.HEIGTH + "\n"
                + "PADDING_X - " + Parameters.PADDING_X + "\n"
                + "PADDING_Y - " + Parameters.PADDING_Y + "\n"
                + "MAX_MESSAGE_LENGTH - " + Parameters.MAX_MESSAGE_LENGTH + "\n"
                + "MIN_OPACITY - " + Parameters.MIN_OPACITY + "\n"
                + "MAX_OPACITY - " + Parameters.MAX_OPACITY + "\n"
                + "DEFAULT_POS_X - " + Parameters.DEFAULT_POS_X;
    }
}

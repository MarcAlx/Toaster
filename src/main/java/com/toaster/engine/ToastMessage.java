/*
 * ToastMEssage.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.engine;

import com.toaster.exceptions.TooShortDurationException;
import com.toaster.enums.ApparitionStyle;
import com.toaster.enums.AppearanceStyle;
import com.toaster.enums.RemoveStyle;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * Represent the concept of toastMessage
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
class ToastMessage extends JFrame implements MouseListener
{

    /**
     * Message displaying by the toast
     */
    private String message;
    /**
     * The appearance time of the toast
     */
    private final int appearanceTime;
    /**
     * Jpanel of the toast
     */
    private JPanel panel;
    /**
     * Area where the message is written
     */
    private JTextArea content;
    /**
     * Timer to manage Animations (apperance,disapearance)
     */
    private Timer timer;
    /**
     * Background color of the toast
     */
    private final Color bgColor;
    /**
     * Font color of the toast
     */
    private final Color fontColor;
    /**
     * Represents the time
     */
    private final int duration;

    /**
     * Apparition style of the toast
     */
    private final ApparitionStyle style1;

    /**
     * Apparition style of the toast
     */
    private final RemoveStyle style2;

    /**
     * Appearance style of the toast
     */
    private final AppearanceStyle style3;

    /**
     * Constructor to build a new toast message with the ability to set
     * Background and font color
     *
     * @param message Message to be displayed
     * @param bgColor Background color of the message
     * @param fontColor Font color of the message
     * @param apparitionStyle apparition style
     * @param removeStyle removal style
     * @param appearanceStyle appearance style
     * @param durationif Duration equals Parameters.INFINITE_TIME the toast is
     * infinite
     * @throws TooShortDurationException Throws if specified duration is too
     * short
     */
    ToastMessage(String message, Color bgColor, Color fontColor, ApparitionStyle apparitionStyle, RemoveStyle removeStyle, AppearanceStyle appearanceStyle, int duration) throws TooShortDurationException
    {
        this.appearanceTime = duration;
        this.bgColor = bgColor;
        this.fontColor = fontColor;
        this.style1 = apparitionStyle;
        this.style2 = removeStyle;
        this.style3 = appearanceStyle;
        this.duration = duration;

        if (this.appearanceTime < Parameters.MIN_DURATION && this.appearanceTime != Parameters.INFINITE_TIME)
        {
            throw new TooShortDurationException("Too short duration specified");
        }

        String[] lines = message.split("\r\n|\r|\n");
        if (lines.length > 2)
        {
            message = lines[0] + '\n';
            for (int i = 1; i < lines.length; i++)
            {
                message += lines[i] + ' ';
            }
        }
        if (message.length() <= Parameters.MAX_MESSAGE_LENGTH)
        {
            this.message = message;
        }
        else
        {
            lines = message.split("\r\n|\r|\n");
            if (lines.length == 1)
            {
                this.message = message.substring(0, Parameters.MAX_MESSAGE_LENGTH - 1) + "…";
            }
            else if (lines.length == 2)
            {
                this.message = lines[0] + '\n' + lines[1].substring(0, ((Parameters.MAX_MESSAGE_LENGTH) / 2) - 1) + "…";
            }
        }
        this.timer = new Timer();
        makeToast();
    }

    /**
     * Build the GUI of the toast
     */
    protected void BakeToast()
    {
        this.setSize(Parameters.WIDTH, Parameters.HEIGTH);
        this.setResizable(false);
        this.setUndecorated(true);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(bgColor);

        this.content = new JTextArea(this.message);
        this.content.setMargin(new Insets(Parameters.INTERNAL_MARGIN, Parameters.INTERNAL_MARGIN, Parameters.INTERNAL_MARGIN, Parameters.INTERNAL_MARGIN));
        this.content.setEditable(true);
        this.content.setLineWrap(true);
        this.content.setFont(Parameters.FONT);
        this.content.setEditable(false);
        this.content.setBackground(this.bgColor);
        this.content.setForeground(this.fontColor);
        this.panel.add(content);
        this.setFocusableWindowState(false);

        this.getContentPane().add(this.panel);
        this.setAlwaysOnTop(true);

        if (!Parameters.gd.isWindowTranslucencySupported(TRANSLUCENT))
        {
            this.setOpacity(Parameters.MIN_OPACITY);
        }

        if (this.style3 == AppearanceStyle.SquareCorners)
        {
            this.setShape(null);
        }
        else if (this.style3 == AppearanceStyle.RoundCorners)
        {
            this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 25, 25));
        }
        content.addMouseListener(this);
    }

    /**
     */
    private void grillToast()
    {
        if (this.style1 == ApparitionStyle.Teleport)
        {
            this.setLocation(Parameters.DEFAULT_POS_X, Parameters.PADDING_Y + ((Parameters.HEIGTH + Parameters.PADDING_Y) * (Toaster.NB_TOAST_IN_TOASTER - 1)));
            this.setVisible(true);
            this.setOpacity(Parameters.MIN_OPACITY);
            this.timer.schedule(new FadeInTask(this), 0, 10);
        }
        else if (this.style1 == ApparitionStyle.TrayLeft)
        {
            this.setLocation(Parameters.SCREEN_RESOLUTION.width, Parameters.PADDING_Y + ((Parameters.HEIGTH + Parameters.PADDING_Y) * (Toaster.NB_TOAST_IN_TOASTER - 1)));
            this.setVisible(true);
            this.setOpacity(Parameters.MAX_OPACITY);
            this.timer.schedule(new SlideToTheLeftTask(this), 100);
        }
    }

    /**
     * Build and Make the toast visible
     */
    private void makeToast()
    {
        Toaster.NB_TOAST_IN_TOASTER++;
        this.BakeToast();
        this.grillToast();
    }

    /**
     * Remove the toast from screen and from the toaster
     */
    protected void removeToast()
    {
        this.timer = new Timer();
        if (this.style2 == RemoveStyle.Teleport)
        {
            this.timer.schedule(new FadeOutTask(this), duration, 10);
        }
        else if (this.style2 == RemoveStyle.TrayRight)
        {
            this.timer.schedule(new SlideToTheRightTask(this), duration);
        }
    }

    /**
     * @return the timer
     */
    protected Timer getTimer()
    {
        return timer;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (this.duration == Parameters.INFINITE_TIME)
        {
            this.removeToast();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    /**
     * @return the panel
     */
    protected JPanel getPanel()
    {
        return panel;
    }

    /**
     * @return the duration
     */
    public int getDuration()
    {
        return duration;
    }
}

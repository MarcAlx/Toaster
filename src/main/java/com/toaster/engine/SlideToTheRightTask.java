/*
 * SlideToTheRightTask.java
 *
 * 07/2013
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 */
package com.toaster.engine;

import java.util.TimerTask;

/**
 *
 * Slide a toast message to the right
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
class SlideToTheRightTask extends TimerTask
{

    /**
     * The toastMessage
     */
    private final ToastMessage tm;

    /**
     *
     * @param tm1 The toastmessage
     */
    public SlideToTheRightTask(ToastMessage tm1)
    {
        this.tm = tm1;
    }

    @Override
    public void run()
    {
        while (this.tm.getLocation().x <= Parameters.SCREEN_RESOLUTION.width)
        {
            tm.setLocation(this.tm.getLocation().x + 10, this.tm.getLocation().y);
            this.tm.repaint();
        }

        this.tm.getTimer().cancel();
        this.tm.dispose();
        Toaster.NB_TOAST_IN_TOASTER--;

    }
}

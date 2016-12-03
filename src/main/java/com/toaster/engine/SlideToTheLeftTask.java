/*
 * SlideToTheLeftTask.java
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
 * Slide a ToastMessage to the left
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
class SlideToTheLeftTask extends TimerTask
{

    /**
     * The toastMessage
     */
    private final ToastMessage tm;

    /**
     *
     * @param tm1 The toastmessage
     */
    public SlideToTheLeftTask(ToastMessage tm1)
    {
        this.tm = tm1;
    }

    @Override
    public void run()
    {
        while (this.tm.getLocation().x >= Parameters.DEFAULT_POS_X)
        {
            this.tm.setLocation(this.tm.getLocation().x - 10, this.tm.getLocation().y);
            this.tm.repaint();
        }

        this.tm.getTimer().cancel();
        if (tm.getDuration() != Parameters.INFINITE_TIME)
        {
            this.tm.removeToast();
        }
    }
}

/*
 * FadeInTask.java
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
 * Make a Toastmessage visible from Parameters.MIN_OPACITY to
 * Parameters.MAX_OPACITY
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
class FadeInTask extends TimerTask
{

    /**
     * The toastMessage
     */
    private final ToastMessage tm;

    /**
     *
     * @param tm1 The toastmessage
     */
    public FadeInTask(ToastMessage tm1)
    {
        this.tm = tm1;
    }

    @Override
    public void run()
    {
        if (this.tm.getOpacity() < Parameters.MAX_OPACITY)
        {
            this.tm.setOpacity(tm.getOpacity() + 0.01f);
            this.tm.repaint();
        }
        else
        {
            this.tm.getTimer().cancel();
            if (tm.getDuration() != Parameters.INFINITE_TIME)
            {
                this.tm.removeToast();
            }
        }
    }
}

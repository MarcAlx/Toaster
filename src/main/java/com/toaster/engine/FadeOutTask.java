/*
 * FadeOutTask.java
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
 * Remove the toast message from screen
 *
 * @author Marc-Alexandre Blanchard
 * @version 2.0
 *
 */
class FadeOutTask extends TimerTask
{

    /**
     * The toast message to remove
     */
    private final ToastMessage tm;

    /**
     *
     * @param tm1 The toast message to remove
     */
    public FadeOutTask(ToastMessage tm1)
    {
        this.tm = tm1;
    }

    @Override
    public void run()
    {
        if (this.tm.getOpacity() > Parameters.MIN_OPACITY)
        {
            this.tm.setOpacity(tm.getOpacity() - 0.01f);
            this.tm.repaint();
        }
        else
        {
            this.tm.getTimer().cancel();
            this.tm.dispose();
            Toaster.NB_TOAST_IN_TOASTER--;
        }
    }
}

package com.toaster.engine;

import com.toaster.exceptions.TooManyToastException;
import org.junit.Test;

/**
 * Created by Marc_Alx on 06/12/14.
 */
public class ToasterTest {

    private Toaster t;

    public ToasterTest()
    {
        t = Toaster.getInstance();
    }

    @Test
    public void testHello() {
        try {
            t.Toast("Hello");
        } catch (TooManyToastException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 2100)
    public void testTime() {
        try {
            t.Toast("2s",2000);
        } catch (TooManyToastException e) {
            e.printStackTrace();
        }
    }


}

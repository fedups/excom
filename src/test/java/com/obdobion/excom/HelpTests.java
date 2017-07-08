package com.obdobion.excom;

import org.junit.BeforeClass;
import org.junit.Test;

import com.obdobion.excom.ui.ExComContext;

/**
 * <p>
 * HelpTests class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 2.0.1
 */
public class HelpTests
{
    static ExCom ex;

    @BeforeClass
    public static void before() throws Exception
    {
        try
        {
            ex = new ExCom();
            ex.startReceiveMode();
        } catch (final Exception e)
        {}
    }

    @Test
    public void commandHelpLong() throws Exception
    {
        final Sender sender = ex.createSender();
        final ExComContext context = sender.processInputRequest("menu --help");
        System.out.println(context.getOutline().getWriter().toString());
    }

    @Test
    public void commandEchoLong() throws Exception
    {
        final Sender sender = ex.createSender();
        final ExComContext context = sender.processInputRequest("echo --help");
        System.out.println(context.getOutline().getWriter().toString());
    }

    @Test
    public void commandHelpShort() throws Exception
    {
        final Sender sender = ex.createSender();
        final ExComContext context = sender.processInputRequest("menu -?");
        System.out.println(context.getOutline().getWriter().toString());
    }
}

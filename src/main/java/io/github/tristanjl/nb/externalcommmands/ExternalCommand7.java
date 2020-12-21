/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.tristanjl.nb.externalcommmands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "io.github.tristanjl.nb.externalcommmands.ExternalCommand7"
)
@ActionRegistration(
        displayName = "#CTL_ExternalCommand7"
)
@ActionReference(path = "Menu/Tools/ExternalCommands", position = 452)
@Messages("CTL_ExternalCommand7=Command 7")
public final class ExternalCommand7 extends ExternalCommandAction implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        command(7);
    }
}

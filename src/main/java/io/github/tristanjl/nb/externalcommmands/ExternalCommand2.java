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
        id = "io.github.tristanjl.nb.externalcommmands.ExternalCommand2"
)
@ActionRegistration(
        displayName = "#CTL_ExternalCommand2"
)
@ActionReference(path = "Menu/Tools/ExternalCommands", position = 52)
@Messages("CTL_ExternalCommand2=Command 2")
public final class ExternalCommand2 extends ExternalCommandAction implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        command(2);
    }
}

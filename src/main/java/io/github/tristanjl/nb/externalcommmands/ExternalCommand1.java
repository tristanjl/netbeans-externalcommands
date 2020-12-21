/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.tristanjl.nb.externalcommmands;

import java.awt.event.*;
import org.openide.awt.*;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "io.github.tristanjl.nb.externalcommmands.ExternalCommand1"
)
@ActionRegistration(
        displayName = "#CTL_ExternalCommand1"
)
@ActionReference(path = "Menu/Tools/ExternalCommands", position = 1)
@Messages("CTL_ExternalCommand1=Command 1")
public final class ExternalCommand1 extends ExternalCommandAction implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        command(1);
    }
}

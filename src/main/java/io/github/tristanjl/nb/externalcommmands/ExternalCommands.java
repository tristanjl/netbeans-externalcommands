/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.tristanjl.nb.externalcommmands;

import java.awt.event.*;
import javax.swing.*;
import org.openide.awt.*;
import java.util.List;
import org.openide.util.*;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Menu/Tools",
        id = "io.github.tristanjl.nb.externalcommmands.ExternalCommands"
)
@ActionRegistration(
        displayName = "#CTL_ExternalCommands",  lazy = false
)

@NbBundle.Messages("CTL_ExternalCommands=External Commands")
public final class ExternalCommands extends AbstractAction implements ActionListener, Presenter.Menu {
        
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
    
    @Override
    public JMenuItem getMenuPresenter() {
        JMenu menu = new JMenu(Bundle.CTL_ExternalCommands());
        List<? extends Action> actionsForPath = Utilities.actionsForPath("Menu/Tools/ExternalCommands");
        for (Action action : actionsForPath) {
            menu.add(action);
        }
        return menu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.tristanjl.nb.externalcommmands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.*;
import javax.swing.*;
import org.openide.loaders.*;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;
import org.openide.windows.TopComponent;

/**
 *
 * @author tristanjl
 */
public class ExternalCommandAction {
    public FileObject getFileObject()
    {
        DataObject dataObject = TopComponent.getRegistry().getActivated().getLookup().lookup(DataObject.class);
        if (dataObject == null)
        {
            return null;
        }

        if (dataObject instanceof DataShadow)
        {
            dataObject = ((DataShadow) dataObject).getOriginal();
        }

        return dataObject.getPrimaryFile();
    }
    
    public void command(int commandIndex)
    {
        String commandString = NbPreferences.forModule(ExternalCommands.class).get("command" + commandIndex, null);
        
        if (commandString == null)
        {
            return;
        }
        
//        FileObject fileobject = getFileObject();
//        
//        if (fileobject == null)
//        {
//            return;
//        }
        
        try
        {
            Runtime.getRuntime().exec(commandString);
        }
        catch (IOException ex)
        {
            final String msg = "Command error";
            StatusDisplayer.getDefault().setStatusText(msg);
            Exceptions.printStackTrace(ex);
        }
    }
}

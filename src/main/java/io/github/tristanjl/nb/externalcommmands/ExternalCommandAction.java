/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.tristanjl.nb.externalcommmands;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.commons.lang3.SystemUtils;
import org.openide.loaders.*;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.util.*;
import org.openide.windows.*;

/**
 *
 * @author tristanjl
 */
public class ExternalCommandAction {
    InputOutput mOutput;
    String mOutputName;
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
        if (commandString == null || commandString.isEmpty())
        {
            return;
        }
        
        if (commandString.contains("${FilePath}"))
        {
            FileObject fileobject = getFileObject();
            String filePath;
            if (fileobject == null)
            {
                filePath = "";
            }
            else
            {
                filePath = fileobject.getPath();
                if (SystemUtils.IS_OS_WINDOWS)
                {
                    filePath = filePath.replace("/", "\\");
                }
            }
            
            commandString = commandString.replace("${FilePath}", filePath);
        }
        
        String commandName = NbPreferences.forModule(ExternalCommands.class).get("commandName" + commandIndex, "Command " + commandIndex);
        if (commandName.isEmpty())
        {
            commandName = "Command " + commandIndex;
        }
        if (mOutput == null || mOutputName != commandName || mOutput.isClosed())
        {
            mOutputName = commandName;
            mOutput = IOProvider.getDefault().getIO(commandName, true);
        }
        else
        {
            mOutput.setFocusTaken(true);
            try
            {
                mOutput.getOut().reset();
                mOutput.getErr().reset();
            }
            catch (IOException ex) {}
        }
        
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            System.out.println(dtf.format(now));
            
            mOutput.getOut().println(dtf.format(now) + " - " + commandString);
            mOutput.getOut().println("");

            ProcessBuilder pb = new ProcessBuilder(Utilities.parseParameters(commandString)).redirectErrorStream(true);
            Process process = pb.start();
            StringBuilder result = new StringBuilder(80);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream())))
            {
                while (true)
                {
                    String line = in.readLine();
                    if (line == null)
                        break;
                    mOutput.getOut().println(line);
                }
            }
        }
        catch (IOException ex)
        {
            final String msg = "Command error";
            StatusDisplayer.getDefault().setStatusText(msg);
            Exceptions.printStackTrace(ex);
        }
        mOutput.getOut().close();
        mOutput.getErr().close();
    }
}

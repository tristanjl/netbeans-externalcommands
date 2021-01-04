# netbeans-externalcommands
This netbeans plugin adds an External Commands submenu and to your Tools menu which includes 10 customisable external commands.

These can be configured in Tools->Options->Miscellaneous->External Commands. Each row entry in the customisation menu provides two text entry boxes. The first is for entering the name of the command, which will be used for the title of the output window when running the command. The second contains the command and all its arguments.

The commands also support the following variable replacements:
${FilePath} - The full file path of the current file

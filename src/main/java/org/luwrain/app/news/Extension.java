/*
   Copyright 2012-2015 Michael Pozhidaev <msp@altlinux.org>

   This file is part of the Luwrain.

   Luwrain is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   Luwrain is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.
*/

package org.luwrain.app.news;

import java.util.*;

import org.luwrain.core.Application;
import org.luwrain.core.Shortcut;
import org.luwrain.core.Command;
import org.luwrain.core.CommandEnvironment;
import org.luwrain.core.Worker;
import org.luwrain.core.SharedObject;
import org.luwrain.core.I18nExtension;
import org.luwrain.core.Luwrain;
import org.luwrain.core.Registry;

public class Extension implements org.luwrain.core.Extension
{
    @Override public String init(String[] args, Registry registry)
    {
	return null;
    }

    @Override public Command[] getCommands(CommandEnvironment env)
    {
	Command[] res = new Command[1];
	res[0] = new Command(){
		@Override public String getName()
		{
		    return "news";
		}
		@Override public void onCommand(CommandEnvironment env)
		{
		    env.launchApp("news");
		}
	    };
	return res;
    }

    @Override public Shortcut[] getShortcuts()
    {
	Shortcut[] res = new Shortcut[1];
	res[0] = new Shortcut() {
		@Override public String getName()
		{
		    return "news";
		}
		@Override public Application[] prepareApp(String[] args)
		{
		    Application[] res = new Application[1];
		    res[0] = new NewsApp();
		    return res;
		}
	    };
	return res;
    }

    @Override public Worker[] getWorkers()
    {
	return new Worker[0];
    }

    @Override public SharedObject[] getSharedObjects()
    {
	return new SharedObject[0];
    }

    @Override public void i18nExtension(I18nExtension i18nExt)
    {
	i18nExt.addCommandTitle("en", "news", "News");
	i18nExt.addCommandTitle("ru", "news", "Новости");
	i18nExt.addStrings("ru", "luwrain.news", new org.luwrain.app.news.i18n.Ru());
    }

    @Override public org.luwrain.mainmenu.Item[] getMainMenuItems(CommandEnvironment env)
    {
	return new org.luwrain.mainmenu.Item[0];
    }

    @Override public void close()
    {
	//Nothing here;
    }
}

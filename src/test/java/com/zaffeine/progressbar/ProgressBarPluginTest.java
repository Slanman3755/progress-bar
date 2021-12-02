package com.zaffeine.progressbar;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ProgressBarPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ProgressBarPlugin.class);
		RuneLite.main(args);
	}
}
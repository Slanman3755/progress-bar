package com.zaffeine.progressbar;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("progressbar")
public interface ProgressBarConfig extends Config
{
	@ConfigItem(
		keyName = "fletching_message",
		name = "Fletching message",
		description = "The message to show to the user when they fletch"
	)
	default String fletchingMessage()
	{
		return "Fletching!";
	}
}

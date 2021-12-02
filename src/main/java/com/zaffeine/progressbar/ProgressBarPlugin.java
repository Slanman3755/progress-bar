package com.zaffeine.progressbar;

import com.google.inject.Provides;

import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.awt.*;

@Slf4j
@PluginDescriptor(
	name = "Progress Bar"
)
public class ProgressBarPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ProgressBarConfig config;

	@Inject
	private ProgressBarOverlay progressBarOverlay;

	@Getter
	private boolean isFletching = false;

	@Override
	protected void startUp()
	{
		overlayManager.add(progressBarOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(progressBarOverlay);
		isFletching = false;
	}

	@Provides
	ProgressBarConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ProgressBarConfig.class);
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();
		if (actor instanceof Player)
		{
			if (actor.getAnimation() == AnimationID.FLETCHING_ATTACH_FEATHERS_TO_ARROWSHAFT)
			{
				isFletching = true;
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", config.fletchingMessage(), null);
			} else {
				isFletching = false;
			}
		}
	}
}

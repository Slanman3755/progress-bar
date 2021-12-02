package com.zaffeine.progressbar;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Progress Bar"
)
public class ProgressBarPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ProgressBarConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Progress Bar started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Progress Bar stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Progress Bar says " + config.greeting(), null);
		}
	}

	@Provides
	ProgressBarConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ProgressBarConfig.class);
	}
}

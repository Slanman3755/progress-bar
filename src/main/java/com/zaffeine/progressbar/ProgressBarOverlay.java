package com.zaffeine.progressbar;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

public class ProgressBarOverlay extends Overlay {

    private final Client client;
    private final ProgressBarPlugin plugin;
    private final ProgressBarConfig config;

    @Inject
    private ProgressBarOverlay(Client client, ProgressBarPlugin plugin, ProgressBarConfig config)
    {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D g) {
        if (plugin.isFletching()) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(0, 0, 128, 16);
        return null;
    }
}

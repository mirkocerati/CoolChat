package com.aubenoire.coolchat.listeners;

import com.aubenoire.coolchat.objects.CoolChatCreator;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public record PlayerChatEvent(CoolChatCreator renderer) implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        event.renderer(renderer);
    }

}

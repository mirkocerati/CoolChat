package com.aubenoire.coolchat;

import com.aubenoire.coolchat.listeners.PlayerChatEvent;
import com.aubenoire.coolchat.objects.CoolChatCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class CoolChat extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerChatEvent(new CoolChatCreator()), this);
    }

}

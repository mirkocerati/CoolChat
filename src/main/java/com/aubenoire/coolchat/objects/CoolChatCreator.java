package com.aubenoire.coolchat.objects;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CoolChatCreator implements ChatRenderer {
    @Override
    public @NotNull Component render(@NotNull Player player, @NotNull Component component, @NotNull Component component1, @NotNull Audience audience) {
        TextComponent.Builder format = Component.text();
        CachedMetaData data = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData();

        TextColor prefix = TextColor.fromHexString(Objects.requireNonNullElse(data.getMetaValue("prefix-color"), "#ffffff"));
        format.append(Component.text(Objects.requireNonNullElse(data.getPrefix(), "").replaceAll("&", "§")+' ').color(prefix));

        TextColor username = TextColor.fromHexString(Objects.requireNonNullElse(data.getMetaValue("username-color"), "#ffffff"));
        format.append(Component.text(player.getName()).color(username));

        TextColor suffix = TextColor.fromHexString(Objects.requireNonNullElse(data.getMetaValue("suffix-color"), "#ffffff"));
        format.append(Component.text(' ' + Objects.requireNonNullElse(data.getSuffix(), "").replaceAll("&", "§")).color(suffix));

        format.append(Component.text("» ").color(TextColor.fromHexString("#757575")));

        TextColor chat = TextColor.fromHexString(Objects.requireNonNullElse(data.getMetaValue("chat-color"), "#ffffff"));
        format.append(component1.color(chat));

        return format.build();
    }
}

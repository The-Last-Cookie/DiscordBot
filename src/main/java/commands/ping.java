package commands;
import main.Static;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "ping")) {
            EmbedBuilder ping = new EmbedBuilder();

            ping.setColor(0x0099ff);
            ping.addField("Pong!", event.getAuthor().getJDA().getPing() + " ms", false);

            event.getChannel().sendMessage(ping.build()).queue();
            ping.clear();
        }
    }
}

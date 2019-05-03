package commands;

import main.main;
import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class serverInfo extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "serverinfo")) { //provides serverInfo about specific user

            //could do for ServerInfo: how many are online? how many are in a specific guild?

            EmbedBuilder serverInfo = new EmbedBuilder()
                    .setTitle("Server Information")
                    .addField("User currently on this server", "There are currently " + event.getJDA().getUsers().size() + " users on this server", false)
                    .addField("User currently online", "There are currently " + event.getChannel().getJDA().getUsers().size() + " users online", false)
                    .addField("User currently in the guild", "", false)
                    .addField("Bot", "running since", false) //main.a
                    .addField("Server owner", "TheLastCookie", false)
                    .setColor(0xf45642);

            event.getChannel().sendMessage(serverInfo.build()).queue();
            serverInfo.clear();
        }
    }
}
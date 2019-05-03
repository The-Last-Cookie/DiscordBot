package commands;

import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class toggleFilter extends ListenerAdapter {

    public static boolean filterOn = true;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "togglefilter")) {
            if (event.getMember().hasPermission(event.getChannel(), Permission.ADMINISTRATOR)) {
                if (filterOn) {
                    filterOn = false;
                    event.getChannel().sendMessage("Filter disabled by " + event.getMember().getAsMention()).queue();
                }
                else {
                    filterOn = true;
                    event.getChannel().sendMessage("Filter enabled by " + event.getMember().getAsMention()).queue();
                }
            }
            else {
                EmbedBuilder permission = new EmbedBuilder()
                        .setColor(0xff3923)
                        .setTitle("No permissions")
                        .setDescription(event.getAuthor().getAsMention() + ", you don't have the required permissions to execute this command.");

                event.getChannel().sendMessage(permission.build()).queue();
                permission.clear();
            }
        }
    }
}

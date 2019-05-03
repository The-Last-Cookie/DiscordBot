package commands;
import main.Static;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class clear extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "clear")) {
            if (event.getMember().hasPermission(event.getChannel(), Permission.ADMINISTRATOR)) {
                try {
                    try {
                        int number = Integer.parseInt(args[1]); //testing if args[1] is an integer

                        List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1).complete();
                        event.getChannel().deleteMessages(messages).queue();

                        //success
                        EmbedBuilder usage = new EmbedBuilder()
                                .setColor(0x22ff2a)
                                .setTitle("Successfully deleted " + (messages.size() - 1) + " messages.");

                        event.getChannel().sendMessage(usage.build()).complete().delete().queueAfter(5, TimeUnit.SECONDS);
                        usage.clear();
                    } catch (NumberFormatException n) {
                        //usage
                        EmbedBuilder usage = new EmbedBuilder()
                                .setColor(0xff3923)
                                .addField("How to use this command", Static.prefix + "clear [number of messages]", false)
                                .addField("Example", Static.prefix + "clear 5", false);

                        event.getChannel().sendMessage(usage.build()).queue();
                        usage.clear();
                    }
                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieved")) {
                        //too many messages
                        EmbedBuilder error = new EmbedBuilder()
                                .setColor(0xff3923)
                                .addField("Too many messages selected", "Between 2-99 messages can be deleted at one time", true);

                        event.getChannel().sendMessage(error.build()).queue();
                        error.clear();
                    } else {
                        //messages too old
                        EmbedBuilder error = new EmbedBuilder()
                                .setColor(0xff3923)
                                .addField("Selected messages are older than 2 weeks", "Between 2-99 messages can be deleted at one time", true);

                        event.getChannel().sendMessage(error.build()).queue();
                        error.clear();
                    }
                } catch (IndexOutOfBoundsException e) {
                    //usage
                    EmbedBuilder usage = new EmbedBuilder()
                            .setColor(0xff3923)
                            .addField("How to use this command", Static.prefix + "clear [number of messages]", false)
                            .addField("Example", Static.prefix + "clear 5", false);

                    event.getChannel().sendMessage(usage.build()).queue();
                    usage.clear();
                }
            }
            else {
                //no permissions
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
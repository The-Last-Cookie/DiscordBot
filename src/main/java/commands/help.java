package commands;

import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class help extends ListenerAdapter {

    //a.addField("", "", false); true means it is how float:left in css

    //Date date = new Date(); System.out.println("[Info: " + date.toString() + "] Command 'help' got executed successfully."); //this works good
    //SimpleDateFormat a = new SimpleDateFormat("MM/dd/yyyy");
    //SimpleDateFormat b = new SimpleDateFormat("HH:mm:ss");

    //if (event.getMember().hasPermission(event.getChannel(), Permission.ADMINISTRATOR)) {
    //if (event.getMember().getRoles().contains("Admin")) {

    //TODO categorising? like on help page 1 are only commands for members and on the last page are commands for admins

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "help")) {
            try {
                switch (Integer.parseInt(args[1])) {
                    case 0:
                        //usage
                        EmbedBuilder help = new EmbedBuilder()
                                .setColor(0x0099ff)
                                .setTitle("Commands")
                                .setDescription("This is the help page.")
                                .addField("How to use it", Static.prefix + "help [page]", false)
                                .addField("Example", Static.prefix + "help 1", false);

                        event.getChannel().sendMessage(help.build()).queue();
                        help.clear();
                        break;
                    case 1:
                        //help page 1
                        EmbedBuilder help1 = new EmbedBuilder()
                                .setColor(0x0099ff)
                                .setTitle("Commands")
                                .setDescription("Page 1")
                                .addField(Static.prefix + "clear", "Deletes messages", false)
                                //.addField(Static.prefix + "gtn", "Guess a number", false)
                                .addField(Static.prefix + "help", "View all available commands", false)
                                .addField(Static.prefix + "userinfo", "Gives back information about a specific user", false)
                                .addField(Static.prefix + "oracle", "Ask the oracle a yes/no question", false)
                                .addField(Static.prefix + "ping", "Gives back 'Pong!'", false)
                                .addField(Static.prefix + "serverinfo", "Gives back information about the server", false)
                                .addField(Static.prefix + "togglefilter", "Enables/disables the word filter", false);

                        event.getChannel().sendMessage(help1.build()).queue();
                        help1.clear();
                        break;

                    case 2:
                        //help page 2
                        EmbedBuilder help2 = new EmbedBuilder()
                                .setColor(0x0099ff)
                                .setTitle("Commands")
                                .setDescription("Page 2")
                                .addField("No commands", "There are no commands on this page.", false);

                        event.getChannel().sendMessage(help2.build()).queue();
                        help2.clear();
                        break;
                }
            }
            catch (IndexOutOfBoundsException e) {
                //usage
                EmbedBuilder help = new EmbedBuilder()
                        .setColor(0x0099ff)
                        .setTitle("Commands")
                        .setDescription("This is the help page.")
                        .addField("How to use it", Static.prefix + "help [page]", false)
                        .addField("Example", Static.prefix + "help 1", false);

                event.getChannel().sendMessage(help.build()).queue();
                help.clear();
            }
        }
    }
}
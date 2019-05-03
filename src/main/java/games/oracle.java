package games;

import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class oracle extends ListenerAdapter {

    String[] messages = new String[]{
            "I don't know",
            "I don't want to answer this question",
            "Maybe",
            "No",
            "Nope",
            "Probably",
            "That's the least of your problems",
            "Theoretically",
            "Yes"
    };

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        Random rand = new Random();
        int number = rand.nextInt(this.messages.length);

        if (args[0].equalsIgnoreCase(Static.prefix + "oracle")) {
            try {
                int a = 1;

                while (!args[a].endsWith("?")) {
                    a++;
                }

                EmbedBuilder oracle1 = new EmbedBuilder();

                oracle1.setTitle("Ask the oracle!");
                oracle1.setDescription("The answer is: " + messages[number]);
                oracle1.setColor(0xffffff);

                event.getChannel().sendMessage(oracle1.build()).queue();
                oracle1.clear();
            }
            catch (IndexOutOfBoundsException e) {
                //usage
                EmbedBuilder oracle = new EmbedBuilder();

                oracle.setTitle("Ask the oracle!");
                oracle.setDescription("You can ask the oracle a yes/no question.");
                oracle.setColor(0xffffff);
                oracle.addField("How to use the command", Static.prefix + "oracle [question]", false);
                oracle.addField("Example", Static.prefix + "oracle Is the oracle here?\n\n----------------------------------------------------", false);
                oracle.addField("Important", "Don't forget the question mark at the end!", false);

                event.getChannel().sendMessage(oracle.build()).queue();
                oracle.clear();
            }
        }
    }
}

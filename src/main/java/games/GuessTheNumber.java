package games;

import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class GuessTheNumber extends ListenerAdapter {
    //TODO Important: The program has to create a GameState for every player,
    // so the number doesn't change every round
    // --> createGameState() / initiateGameState
    // --> personal variables

    int guess;
    int number;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "gtn")) { //GuessTheNumber
            try {
                Random math = new Random();
                int number = Integer.parseInt(String.valueOf(math));
                int guess = Integer.parseInt(args[1]);

                if (guess == number) {
                    //print out success
                }
                else if (guess < number) {
                    //print out higher
                }
                else {
                    //print out lower
                }

            } catch (IndexOutOfBoundsException e) {
                //usage
                EmbedBuilder gtn = new EmbedBuilder();

                gtn.setTitle("Guess the number!");
                gtn.setDescription("Guess a number and see if you're right.");
                gtn.addField("How to use it", Static.prefix + "gtn [number]", false);
                gtn.addField("Example", Static.prefix + "gtn 60", false);

                event.getChannel().sendMessage(gtn.build()).queue();
                gtn.clear();
            }
        }
    }

    public boolean numberGuessed() {
        if (guess == number) {
            //print out success
            return true;
        }
        else if (guess < number) {
            //print out higher
            return  false;
        }
        else {
            //print out lower
            return false;
        }
    }
}

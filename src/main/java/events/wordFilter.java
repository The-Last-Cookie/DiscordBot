package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

import static commands.toggleFilter.filterOn;

public class wordFilter extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (filterOn == true) {
            String args[] = event.getMessage().getContentRaw().split("\\s+");

            String[] words = new String[] {
                    "Flittchen", "ass", "slut"
            };

            for (int i = 0; i < args.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (args[i].contains(words[j])) {
                        event.getMessage().delete().queue();
                        event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", watch your language dude!").complete().delete().queueAfter(5, TimeUnit.SECONDS);

                        //mute member for 20 seconds
                        //event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Muted", true)).complete();
                        /*event.getGuild().getController().addSingleRoleToMember(event.getMessage().getMentionedMembers().get(0), event.getGuild().getRoleById("Muted")).queue();
                        try {
                            Thread.sleep(20000);
                        }
                        catch(InterruptedException e) {
                            System.out.println("InterruptedException");
                            event.getGuild().getController().addSingleRoleToMember(event.getMessage().getMentionedMembers().get(0), event.getGuild().getRoleById("Member")).queue();
                        }*/
                    }
                }
            }
        }
    }

    /*public void unmute() {

    }*/
}
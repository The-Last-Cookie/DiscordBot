package events;

import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = new String[]{
            "[member] just left the server.",
            "We're all shocked, [member] disappeared!",
            "[member] disconnected. Why?",
            "Now we're all alone a bit more because [member] left the server."
    };

    /*public GuildMemberLeave() {
    }*/

    /*public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(this.messages.length);

        EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(16024386);
        leave.setDescription(this.messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
    }*/
}

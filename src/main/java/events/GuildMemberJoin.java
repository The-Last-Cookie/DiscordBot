package events;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {
    String[] messages = new String[]{
            "A wild [member] appeared!",
            "We've been expecting you, [member]!",
            "Brace yourselves. [member] just joined the server.",
            "Have fun on this server, [member]!",
            "The really popular [member] joined the server. It must be a dream!"
    };

    /*public GuildMemberJoin() {
    }*/

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(this.messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(6740223);
        join.setDescription(this.messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getTextChannelById("483200119815274522").sendMessage(join.build()).queue();

        //add role
        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Member", true)).complete();
    }
}

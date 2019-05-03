package commands;

import main.Static;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.time.format.DateTimeFormatter;

public class info extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Static.prefix + "info")) {
            try {
                if (args[1].equalsIgnoreCase("user")) {
                    //userInfo
                    Member name = event.getMessage().getMentionedMembers().get(0);
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                    EmbedBuilder info = new EmbedBuilder()
                            .setTitle("User Information")
                            .addField("Name", name.getUser().getName(), false)
                            .addField("Nickname", name.getNickname() == null ? "The user has no nickname" : name.getNickname(), false)
                            .addField("Joined on", name.getJoinDate().format(fmt), false)
                            .addField("Role", getRoles(name), false)
                            .addField("Status", onlineStatus(name), false)
                            .addField("Game", displayGameInfo(name), false)
                            .setThumbnail(name.getUser().getAvatarUrl())
                            .setColor(0xf45642);

                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                } else {
                    //usage
                    EmbedBuilder info = new EmbedBuilder()
                            .setTitle("User Information")
                            .addField("How to use this command", Static.prefix + "info [server]/@[user]", false)
                            .addField("Example", Static.prefix + "info server\n" + Static.prefix + "info user @TheLastCookie", false)
                            .setColor(0xf45642);

                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                }
            } catch (IllegalArgumentException j) {
                //usage
                EmbedBuilder info = new EmbedBuilder()
                        .setTitle("User Information")
                        .addField("How to use this command", Static.prefix + "info [server]/@[user]", false)
                        .addField("Example", Static.prefix + "info server\n" + Static.prefix + "info user @TheLastCookie", false)
                        .setColor(0xf45642);

                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            } catch (ArrayIndexOutOfBoundsException a) {
                //usage
                EmbedBuilder info = new EmbedBuilder()
                        .setTitle("User Information")
                        .addField("How to use this command", Static.prefix + "info [server]/@[user]", false)
                        .addField("Example", Static.prefix + "info server\n" + Static.prefix + "info user @TheLastCookie", false)
                        .setColor(0xf45642);

                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            } catch (IndexOutOfBoundsException i) {
                //usage
                EmbedBuilder info = new EmbedBuilder()
                        .setTitle("User Information")
                        .addField("How to use this command", Static.prefix + "info [server]/@[user]", false)
                        .addField("Example", Static.prefix + "info server\n" + Static.prefix + "info user @TheLastCookie", false)
                        .setColor(0xf45642);

                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            }
        }
    }

    private String getRoles(Member name) {
        String roles = name.getRoles().toString();

        try {
            if (roles.contains("Admin")) {
                return "Admin";
            } else if (roles.contains("Bot")) {
                return "Bot";
            } else if (roles.contains("Moderator")) {
                return "Moderator";
            } else if(roles.contains("Member")) {
                return "Member";
            }
            else {
                return "Muted";
            }
        } catch (NullPointerException e) {
            return "This member has no assigned roles.";
        }
    }

    private String displayGameInfo(Member name) {
        try {
            String game = name.getGame().getName();
            return "Playing game: " + game;
        } catch (NullPointerException e) {
            return "No game is being played";
        }
    }

    private String onlineStatus(Member name) {
        if(name.getOnlineStatus().toString().equals("ONLINE")) {
            return "Online";
        } else if(name.getOnlineStatus().toString().equals("IDLE")) {
            return "Idle";
        } else if(name.getOnlineStatus().toString().equals("DO_NOT_DISTURB")) {
            return "Do not disturb";
        } else {
            return "The user is offline at the moment";
        }
    }
}
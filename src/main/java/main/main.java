/*
THIS IS THE LINE I CHANGED
    Date: 5th March 2019
    Licensed under the GNU General Public License v3.0

 */

package main;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.*;
import commands.*;
import games.*;
import events.*;

public class main {

    public static JDA jda;

    public static void main(String args[]) throws Exception {

        jda = new JDABuilder(AccountType.BOT).setToken(Static.token).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setGame(Game.playing("with your mum"));

        //add EventListeners
        jda.addEventListener(new clear());
        jda.addEventListener(new ping());
        jda.addEventListener(new info());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new help());
        jda.addEventListener(new oracle());
        jda.addEventListener(new wordFilter());
        jda.addEventListener(new toggleFilter());
    }
}

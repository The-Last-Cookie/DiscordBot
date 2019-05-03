package main;

//import events.GuildMemberLeave;
//import events.GuildMessageReceived;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.*;
import commands.*;
import games.*;
import events.*;

import java.util.Timer;
import java.util.TimerTask;

public class main {

    public static JDA jda;
    public int a = 0;
    //setTimer(); //for serverInfo - Bot running since
    //startTimer();

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

        //jda.addEventListener(new GuessTheNumber());
        //jda.addEventListener(new GuildMemberLeave());
        //jda.addEventListener(new GuildMessageReceived());
    }

    /*public void startTimer() {
        //every second do a++;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

            }
        };
        timer.schedule(task, 1000, 1000);
    }*/
}

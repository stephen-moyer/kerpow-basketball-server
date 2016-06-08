package com.kerpow.games.freethrow.server;

import com.kerpow.games.server.Player;
import io.netty.channel.Channel;

public class FreeThrowPlayer extends Player {

    public int id = 0;

    public FreeThrowGame game;
    public boolean ready;

    public FreeThrowPlayer(Channel channel) {
        super(channel);
    }

}

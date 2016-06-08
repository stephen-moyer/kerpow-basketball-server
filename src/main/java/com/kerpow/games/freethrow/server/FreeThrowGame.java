package com.kerpow.games.freethrow.server;

import com.kerpow.games.freethrow.common.message.OpponentFoundOuterClass;
import com.kerpow.games.freethrow.common.message.ReadyOuterClass;
import com.kerpow.games.freethrow.common.message.ShotOuterClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FreeThrowGame {

    public List<FreeThrowPlayer> players = new LinkedList<>();

    public void shot(FreeThrowPlayer player, ShotOuterClass.Shot message) {
        message = message.toBuilder().setOwner(player.id).build();
        for(FreeThrowPlayer pl : players) {
            if (player == pl)
                continue;
            pl.channel.writeAndFlush(message);
        }
    }

    public void ready(FreeThrowPlayer player) {
        player.ready = true;
        for(FreeThrowPlayer pl : players) {
            if (!pl.ready) {
                return;
            }
        }
        ReadyOuterClass.Ready message = ReadyOuterClass.Ready.newBuilder().build();
        for(FreeThrowPlayer pl : players) {
            pl.channel.writeAndFlush(message);
        }
    }

    public void start() {
        OpponentFoundOuterClass.OpponentFound.Builder builder = OpponentFoundOuterClass.OpponentFound.newBuilder();
        ArrayList<Integer> opponents = new ArrayList<>();
        for(FreeThrowPlayer player : players) {
            builder.clearOpponents().addAllOpponents(getOpponentsList(opponents, player));
            player.channel.writeAndFlush(builder.build());
        }
    }

    private Iterable<? extends Integer> getOpponentsList(ArrayList<Integer> list, FreeThrowPlayer player) {
        list.clear();
        for(FreeThrowPlayer pl : players) {
            if (pl == player) {
                continue;
            }
            list.add(pl.id);
        }
        return list;
    }
}

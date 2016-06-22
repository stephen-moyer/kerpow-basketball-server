package com.kerpow.games.freethrow.server;

import com.kerpow.games.freethrow.common.game.Court;
import com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass;
import com.kerpow.games.freethrow.common.message.messages.ReadyOuterClass;
import com.kerpow.games.freethrow.common.message.messages.ScoredOuterClass;
import com.kerpow.games.freethrow.common.message.messages.ShotOuterClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FreeThrowGame implements Court.CourtCallbacks {

    public List<FreeThrowPlayer> players = new LinkedList<>();
    private volatile Court court;

    private long lastTime = 0;

    public void process() {
        if (this.court == null)
            return;
        float elapsed = (int) (System.currentTimeMillis() - lastTime) / 1000f;
        lastTime = System.currentTimeMillis();
        this.court.process(elapsed);
    }

    public void shot(FreeThrowPlayer player, ShotOuterClass.Shot message) {
        message = message.toBuilder().setOwner(player.id).build();
        court.shoot(player.id, message.getBallY(), message.getBallVelY(), message.getPowerX(), message.getPowerY());
        for (FreeThrowPlayer pl : players) {
            if (player == pl)
                continue;
            pl.channel.writeAndFlush(message);
        }
    }

    public void ready(FreeThrowPlayer player) {
        player.ready = true;
        for (FreeThrowPlayer pl : players) {
            if (!pl.ready) {
                return;
            }
        }
        Court court = new Court(this);
        court.init();
        ReadyOuterClass.Ready message = ReadyOuterClass.Ready.newBuilder().build();
        for (FreeThrowPlayer pl : players) {
            pl.channel.writeAndFlush(message);
        }
        this.court = court;
    }

    public void start() {
        OpponentFoundOuterClass.OpponentFound.Builder builder = OpponentFoundOuterClass.OpponentFound.newBuilder();
        ArrayList<Integer> opponents = new ArrayList<>();
        for (FreeThrowPlayer player : players) {
            builder.clearOpponents().addAllOpponents(getOpponentsList(opponents, player));
            player.channel.writeAndFlush(builder.build());
        }
    }

    private Iterable<? extends Integer> getOpponentsList(ArrayList<Integer> list, FreeThrowPlayer player) {
        list.clear();
        for (FreeThrowPlayer pl : players) {
            if (pl == player) {
                continue;
            }
            list.add(pl.id);
        }
        return list;
    }

    private FreeThrowPlayer getPlayer(long id) {
        for (int i = 0; i < players.size(); i++) {
            FreeThrowPlayer player = players.get(i);
            if (player.id == id) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void scored(long id) {
        FreeThrowPlayer player = getPlayer(id);
        if (player == null)
            return;
        System.out.println("Scored");
        player.score++;
        ScoredOuterClass.Scored message = ScoredOuterClass.Scored.newBuilder()
                .setId(player.id)
                .setScore(player.score)
                .build();
        for (FreeThrowPlayer pl : players) {
            pl.channel.writeAndFlush(message);
        }

    }

    @Override
    public void missed(long id) {

    }

    @Override
    public void shot(float v, float v1, float v2, float v3) {
        //NOT USED
    }

    @Override
    public void drawBall(float v, float v1, float v2, float v3) {
        //NOT USED
    }

    @Override
    public boolean shouldDraw() {
        return false;
    }
}

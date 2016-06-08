package com.kerpow.games.freethrow.server;

import com.kerpow.games.freethrow.common.FreeThrowMessageHandlers;
import com.kerpow.games.freethrow.common.message.ReadyOuterClass;
import com.kerpow.games.freethrow.common.message.ShotOuterClass;
import com.kerpow.games.packets.PacketProcessor;
import com.kerpow.games.server.Player;
import com.kerpow.games.server.Server;
import com.kerpow.games.server.ServerInfo;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FreeThrowServer extends Server<ServerInfo> {

    private static final long MATCHMAKING_TICK = 1000;

    private static final int GAME_SIZE = 2;

    private List<FreeThrowPlayer> matchmakingQueue = new ArrayList<>();

    public FreeThrowServer(ServerInfo serverInfo) {
        super(serverInfo, new PacketProcessor(FreeThrowMessageHandlers.HANDLERS));
        addValidator(new FreeThrowValidator());
        executorService.scheduleAtFixedRate(this::matchmakingLoop, 0, MATCHMAKING_TICK, TimeUnit.MILLISECONDS);
        getPacketProcessor().<FreeThrowPlayer, ReadyOuterClass.Ready>addListener(ReadyOuterClass.Ready.class, (player, message) -> {
            player.game.ready(player);
        });
        getPacketProcessor().<FreeThrowPlayer, ShotOuterClass.Shot>addListener(ShotOuterClass.Shot.class, (player, message) -> {
            player.game.shot(player, message);
        });
    }

    private void matchmakingLoop() {
        synchronized (matchmakingQueue) {
            while (matchmakingQueue.size() >= GAME_SIZE) {
                FreeThrowGame game = new FreeThrowGame();
                for (int i = 0; i < GAME_SIZE; i++) {
                    FreeThrowPlayer player = matchmakingQueue.get(0);
                    player.game = game;
                    game.players.add(player);
                    matchmakingQueue.remove(0);
                }
                game.start();
            }
        }
    }

    @Override
    protected Player createPlayer(Channel channel) {
        return new FreeThrowPlayer(channel);
    }

    @Override
    public void connected(Player player) {
        System.out.println("Player connected");
        synchronized (matchmakingQueue) {
            matchmakingQueue.add((FreeThrowPlayer)player);
        }
    }

    @Override
    public void disconnected(Player player) {
        FreeThrowPlayer fPlayer = (FreeThrowPlayer) player;
        synchronized (matchmakingQueue) {
            if (fPlayer.game != null) {

            } else {
                matchmakingQueue.remove(fPlayer);
            }
        }
    }
}

package com.kerpow.games.freethrow.server;

import com.kerpow.games.server.ServerBootstrapper;
import com.kerpow.games.server.ServerInfo;
import io.netty.bootstrap.ServerBootstrap;

/**
 * Created by Steveadoo on 5/31/2016.
 */
public class Main {

    public static void main(String[] args) {
        ServerBootstrapper bootstrapper = new ServerBootstrapper();
        bootstrapper.bootstrap(new FreeThrowServer(new ServerInfo(6895, 10000)));
    }
}

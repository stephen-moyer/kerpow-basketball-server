package com.kerpow.games.freethrow.common.message;

import com.kerpow.games.freethrow.common.message.messages.*;
import com.kerpow.games.packets.MessageHandler;
import com.kerpow.games.packets.protobuf.ProtobufHandler;

import java.util.ArrayList;
import java.util.List;

public class FreeThrowMessageHandlers {

    public static List<MessageHandler> HANDLERS = new ArrayList<MessageHandler>();

    public static final int VALIDATION_ID = 0;

    static {
        HANDLERS.add(ProtobufHandler.create(VALIDATION_ID, ValidationOuterClass.Validation.getDefaultInstance()));
        HANDLERS.add(ProtobufHandler.create(10, OpponentFoundOuterClass.OpponentFound.getDefaultInstance()));
        HANDLERS.add(ProtobufHandler.create(11, ReadyOuterClass.Ready.getDefaultInstance()));
        HANDLERS.add(ProtobufHandler.create(12, ShotOuterClass.Shot.getDefaultInstance()));
        HANDLERS.add(ProtobufHandler.create(13, ScoredOuterClass.Scored.getDefaultInstance()));
    }

}
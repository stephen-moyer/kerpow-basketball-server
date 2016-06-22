package com.kerpow.games.freethrow.server;

import com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass;
import com.kerpow.games.server.Player;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Steveadoo on 6/4/2016.
 */
public class FreeThrowValidator implements com.kerpow.games.server.validation.Validator {

    @Override
    public void init() {

    }

    @Override
    public boolean matches(Class<?> clazz) {
        return clazz == ValidationOuterClass.Validation.class;
    }

    @Override
    public CompletableFuture<Boolean> validate(Player p, Object o) {
        System.out.println("Player validating");
        //TODO rework this so we dont need to cast
        ValidationOuterClass.Validation message = (ValidationOuterClass.Validation) o;
        FreeThrowPlayer player = (FreeThrowPlayer) p;
        player.id = message.getId();
        //eventually validate against api using the messages.getToken()
        return CompletableFuture.completedFuture(true);
    }
}

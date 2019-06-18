package com.company.castelDemo;

/**
 * @author Jeremy
 * @create 2019/6/13-10:33
 */
public class ByeHandler extends Handler {
    public ByeHandler(Game game) {
        super(game);
    }

    public boolean isBye(){
        return true;
    }
}
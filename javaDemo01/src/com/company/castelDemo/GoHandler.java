package com.company.castelDemo;

/**
 * @author Jeremy
 * @create 2019/6/13-10:33
 */
public class GoHandler extends Handler {
    public GoHandler(Game game) {
        super(game);
    }

    public  void doCmd(String word){
         game.goRoom(word);
        }
    }



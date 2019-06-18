package com.company.castelDemo;

/**
 * @author Jeremy
 * @create 2019/6/13-10:33
 */
public class HelpHandler extends Handler {
    public HelpHandler(Game game) {
        super(game);
    }

    public  void doCmd(String word){

            System.out.print("迷路了吗？你可以做的命令有：go bye help");
            System.out.println("如：go east");
    }
}

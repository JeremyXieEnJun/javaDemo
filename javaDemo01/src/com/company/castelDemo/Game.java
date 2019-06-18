package com.company.castelDemo;

/**
 * @author Jeremy
 * @create 2019/6/12-11:56
 *
 * 通过Castel这个小游戏对Java的设计原则进行测试和体会：
 * 测试Java的设计原则总结：
 *   1、取消代码的复制：消除代码复制的两个基本手段，就是函数和父类。
 *   2、封装：将属性和操作放在一个类中。 要求Game类不允许直接使用Room类的成员变量，需要用对象进行调用。 从而降低耦合。
 *
 *      容器：使用容器实现软编码。将有拓展需要的成员变量用集合装起来，可以实现该类变量的灵活拓展。
 *   3、代码可拓展：可扩展性：意思就是代码的某些部分不需要经过修改就能适应将来可能的变化。
 *                 使用容器实现软编码。 以框架 + 数据来提高可拓展性和灵活性，可以任意地添加。用HashMap <K , V>
 *   4、聚合的定义： 聚合（Cohesion）是一个模块内部各成分之间相关联程度的度量。
 *                 用接口来实现聚合，在类里面调用对接口的实现类，这样就实现了类的聚合。
 *   5、耦合的定义：耦合（Couping）是模块之间相关联程度的度量。
 *                 实现解耦的方法：利用private事项类的属性和操作的封装。
 *   6、对程序代码的要求：“高内聚，低耦合”。
 *   7、对内部类的使用测试。
     8、如果ioc是处理解耦的话，那么aop就是来提升内聚的。
        通过静态，动态代理来实现高内聚。
 */
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap <String , Handler> handlers = new HashMap<String , Handler>();

    public Game() {
        // 以下为用户命令
        handlers.put("go", new GoHandler(this));
        handlers.put("bye", new ByeHandler(this));
        handlers.put("help", new HelpHandler(this));

        createRooms();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;

        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        //	初始化房间的出口
        outside.setExit("east",lobby);
        outside.setExit("south",study);
        outside.setExit("west",pub);
        lobby.setExit("west",outside);
        pub.setExit("east",outside);
        study.setExit("north",outside);
        study.setExit("east",bedroom);
        study.setExit("west",study);
        outside.setExit("up",pub);
        pub.setExit("down",outside);

        currentRoom = outside;  //	从城堡门外开始  初始房间
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();

        chuKouList();

    }



    public  void play(){
        Scanner in = new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if(words.length >1){
                value = words[1];  //go east
            }
            if( handler!=null ){
                handler.doCmd(value);
                if(handler.isBye()){
                    break;
                }
            }
        }
        in.close();
    }

    public void goRoom(String direction)
    {
        Room nextRoom  =  currentRoom.getNextRoom(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            chuKouList();
        }
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.printWelcome();
        game.play();



        System.out.println("感谢您的光临。再见！");

    }

   void chuKouList(){
       System.out.println("你在" + currentRoom);
       System.out.print("出口有: ");

       System.out.print(currentRoom.getExitDesc());
      System.out.println();
  }
}

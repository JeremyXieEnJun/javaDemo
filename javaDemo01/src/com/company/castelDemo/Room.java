package com.company.castelDemo;

import java.util.HashMap;

/**
 * @author Jeremy
 * @create 2019/6/12-11:57
 *
 */
public class Room {
    //对Room的描述
    private String description;

    private HashMap<String,Room> exits = new HashMap<String,Room>();

    public Room(String description)
    {
        this.description = description;
    }

    //设置房间在各个方向的房间
    public void setExit(String dir,Room room)
    {
        exits.put(dir,room);
    }

    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for(String dir : exits.keySet()){
            sb.append(dir+" ");
        }
        return sb.toString();
    }
    public Room getNextRoom(String direction){

        return exits.get(direction);
    }
    @Override
    public String toString()
    {
        return description;
    }
}


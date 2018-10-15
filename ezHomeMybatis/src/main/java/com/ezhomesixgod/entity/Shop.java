package com.ezhomesixgod.entity;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-13 14:46
 */
public class Shop {
    private String name;

    private String head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}

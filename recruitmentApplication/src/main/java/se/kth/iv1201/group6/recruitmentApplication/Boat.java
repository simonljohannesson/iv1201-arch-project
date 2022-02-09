package se.kth.iv1201.group6.recruitmentApplication;

public class Boat {

    private String name;

    public Boat(String name, int len, int width) {
        this.name = name;
        this.len = len;
        this.width = width;
    }

    private int len;
    private int width;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString(){
        return "Boat {\n\tname: " +  this.name + "\n\tlength: " + this.len + "\n\twidth: " + this.width + "\n}";
    }
}

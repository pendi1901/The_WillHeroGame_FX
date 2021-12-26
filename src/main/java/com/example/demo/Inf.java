package com.example.demo;

import java.io.Serializable;

public class Inf implements Serializable {
    private int x;
    private int y;
    private int len;
    private int brt;
    Inf(){
        this.x = 0;
        this.y = 0;
        this.len = 0;
        this.brt = 0;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getLen() {
        return len;
    }
    public int getBrt() {
        return brt;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setLen(int len) {
        this.len = len;
    }
    public void setBrt(int brt) {
        this.brt = brt;
    }
    public void changeX(int x) {
        this.x += x;
    }
    public void changeY(int y) {
        this.y += y;
    }
}

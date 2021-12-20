package com.example.demo;

public abstract class GameObject {
    private Inf inf;
    GameObject(){
        inf = new Inf();
    }
    public Inf getInf() {
        return inf;
    }
    public void setInf(int x, int y, int len, int brt) {
        this.inf.setX(x);
        this.inf.setY(y);
        this.inf.setLen(len);
        this.inf.setBrt(brt);
    }
    public abstract void display();
    public abstract void hide();
}

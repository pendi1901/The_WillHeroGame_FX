package com.example.demo;

class Orcs {
    private final int orctype;
    private final int power;
    private final int killcoins;

    public Orcs(int orctype, int power, int killcoins) {
        this.orctype = orctype;
        this.killcoins = killcoins;
        this.power = power;
    }

    public void push() {

    }

    public void display(){

    }

    public void hide(){

    }

    public int getKillcoins(){
        return this.killcoins;
    }

    public int getOrctype(){
        return this.orctype;
    }
}

class RedOrc extends Orcs{

    public RedOrc(int orctype, int power, int killcoins) {
        super(orctype, power, killcoins);
    }
}

class GreenOrc extends Orcs{

    public GreenOrc(int orctype, int power, int killcoins) {
        super(orctype, power, killcoins);
    }
}

class BossOrc extends Orcs{

    public BossOrc(int orctype, int power, int killcoins) {
        super(orctype, power, killcoins);
    }
}





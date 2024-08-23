package com.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
        seeHouse();
        HeTong();
        getPrice();
    }

    //看房
    public void seeHouse(){
        System.out.println("看房");
    }

    //收费
    public void getPrice(){
        System.out.println("收费");
    }

    //签合同
    public void HeTong(){
        System.out.println("签合同");
    }


}

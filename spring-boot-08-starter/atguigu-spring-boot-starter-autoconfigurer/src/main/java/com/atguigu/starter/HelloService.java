package com.atguigu.starter;

public class HelloService {

    HelloProperties helloProperties;//定义一个配置类

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    //定义一个设置配置的方法
    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloAtguigu(String name){
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }


}

package jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DoMain {
    public static void main(String[] args) {
        //基于JDK的动态代理实现
        JdkProxyHandler jdkProxyHandler = new JdkProxyHandler(new DemoServiceImpl());
        DemoService demoService = (DemoService) Proxy.newProxyInstance(DoMain.class.getClassLoader(), new Class[]{DemoService.class}, jdkProxyHandler);
        System.out.println(demoService.getClass().getName());
        demoService.request("name");

        //这里是把生成代理类的源码输出
        try (FileOutputStream out = new FileOutputStream("$Proxy0.class")) {
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", DemoServiceImpl.class.getInterfaces());
            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxyHandler implements InvocationHandler {

    private DemoService demoService;

    public JdkProxyHandler(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(method.toString());
        System.out.println("前置");

        Object invoke = method.invoke(demoService, args);

        System.out.println("后置");

        return invoke;
    }
}

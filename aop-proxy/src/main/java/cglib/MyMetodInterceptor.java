package cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理回调拦截处理
public class MyMetodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置");

        Object invokeSuper = methodProxy.invokeSuper(o, objects);

        System.out.println("后置");
        return invokeSuper;
    }
}

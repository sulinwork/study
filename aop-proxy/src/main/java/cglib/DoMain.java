package cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class DoMain {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SendService.class);
        enhancer.setCallback(new MyMetodInterceptor());
        SendService sendService = (SendService) enhancer.create();
        System.out.println(sendService.getClass().getName());
        sendService.send("hello world");
    }
}

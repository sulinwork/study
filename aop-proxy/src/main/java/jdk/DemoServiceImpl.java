package jdk;

public class DemoServiceImpl implements DemoService {
    @Override
    public void request(String name) {
        System.out.println("request:" + name);
    }
}

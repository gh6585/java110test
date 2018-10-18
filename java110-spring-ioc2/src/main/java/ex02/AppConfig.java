package ex02;

public class AppConfig {
    
    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }
    
    public Car getCar() {
        System.out.println("getCar() 호출됨!");
        Car c = new Car();
        c.setModel("소나타");
        c.setCc(1998);
        c.setMaker("현대자동차");
        return c;
        
    }

}

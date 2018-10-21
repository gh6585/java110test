package ex06;

import org.springframework.beans.factory.FactoryBean;

public class EngineFactory3 implements FactoryBean<Engine> {
    
    String model;
    
    
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("EngineFactory3.getOjbectType()");
        // 공장에서 생상하는 객체의 타입을 알려주기 위해 리턴한다.
        // 스프링 IoC 컨테이너는 공장을 통해 객체를 생성하기 전에
        // 이 메서드를 먼저 호출하여 타입을 알아낼 것이다.
        return Engine.class;
    }
    
    @Override
    public Engine getObject() throws Exception {
        System.out.println("EngineFacotry3.getObject()");
        // 스프링 IoC 컨테이너는 객체를 생성할 때
        // 이 메서드르 호출할 것이다.

        Engine e = new Engine();
        
        switch (model) {
        case "B100":
            e.setMaker("비트자동차");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "B200":
            e.setMaker("비트자동차");
            e.setValve(32);
            e.setDiesel(true);
            break;
        case "H01":
            e.setMaker("현대자동차");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "HX9":
            e.setMaker("현대자동차");
            e.setValve(32);
            e.setDiesel(true);
            break;
        default:
            e.setMaker("오호라자동차");
            e.setValve(8);
            e.setDiesel(false);
        }
        
        return e;
    }
}

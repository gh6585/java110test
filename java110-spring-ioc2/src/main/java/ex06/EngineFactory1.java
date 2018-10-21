package ex06;



// 스프링 프레임 워크의 규칙에 따라 공장 클래스 만들기
// => Fctorybean 인터페이스르 구현해야 한다.
//

public class EngineFactory1 {
    
    public static Engine create(String model) {
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

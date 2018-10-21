    package ex07;
    
    import java.beans.PropertyEditorSupport;
    
    public class EnginePropertyEditor  extends PropertyEditorSupport{
    
        public EnginePropertyEditor() {
            System.out.println("EnginePropertyEditor() 호출됨!");
        }
        
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            System.out.println("EnginePropertyEditor.setAsText");
            
           String[] values = text.split(",");
           Engine engine = new Engine();
           
           engine.setMaker(values[0]);
           engine.setValve(Integer.parseInt(values[1]));
           engine.setDiesel(Boolean.parseBoolean(values[2]));
           
           this.setValue(engine);
        }
    }
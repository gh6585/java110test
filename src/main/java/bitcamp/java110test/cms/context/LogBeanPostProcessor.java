package bitcamp.java110test.cms.context;

import java.util.Collection;

import bitcamp.java110test.cms.annotation.Component;

@Component
public class LogBeanPostProcessor implements BeanPostProcessor{
    
   ApplicationContext beanContainer;
   
   
   @Override
    public void postProcess(ApplicationContext beanContainer) {
       Collection<Object> objList = beanContainer.objPool.values();
       
       System.out.println("-----------------");
       for(Object obj : objList) {
           System.out.println(obj.getClass().getName());
       }
       System.out.println("--------------");
       
    }
   
}

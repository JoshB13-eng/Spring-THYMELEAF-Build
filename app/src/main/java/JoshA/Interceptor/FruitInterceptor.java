
//My Interceptor class
//
package JoshA.Interceptor;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 import org.springframework.stereotype.Component; 
import org.springframework.web.servlet.HandlerInterceptor; 
import org.springframework.web.servlet.ModelAndView; 
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import JoshA.Control.FruitController;

@Component 
public class FruitInterceptor implements HandlerInterceptor {   
    //
    @Override  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        //
        
        System.out.println("\n\nThe request's URL that calls the servlet is-->["+request.getServletPath()+"]");
        //
        System.out.println("The kind of request sent is-->["+request.getMethod()+"]");
        //
        
        System.out.println("The query string that is contained in the request URL after the path is-->["+request.getQueryString()+"]");
        //
        return true;
    }   
    
    //Dont need the postHandle method
    
    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{   
        //Exit application
        
        if(request.getServletPath().equals("/JoshFruit/Exit")){
            //if the request URL sent is "/JoshFruit/Exit"
            System.out.println("\nShutting down Server.....");
            
            System.exit(0);
            //Exit app
        }
        
    }
    
 }
 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

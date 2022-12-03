
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


public class Apple{
    
    public Integer numberOfApple;
    
    public Integer amount;
    
    public Apple(){}
    
    public void setNumberOfApple(Integer numberOfApple){
        this.numberOfApple = numberOfApple;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfApple(){
        return this.numberOfApple;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfApple+" Apple(s) is "+this.amount;
    }
    
}

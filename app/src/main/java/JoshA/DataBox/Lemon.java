
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


public class Lemon{
    
    public Integer numberOfLemon;
    
    public Integer amount;
    
    
    public Lemon(){}
    
    public void setNumberOfLemon(Integer numberOfLemon){
        this.numberOfLemon = numberOfLemon;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfLemon(){
        return this.numberOfLemon;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfLemon+" Lemon(s) is "+this.amount;
    }
    
}
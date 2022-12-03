
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


public class Orange{
    //
    
    public Integer numberOfOrange;
    
    public Integer amount;
    
    public Orange(){}
    
    public void setNumberOfOrange(Integer numberOfOrange){
        this.numberOfOrange = numberOfOrange;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfOrange(){
        return this.numberOfOrange;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfOrange+" orange(s) is "+this.amount;
    }
    
}
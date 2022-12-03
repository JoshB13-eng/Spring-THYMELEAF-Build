
//My Fruit Model class
 
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Fruit implements Serializable{
    //
    public static final long serUID = 2L;
    
    public Integer numberOfFruit;
    
    public Orange orange;
    //
    public Apple apple;
    //
    public Lemon lemon;
    //
    @JsonIgnore
    public byte[] fileByt;
    //
    public Fruit(){}
    
    public void setOrange(Orange orange){
        this.orange = orange;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }
    
    public void setLemon(Lemon lemon){
        this.lemon = lemon;
    }
    
    public void setByte(byte[] fileByt){
        this.fileByt = fileByt;
    }
    
    public void setNumberOfFruit(Integer numberOfFruit){
        this.numberOfFruit = numberOfFruit;
    }
    
    public Integer getNumberOfFruit(){
        return this.numberOfFruit;
    }
    
    public Orange getOrange(){
        return this.orange;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public Lemon getLemon(){
        return this.lemon;
    }
    
    @JsonIgnore
    public byte[] getByte(){
        return this.fileByt;
    }
    
    @Override public String toString(){
        return "Apple :"+this.apple.toString()+"\nLemon :"+this.lemon.toString()+"\nOrange :"+this.orange.toString();
    }
}

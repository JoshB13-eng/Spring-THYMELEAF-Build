
//My Controller class

package JoshA.Control;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestHeader; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import org.springframework.core.io.InputStreamResource;
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import JoshA.DataBox.*;


@Controller
@RequestMapping(path = "/JoshFruit")
public class FruitController{
    
    public static String Client;
    public String fle;
    
    public Map<Integer,Fruit> fruit;
    
    public FruitController(){
        this.fruit = new HashMap();
        Fruit fruitObj = new Fruit();
        
        Apple apple = new Apple();
        apple.setNumberOfApple(5);
        apple.setAmount(500);
        
        Lemon lemon = new Lemon();
        lemon.setNumberOfLemon(5);
        lemon.setAmount(250);
        
        Orange orange = new Orange();
        orange.setNumberOfOrange(5);
        orange.setAmount(150);
        
        fruitObj.setApple(apple);
        fruitObj.setLemon(lemon);
        fruitObj.setOrange(orange);
        
        this.fruit.put(1,fruitObj);
        
        Fruit fruitObj2 = new Fruit();
        
        Apple apple2 = new Apple();
        apple2.setNumberOfApple(5);
        apple2.setAmount(500);
        
        Lemon lemon2 = new Lemon();
        lemon2.setNumberOfLemon(5);
        lemon2.setAmount(250);
        
        Orange orange2 = new Orange();
        orange2.setNumberOfOrange(5);
        orange2.setAmount(150);
        
        fruitObj2.setApple(apple2);
        fruitObj2.setLemon(lemon2);
        fruitObj2.setOrange(orange2);
        
        this.fruit.put(2,fruitObj2);
    }
    
    
    @GetMapping(path = "/Fruit", produces = "application/json")
    public ModelAndView getFruit(){
        //Get all fruit bean and send data to html to be viewed
        String Client;
        
        
        ModelAndView modelAndView = new ModelAndView();  

        modelAndView.setViewName("FruitView");      

        modelAndView.addObject("fruits",fruit.values().toString());
        
        return modelAndView;
        //
    }
    
    @RequestMapping(path = "/Starter")
    public String getFruitY(){
        //start browsing html pages
        return "Starter";
    }
    
    @PostMapping(value="/Upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView fileUpload(@RequestParam("Mfile") MultipartFile Mfile) throws IOException{
        //To upload file from html page
        fle = "./FileBox/"+Mfile.getOriginalFilename();
        
        File convertFile = new File(fle); 
       
        convertFile.createNewFile(); 
        
        FileOutputStream fout = new FileOutputStream(convertFile); 
        //
        fout.write(Mfile.getBytes()); 
        
        
        String opr = "\n"+Mfile.getOriginalFilename()+"has been uploaded successfully.";
        
        ModelAndView modelAndView = new ModelAndView();  

        modelAndView.setViewName("Upload-File");      

        modelAndView.addObject("opr",opr);
        //
        fout.close(); 
        //Closing OutputStream
        
        return modelAndView;
        
    } 
    
    @GetMapping(path = "/FruitX/{No1}/{No2}")
    public ModelAndView getFruitX(@PathVariable("No1") Integer No1, @PathVariable("No2") Integer No2){
        //Get two specific fruit bean with index from html page and send data to html to be viewed
        ModelAndView modelAndView = new ModelAndView();  
        
        modelAndView.setViewName("FruitXView");  
        
        if((!(this.fruit.containsKey(No1)))||(!(this.fruit.containsKey(No2)))){
            //If map header doesnt have FruitIndex gotten from the request PathVariable
            String str = "\nEither MapKey/FruitIndex "+No1+" or "+No2+" doesnt exist!!.\n Try getting MapKey/FruitIndex 1 and 2 if you have not deleted them.\n";
        
            modelAndView.addObject("fruitX", str);
            
            return modelAndView;
        }
        
        
        Map<Integer,Fruit> SpecifiedHeader = new HashMap<>();
        
        SpecifiedHeader.put(No1,this.fruit.get(No1));
        
        SpecifiedHeader.put(No2,this.fruit.get(No2));
        
        String str = "\nThese are Fruit index 1 and 2 members"+SpecifiedHeader.values().toString();
        modelAndView.addObject("fruitX", str);
        
        return modelAndView;
        //    
        
    }
    
    
    @GetMapping(path="/DownloadBye", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> download(String Name, Integer Age) throws Exception{
        //To download file from html page and to get user info from html page
        if(fle == null){
            fle = "./FileBox/";
        }
        
        FruitController.Client = "Name :"+Name + "\nAge :"+Age;
        
        String Client = "Thank you"+Name+"For Patnering with us";
        
        File file = new File(fle); 
        
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file)); 
        //
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Content-Disposition","attachment; filename="+file.getName()); 
        
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate"); 
        
        headers.add("Pragma", "no-cache");
        
        headers.add("Expires", "0"); 
        
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource); 
        
        return responseEntity;
    }
    
    @PutMapping(path = "/Fruit/Update/{FruitIndex}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> update(@RequestBody Fruit fruitp, @PathVariable("FruitIndex") Integer FruitIndex){
        //Update a fruit bean element in map from html page
        if(this.fruit.containsKey(FruitIndex)){
            
            this.fruit.remove(FruitIndex);
            
        } 
        
        this.fruit.put(FruitIndex,fruitp);
        //
        
        String str = "\nIndex "+FruitIndex+" of Fruit has been sucessfully updated\n";
        
        return new ResponseEntity<>(str, HttpStatus.OK);
        //
    }
    
    
    @RequestMapping(path = "/Exit")
    public ResponseEntity<Object> Exit(){
        //exit app
        return new ResponseEntity<>("\nShutting down server...\n", HttpStatus.OK);
    }
    
}


//Go to classpath src/main/resources/templates to see my html files

//To start browsing webpage enter the below URL
//Browsers: http://localhost:9090/JoshFruit/Starter

//To exit application
//Shell: curl http://localhost:9090/JoshFruit/Exit
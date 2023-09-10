package org.Rohit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiTest {
    //In the objectfactory spring looks for configuration and then it looks for @Bean annotaion.
    //there we have 2 beans for  clearing spring confusion just write @primary it select only @primary beans
    //for dependeancy injection...
    @Autowired
    mailSender hObj;
    @GetMapping("apitesting/java")
    public String test(){
        return "Rohit Tanwar";
    }
    @GetMapping("getCarApi/car")
    public mailSender getMess(){
        hObj.sendmail();
        return hObj;
    }

    @PutMapping("getCarApi/car")
    public void chngeMess(){
        hObj.setMess("Task of mail Integeration is Done !!! ");
    }



//    @GetMapping("twice/value/{x}/{y}")
//    public String nTwice(@PathVariable String x,@PathVariable String y){
//        return x+y;
//    }
}

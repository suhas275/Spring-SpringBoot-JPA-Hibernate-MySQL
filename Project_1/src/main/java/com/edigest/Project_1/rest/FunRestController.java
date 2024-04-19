package com.edigest.Project_1.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeaminfo(){
        return "coach: " + coachName + ", team name:" + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "hello world";
    
    }
     // expose a new endpoint for "workout"

     @GetMapping("/workout")
     public String getDailyWorkout() {
         return "Run a hard 5k!";
     }
 
     // expose a new endpoint for "fortune"
 
     @GetMapping("/fortune")
     public String getDailyFortune() {
         return "Today is your lucky day.";
     }
     @GetMapping("/suhas")
     public String getsuhas() {
         return "it's me suhas";
     }
     
}

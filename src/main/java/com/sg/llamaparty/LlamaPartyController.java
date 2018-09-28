/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.llamaparty;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author timpinkerton
 */
@Controller
public class LlamaPartyController {

    private List<String> daList = new ArrayList<>();
    private int totalLlamas = 0;
    private int numOfPeople; 

    @RequestMapping(value = "/rsvp",
            method = RequestMethod.GET)

    public String rsvp(HttpServletRequest request,
            Map<String, Object> model) {
        
        boolean boolKiddie; 
        
        String scriptKiddie = request.getParameter("scriptKiddie");
        
        try {
            boolKiddie = Boolean.parseBoolean(scriptKiddie); 
        } catch (Exception e) {
            boolKiddie = false; 
        }
        
        model.put("boolKiddie", boolKiddie); 
        return "rsvp";
    }

    @RequestMapping(value = "/rsvp",
            method = RequestMethod.POST)

    public String accepted(HttpServletRequest request,
            Map<String, Object> model) {
        

        

        String nameInput = request.getParameter("name");
        String numOfLlamasInput = request.getParameter("numOfLlamas");
        int numOfLlamas;

        String comingInput = request.getParameter("coming");

        try {
            numOfLlamas = Integer.parseInt(numOfLlamasInput);
        } catch (Exception e) {
            numOfLlamas = -1;
        }

        if (nameInput == null || numOfLlamas < 0) {
            return "notValid";
        } else if ("no".equals(comingInput)) {
            return "youSuck";
        }

        //add name to daList
        daList.add(nameInput);
        
        numOfPeople = daList.size(); 
        BigDecimal peopleAsBD = new BigDecimal(numOfPeople); 
        
        //add # of Llamas
        totalLlamas += numOfLlamas;
        BigDecimal llamasAsBD = new BigDecimal(totalLlamas); 
        
        BigDecimal llamasPerPerson = llamasAsBD.divide(peopleAsBD);
        
        model.put("llamasPerPerson", llamasPerPerson.setScale(2, RoundingMode.HALF_UP)); 
        
        
        
        return "accepted";
    }
    
    
    @RequestMapping(value = "/daList",
            method = RequestMethod.GET)

    public String daList(HttpServletRequest request,
            Map<String, Object> model) {
        
        model.put("daList", daList); 
        model.put("totalLlamas", totalLlamas);
        model.put("numOfPeople", numOfPeople); 

        return "daList";
    }

}

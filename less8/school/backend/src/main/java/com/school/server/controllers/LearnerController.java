package com.school.server.controllers;

import com.school.server.models.Learner;
import com.school.server.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;

@Controller
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {

        //modelMap.addAttribute("learner", learnerService.findLearnerById(1L));
        modelMap.addAttribute("learners", learnerService.findAllLearners());
        return "main";

    }

}

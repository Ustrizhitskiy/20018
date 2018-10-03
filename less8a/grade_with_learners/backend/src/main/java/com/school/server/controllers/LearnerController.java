package com.school.server.controllers;

import com.school.server.models.Grade;
import com.school.server.models.Learner;
import com.school.server.repository.GradeRepository;
import com.school.server.repository.LearnerRepository;
import com.school.server.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @Autowired
    LearnerRepository learnerRepository;

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {

        modelMap.addAttribute("learners", learnerService.findAllLearners());
        return "main";

    }

    // Получаем форму ввода
    @RequestMapping(value = {"/addlearner"}, method = RequestMethod.GET)    // Событие из <a href="addlearner"> на main.html
    public String showAddLearnerPage(ModelMap modelMap) {

        Learner learner = new Learner();
        modelMap.addAttribute("learnerForm", learner);  // Название формы из create_learner.html
        return "create_learner";   // На какой странице это делаем (create_learner.html)

    }

    // Отправляем форму ввода
    @RequestMapping(method = RequestMethod.POST)
    public String saveLearner(ModelMap model, @ModelAttribute("learnerForm") Learner learnerForm) {

        String firstName = learnerForm.getFirstName();
        String lastName = learnerForm.getLastName();
        String gradeName = learnerForm.getGradeName();
        Grade grade = learnerService.getGradeByName(gradeName);

        // Имена переменных такие же, как в поле "field" в create_learner.html (th:field="*{firstName}")
        Learner newLearner = new Learner(firstName, lastName, grade.getId(), grade.getGradeName());
        learnerService.saveLearner(newLearner);

        model.addAttribute("learners", learnerService.findAllLearners());
        model.addAttribute("gradeName", grade.getGradeName());
        return "redirect:/main";    // возвращаем перезагруженную страницу main

    }

    @RequestMapping(value = {"/find with id = 3"}, method = RequestMethod.GET)
    public String findingLearner(ModelMap modelMap) {

        modelMap.addAttribute("learner3", learnerService.findLearnerById(3L));
        return "find_by_id";
    }

}

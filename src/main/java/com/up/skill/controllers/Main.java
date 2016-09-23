package com.up.skill.controllers;

import com.up.skill.helpers.Library;
import com.up.skill.models.*;
import com.up.skill.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Multi Cabz on 9/21/2016.
 */

@Controller
public class Main{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Main.class);
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String index() {
        //MyClass myClass = new MyClass();
        //MyClass  view = new MyClass("main/index");
        //MyClass  neil = new MyClass(1,"/main");

        //view.setMyView("main/index");

        //List<Person> people = new ArrayList<Person>();
        /*Customer customer = new Customer();
        Employee employee = new Employee();

        people.add(people.customer);
        people.add(people.employee);*/

        //return view.getMyView();
        return "main/index";
    }
    /*model.setViewName()*/
    @RequestMapping(value="/main",method = RequestMethod.POST)

    public ModelAndView indexPost(@ModelAttribute @Valid MyForm myForm,
                                  ModelAndView model,
                                  WebRequest request,
                                  HttpServletResponse response,
                                  BindingResult bindingResult) {

        if(!bindingResult.hasErrors()){
            //LOGGER.info('Test!');
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            MyForm myFormInDb = (MyForm) session.get(MyForm.class, myForm.getEmail());

            model.setViewName("main/thankyou");
        }

        return model;
    }

}

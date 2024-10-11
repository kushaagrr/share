package com.nagarro.controller;

import com.nagarro.dao.TshirtDaoImpl;
import com.nagarro.model.Tshirt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OnFormSubmit {

    @RequestMapping("/search")
    public ModelAndView search(HttpServletRequest req, HttpServletResponse res){
        String color = String.valueOf(req.getParameter("color"));
        String size = String.valueOf(req.getParameter("size"));
        String gender = String.valueOf(req.getParameter("gender"));
        String output = String.valueOf(req.getParameter("output"));


        TshirtDaoImpl shirts = new TshirtDaoImpl();
        List<Tshirt> resShirts = shirts.getShirt(color, size, gender);
        resShirts = shirts.getShirtByPreference(resShirts, output);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", resShirts);
        return mv;
    }
}

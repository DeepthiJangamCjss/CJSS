package com.example.mappingProject.controller;

import com.example.mappingProject.entity.User;
import com.example.mappingProject.models.Address;
import com.example.mappingProject.models.AdminModel;
import com.example.mappingProject.models.UserModel;
import com.example.mappingProject.service.AdminService;
import com.example.mappingProject.service.UserService;
import com.example.mappingProject.validation.AdminValidation;
import com.example.mappingProject.validation.NewValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private AdminValidation adminValidation;
    @Autowired
    private NewValidation validation;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String start(){
        return "start";
    }

    @RequestMapping("/admin")
    public String adminStartPage(Model model)
    {
        model.addAttribute("adminModel",new AdminModel());
        return "adminStart";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@Valid AdminModel adminModel,BindingResult bindingResult){
        System.out.println(adminModel);
        adminValidation.validate(adminModel,bindingResult);
        boolean isAdmin =  adminService.checkCredentials(adminModel);
        if(isAdmin){
            return "adminMainPage";
        }
        return "adminStart";
    }

    @RequestMapping("/adminMainPage")
    public String adminMainPage(){
        return "adminMainPage";
    }

    @RequestMapping("/user")
    public String userStartPage(){
        return "userStart";
    }

    @RequestMapping("/userRegister")
    public String userRegister(){
        return "userRegister";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        boolean isAvailable = userService.checkUsernameAvailability(username);

        if (isAvailable) {
            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);

            model.addAttribute("userModel", userModel);  // Add userModel as a model attribute
            return "userDetailsEnter";
        }
        return "userAlreadyExists";
    }
    @RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
    public String saveUserDetails(@Valid UserModel userModel, BindingResult bindingResult) {
        validation.validate(userModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "userDetailsEnter"; // Update to the actual name of your JSP page
        }

        // Continue with your logic
        userService.saveUserDetails(userModel);
        return "userStart";
    }

    @RequestMapping("/userLogin")
    public String userLogin(){
        return "userLogin";
    }

    @RequestMapping("/userLoginToWebsite")
    public String userLoginToWebsite(String username,String password,Model model){
        UserModel userModel=userService.getUser(username,password);
        if(userModel==null){
            return "userStart";
        }
        System.out.println(userModel);
        model.addAttribute("userModel",userModel);
        return "userMainPage";
    }
}

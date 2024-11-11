package com.nhnacademy.springbootmvc.controller;


import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/user")
//    public String getUsers(/* TODO 1: 적절한 모델 type 넣기 */) {
//        List<User> users = userRepository.getUsers();
//        //TODO 2: user 목록을 모델의 attribute 추가
//        return "users";
//    }
//    @GetMapping("/user")
//    public ModelAndView getUsers() {
//        List<User> users = userRepository.getUsers();
//        ModelAndView modelAndView = new ModelAndView("users"); // 뷰 이름 설정
//        modelAndView.addObject("users", users); // 데이터를 뷰에 추가
//        return modelAndView;
//    }

//    @GetMapping("/user")
//    public ModelAndView getUser(@RequestParam(name = "order") String order,
//                                @RequestParam(name = "userid") String userId) {
//        // 메서드 로직
//        List<User> users = userRepository.getUsers();
//        ModelAndView modelAndView = new ModelAndView("users"); // 뷰 이름 설정
//        modelAndView.addObject("users", users); // 데이터를 뷰에 추가
//        modelAndView.addObject("order", order);
//        modelAndView.addObject("userId", userId);
//
//        return modelAndView;
//    }
    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable(name = "userId") String userId, Model model) {
        User user = userRepository.getUser(userId);
        model.addAttribute("user", user);
        return "user_info";
    }
}

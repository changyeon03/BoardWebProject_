package BoardWeb.controller;

import BoardWeb.dto.UserDTO;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //홈 화면 (view)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    //로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(UserDTO userDTO, HttpSession httpSession) throws Exception {

        //세션에 이미 값이 있다면 제거한다.
        if(httpSession.getAttribute("user")!=null)
        {
            httpSession.removeAttribute("user");
        }

        //등록된 유져가 맞다면 세션으로 account넘겨준다.
        if(userService.checkPwd(userDTO))
        {
            httpSession.setAttribute("user", userDTO.getAccount());
            return "redirect:/board";
        }
        else
            return "redirect:/login";
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout (HttpSession httpSession) {
        //세션 초기화
        httpSession.invalidate();
        return "redirect:/login";
    }

    //회원가입 (view)
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignup(UserDTO userDTO) throws Exception {
        //회원가입 완료
        if(userService.insertUser(userDTO))
        {
            return "redirect:/login";
        }
        //회원가입 미 완료
        else return "redirect:/signup";
    }
}
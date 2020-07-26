package BoardWeb.controller;

import BoardWeb.dto.MessageDTO;
import BoardWeb.service.MessageService;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String getMyMessage(HttpSession httpSession, Model model)
    {
        model.addAttribute("msg", (List<MessageDTO>)messageService.getMyMessage(httpSession.getAttribute("user").toString()));
        return "viewMessage";
    }

    @RequestMapping(value = "/writeMessage", method = RequestMethod.GET)
    public String writeMessage(HttpSession httpSession, Model model)
    {
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "writeMessage";
    }

    @RequestMapping(value = "/writeMessage/{to_nick_name}", method = RequestMethod.GET)
    public String writeMessage(@PathVariable("to_nick_name") String to_nick_name, Model model, HttpSession httpSession)
    {
        model.addAttribute("user", httpSession.getAttribute("user"));
        model.addAttribute("to_account", userService.getAccount(to_nick_name));
        System.out.println(userService.getAccount(to_nick_name));
        return "writeMessageTo";
    }

    @RequestMapping(value = "/writeMessage", method = RequestMethod.POST)
    public String writeMessage(MessageDTO messageDTO)
    {
        messageService.sendMessage(messageDTO);
        return "redirect:/msg";
    }
}

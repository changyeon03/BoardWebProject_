package BoardWeb.controller;

import BoardWeb.dto.MsgDTO;
import BoardWeb.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MegController {

    @Autowired
    MsgService msgService;

    @RequestMapping(value = "/msg/{id}", method = RequestMethod.GET)
    public String getMyMessage(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("msg", (List<MsgDTO>)msgService.getMyMessage(id));
        return "viewMessage";
    }
}

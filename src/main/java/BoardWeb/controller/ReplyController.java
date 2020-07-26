package BoardWeb.controller;

import BoardWeb.dto.ReplyDTO;
import BoardWeb.repository.ReplyMapper;
import BoardWeb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public String writeReply (ReplyDTO replyDTO)
    {
        replyService.writeReply(replyDTO);
        return "redirect:/board/"+replyDTO.getBoard_id();
    }

    @RequestMapping(value = "/reply/delete/{id}", method = RequestMethod.GET)
    public String deleteReply(@PathVariable("id") Long id, HttpSession httpSession)
    {
        return "redirect:/board/"+replyService.deleteReply(id, httpSession.getAttribute("user"));
    }

    @RequestMapping(value = "/reply/modify/{id}", method = RequestMethod.GET)
    public String getModifyReply(@PathVariable("id") Long id, Model model, HttpSession httpSession)
    {
        if(replyService.checkSame(id, httpSession.getAttribute("user"))) {
            model.addAttribute("reply", replyService.getReply(id));
            return "replymodify";
        }
        return "redirect:/board/"+replyService.getBoardId(id);
    }

    @RequestMapping(value = "/reply/modify", method = RequestMethod.POST)
    public String postModifyReply(ReplyDTO replyDTO)
    {
        return "redirect:/board/"+replyService.modifyReply(replyDTO);
    }
}

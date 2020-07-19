package BoardWeb.controller;

import BoardWeb.dto.BoardDTO;
import BoardWeb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String getBoardList(Model model) throws Exception {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String getWrite(Model model, HttpSession httpSession) throws Exception {
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "write";
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public String writeBoard(BoardDTO boardDTO) throws Exception {

        boardService.write(boardDTO);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public String viewBoard(@PathVariable("id") Long id, Model model) {
        List<BoardDTO> view = boardService.view(id);
        model.addAttribute("view", view);
        return "view";
    }

    @RequestMapping(value = "/board/delete/{id}", method = RequestMethod.GET)
    public String deleteBoard(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable("id") Long id, Model model) {
        List<BoardDTO> view = boardService.view(id);
        model.addAttribute("modify", view);
        return "modify";
    }

    @RequestMapping(value = "/board/modify", method = RequestMethod.POST)
    public String modify(BoardDTO boardDTO) {
        boardService.modify(boardDTO);
        return "redirect:/board/"+boardDTO.getId();
    }

}

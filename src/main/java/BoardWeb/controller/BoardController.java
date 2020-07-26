package BoardWeb.controller;

import BoardWeb.dto.BoardDTO;
import BoardWeb.dto.CriteriaDTO;
import BoardWeb.dto.PageDTO;
import BoardWeb.dto.ReplyDTO;
import BoardWeb.repository.UserMapper;
import BoardWeb.service.BoardService;
import BoardWeb.service.ReplyService;
import BoardWeb.service.UserService;
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

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    //게시판 (view)
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String getBoardList(Model model) throws Exception {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "list";
    }

    /*
    //페이지 네이션
    @RequestMapping(value = "/board/listPage", method = RequestMethod.GET)
    public String listPage(@ModelAttribute("cri") CriteriaDTO cri, Model model) throws Exception {
        model.addAttribute("list", boardService.getBoardList());
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCri(cri);
        pageDTO.setTotalCount(boardService.getTotalBoard());
        model.addAttribute("pageMaker", pageDTO);

        return "pagelist";
    }
    */

    //게시글 작성 GET
    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String getWrite(Model model, HttpSession httpSession) throws Exception {
        //세션에 있는 정보를 이용해 계정과 닉네임을 뷰로 넘겨줌.
        model.addAttribute("user", httpSession.getAttribute("user"));
        model.addAttribute("nick_name", userService.getNick_name(httpSession.getAttribute("user")));
        return "write";
    }

    //게시글 작성 POST
    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String writeBoard(BoardDTO boardDTO) throws Exception {
        boardService.write(boardDTO);
        return "redirect:/board";
    }

    //게시글 조회
    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public String viewBoard(@PathVariable("id") Long id, Model model, HttpSession httpSession) {
        //게시글, 댓글 view로 전달
        model.addAttribute("view", (List<BoardDTO>)boardService.view(id, httpSession.getAttribute("user")));
        model.addAttribute("reply", (List<ReplyDTO>)replyService.getReplyList(id));
        //유저 정보 view로 전달
        model.addAttribute("user", httpSession.getAttribute("user"));
        model.addAttribute("nick_name", userService.getNick_name(httpSession.getAttribute("user")));
        return "view";
    }

    //게시글 삭제
    @RequestMapping(value = "/board/delete/{id}", method = RequestMethod.GET)
    public String deleteBoard(@PathVariable("id") Long id, HttpSession httpSession) {
        if(boardService.delete(id, httpSession.getAttribute("user")))
            return "redirect:/board";
        else return "redirect:/board/"+id;
    }

    //게시글 수정
    @RequestMapping(value = "/board/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable("id") Long id, Model model, HttpSession httpSession) {
        model.addAttribute("modify", (List<BoardDTO>)boardService.view(id));
        if(boardService.checkSame(id, httpSession.getAttribute("user")))
            return "modify";
        else
            return "redirect:/board/"+id;
    }

    @RequestMapping(value = "/board/modify", method = RequestMethod.POST)
    public String modify(BoardDTO boardDTO) {
        boardService.modify(boardDTO);
        return "redirect:/board/"+boardDTO.getId();
    }

}

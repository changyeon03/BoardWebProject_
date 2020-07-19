package BoardWeb.service;

import BoardWeb.dto.BoardDTO;
import BoardWeb.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public void write(BoardDTO boardDTO) {
        boardMapper.writeBoard(boardDTO.getWriter_account(), boardDTO.getNick_name(), boardDTO.getTitle(), boardDTO.getContent());
    }

    @Override
    public List<BoardDTO> view(Long id) {
        return boardMapper.viewBoard(id);
    }

    @Override
    public void delete(Long id) {
        boardMapper.deleteBoard(id);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        boardMapper.modifyBoard(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getId());
    }
}

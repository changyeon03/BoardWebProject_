package BoardWeb.service;

import BoardWeb.dto.BoardDTO;
import BoardWeb.repository.BoardMapper;
import BoardWeb.repository.UserMapper;
import BoardWeb.repository.ViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ViewMapper viewMapper;

    @Override
    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public void write(BoardDTO boardDTO) {
        boardMapper.writeBoard(boardDTO);
    }

    @Override
    public List<BoardDTO> view(Long id, Object user) {
        Timestamp viewed_at = viewMapper.getViewed_at(id, user.toString());
        if(viewed_at==null) {
            viewMapper.insertViewed_at(id, user.toString());
            boardMapper.upViewCount(id);
        }

        else {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            long diff = now.getTime() - viewed_at.getTime();
            long diff_minute = (diff / 1000) / 60;
            if(diff_minute>=30) {
                viewMapper.setViewed_at(id, user.toString());
                boardMapper.upViewCount(id);
            }
        }

        return boardMapper.viewBoard(id);
    }

    @Override
    public List<BoardDTO> view(Long id) {
        return boardMapper.viewBoard(id);
    }

    @Override
    public boolean delete(Long id, Object user) {
        //게시물 작성자 정보와 세션에 있는 유저 정보를 비교하여 일치하면 delete 매퍼 호출
        if(((String) user).equals((String) boardMapper.getWriterAccount(id)))
        {
            boardMapper.deleteBoard(id);
            return true;
        }
        return false;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        boardMapper.modifyBoard(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getId());
    }

    @Override
    public boolean checkSame(Long id, Object user) {
        return ((String) user).equals((String) boardMapper.getWriterAccount(id));
    }

    @Override
    public int getTotalBoard() {
        return boardMapper.getTotalBoard();
    }
}

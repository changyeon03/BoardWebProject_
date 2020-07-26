package BoardWeb.service;

import BoardWeb.dto.BoardDTO;
import BoardWeb.repository.BoardMapper;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getBoardList();
    public void write(BoardDTO boardDTO);
    public List<BoardDTO> view(Long id, Object user);
    public List<BoardDTO> view(Long id);
    public boolean delete(Long id, Object user);
    public void modify(BoardDTO boardDTO);
    public boolean checkSame(Long id, Object user);
    public int getTotalBoard();
}

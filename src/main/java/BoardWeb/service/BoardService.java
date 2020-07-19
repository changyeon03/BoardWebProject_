package BoardWeb.service;

import BoardWeb.dto.BoardDTO;
import BoardWeb.repository.BoardMapper;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getBoardList();
    public void write(BoardDTO boardDTO);
    public List<BoardDTO> view(Long id);
    public void delete(Long id);
    public void modify(BoardDTO boardDTO);
}

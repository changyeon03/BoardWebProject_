package BoardWeb.service;

import BoardWeb.dto.ReplyDTO;
import BoardWeb.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ReplyService {

    public List<ReplyDTO> getReplyList(Long board_id);
    public void writeReply(ReplyDTO replyDTO);
    public Long deleteReply(Long id, Object user);
    public List<ReplyDTO> getReply(Long id);
    public Long modifyReply(ReplyDTO replyDTO);
    public boolean checkSame(Long id, Object user);
    public Long getBoardId(Long id);
}

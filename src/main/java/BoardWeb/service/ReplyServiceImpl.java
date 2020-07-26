package BoardWeb.service;

import BoardWeb.dto.ReplyDTO;
import BoardWeb.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<ReplyDTO> getReplyList(Long board_id) {
        return replyMapper.viewReply(board_id);
    }

    @Override
    public void writeReply(ReplyDTO replyDTO) {
        replyMapper.writeReply(replyDTO);
    }

    @Override
    public Long deleteReply(Long id, Object user) {
        if(checkSame(id, user)) {
            replyMapper.deleteReply(id);
        }
        return replyMapper.getBoard_id(id);
    }

    @Override
    public List<ReplyDTO> getReply(Long id) {
        return replyMapper.getReply(id);
    }

    @Override
    public Long modifyReply(ReplyDTO replyDTO) {
        replyMapper.modifyReply(replyDTO);
        return replyMapper.getBoard_id(replyDTO.getId());
    }

    @Override
    public boolean checkSame(Long id, Object user) {
        return ((String) user).equals((String) replyMapper.getWriterAccount(id));
    }

    @Override
    public Long getBoardId(Long id) {
        return replyMapper.getBoard_id(id);
    }
}

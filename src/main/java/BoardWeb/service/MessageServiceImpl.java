package BoardWeb.service;

import BoardWeb.dto.MsgDTO;
import BoardWeb.repository.MsgMapper;
import BoardWeb.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    MsgMapper msgMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<MsgDTO> getMyMessage(Long id) {
        return msgMapper.getMyMessage(id);
    }

    @Override
    public String whoSent(Long id) {
        return userMapper.getAccountFromId(id);
    }
}

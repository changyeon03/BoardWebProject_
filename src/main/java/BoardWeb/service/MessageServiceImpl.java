package BoardWeb.service;

import BoardWeb.dto.MessageDTO;
import BoardWeb.repository.MessageMapper;
import BoardWeb.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<MessageDTO> getMyMessage(String to_account) {
        return messageMapper.getMyMessage(to_account);
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        messageMapper.sendMessage(messageDTO);
    }
}

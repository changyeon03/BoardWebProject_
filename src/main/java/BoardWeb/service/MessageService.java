package BoardWeb.service;

import BoardWeb.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getMyMessage(String to_account);
    void sendMessage(MessageDTO messageDTO);
}

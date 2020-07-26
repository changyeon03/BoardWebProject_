package BoardWeb.service;

import BoardWeb.dto.MsgDTO;

import java.util.List;

public interface MsgService {
    List<MsgDTO> getMyMessage(Long id);
    String whoSent(Long id);
}

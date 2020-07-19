package BoardWeb.service;

import BoardWeb.dto.UserDTO;

public interface UserService {
    public void insertUser(UserDTO userDTO) throws Exception;
    public boolean isUser(UserDTO userDTO) throws Exception;
}

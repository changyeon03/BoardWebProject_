package BoardWeb.service;

import BoardWeb.dto.UserDTO;

public interface UserService {
    public boolean insertUser(UserDTO userDTO) throws Exception;
    public boolean checkPwd(UserDTO userDTO) throws Exception;
    public Object getNick_name(Object account);
    public String getAccount(String nick_name);
}

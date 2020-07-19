package BoardWeb.service;

import BoardWeb.dto.UserDTO;
import BoardWeb.repository.UserMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insertUser(UserDTO userDTO) throws Exception {
        String HashPW = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10));
        userMapper.insertUser(userDTO.getAccount(), HashPW, userDTO.getNick_name());
    }

    @Override
    public boolean isUser(UserDTO userDTO) throws Exception {
        return (BCrypt.checkpw(userDTO.getPassword()
                , userMapper.getPassword(userDTO.getAccount())));
    }
}

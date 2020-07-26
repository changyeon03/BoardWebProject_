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
    public boolean insertUser(UserDTO userDTO) throws Exception {
        if(userMapper.getNick_name(userDTO.getAccount())==null)
        //유저로 등록되어 있지 않다면 매퍼에서 insert문 호출후 컨트롤러에 true반환,
        {
            if(userMapper.checkNick_name(userDTO.getNick_name())==null) {
                //닉네임 중복 확인 성공
                String HashPW = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10));
                userMapper.insertUser(userDTO.getAccount(), HashPW, userDTO.getNick_name());
                return true;
            }
        }
        //닉네임 중복 확인 실패
        //이미 등록되어 있다면 컨트롤러에 false반환.
        return false;
    }

    @Override
    public boolean checkPwd(UserDTO userDTO) throws Exception {
        return (BCrypt.checkpw(userDTO.getPassword()
                , userMapper.getPassword(userDTO.getAccount())));
    }

    @Override
    public Object getNick_name(Object account) {
        return userMapper.getNick_name(account);
    }

    @Override
    public String getAccount(String nick_name) {
        return userMapper.getAccount(nick_name);
    }
}

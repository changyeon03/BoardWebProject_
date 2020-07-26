package BoardWeb.repository;

import BoardWeb.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select(value = "SELECT * FROM users")
    List<UserDTO> getUserList();

    @Select(value = "SELECT password FROM users WHERE account = #{account}")
    String getPassword(@Param("account") String account);

    @Select(value = "SELECT account FROM users WHERE nick_name = #{nick_name}")
    String getAccount(@Param("nick_name") String nick_name);

    @Select(value = "SELECT nick_name FROM users WHERE account = #{account}")
    Object getNick_name(@Param("account") Object account);

    @Select(value = "SELECT id FROM users WHERE nick_name = #{nick_name}")
    Long checkNick_name(@Param("nick_name") String nick_name);

    @Insert(value = "INSERT INTO users(account, password, nick_name) VALUES(#{account}, #{password}, #{nick_name}) ")
    void insertUser(@Param("account") String account, @Param("password") String password, @Param("nick_name") String nick_name);


}


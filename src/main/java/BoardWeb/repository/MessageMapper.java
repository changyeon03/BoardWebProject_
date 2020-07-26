package BoardWeb.repository;

import BoardWeb.dto.MessageDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Select(value = "SELECT * FROM message WHERE to_account=#{to_account}")
    List<MessageDTO> getMyMessage(@Param("to_account") String to_account);

    @Insert(value = "INSERT INTO message(from_account, to_account, content) VALUES(#{from_account}, #{to_account}, #{content})")
    void sendMessage(MessageDTO messageDTO);
}

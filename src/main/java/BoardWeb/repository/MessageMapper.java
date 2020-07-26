package BoardWeb.repository;

import BoardWeb.dto.MsgDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgMapper {

    @Select(value = "SELECT * FROM msg WHERE toid=#{id}")
    List<MsgDTO> getMyMessage(@Param("id") Long id);

    @Insert(value = "INSERT INTO msg(fromid,toid,content) VALUES(#{fromid}, #{toid}, #{content})")
    void sendMessage(@Param("fromid") Long fromid, @Param("toid") Long toid, @Param("content") String content);
}

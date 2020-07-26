package BoardWeb.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ViewMapper {
    @Select(value = "SELECT viewed_at FROM view WHERE board_id = #{board_id} AND viewer = #{viewer}")
    public Timestamp getViewed_at(@Param("board_id") Long board_id, @Param("viewer") String viewer);

    @Insert(value = "INSERT INTO view(board_id, viewer) VALUES(#{board_id}, #{viewer})")
    public void insertViewed_at(@Param("board_id") Long board_id, @Param("viewer") String viewer);

    @Update(value = "UPDATE view SET viewed_at=now() WHERE board_id = #{board_id} AND viewer = #{viewer}")
    public void setViewed_at(@Param("board_id") Long board_id, @Param("viewer") String viewer);
}

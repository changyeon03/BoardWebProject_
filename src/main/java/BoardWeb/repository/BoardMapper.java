package BoardWeb.repository;

import BoardWeb.dto.BoardDTO;
import BoardWeb.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    @Select(value = "SELECT * FROM board WHERE deleted=0 ORDER BY id DESC")
    List<BoardDTO> getBoardList();

    @Select(value = "SELECT COUNT(*) FROM board")
    int getTotalBoard();

    @Select(value = "SELECT * FROM board WHERE id=#{id}")
    List<BoardDTO> viewBoard(@Param("id") Long id);

    @Select(value = "SELECT writer_account FROM board WHERE id=#{id}")
    Object getWriterAccount(@Param("id") Long id);

    @Update(value = "UPDATE board SET deleted = 1 WHERE id=#{id}")
    void deleteBoard(@Param("id") Long id);

    @Update(value = "UPDATE board SET title=#{title}, content=#{content} WHERE id=#{id}")
    void modifyBoard(@Param("title") String title, @Param("content") String content, @Param("id") Long id);

    @Update(value = "UPDATE board SET view_count=view_count+1 WHERE id=#{id}")
    void upViewCount(@Param("id") Long id);

    @Insert(value = "INSERT INTO board(writer_account, nick_name, title, content) VALUES(#{writer_account}, #{nick_name}, #{title}, #{content}) ")
    void writeBoard(BoardDTO boardDTO);
}

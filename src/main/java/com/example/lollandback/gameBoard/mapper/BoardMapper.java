package com.example.lollandback.gameBoard.mapper;

import com.example.lollandback.gameBoard.domain.GameBoard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
INSERT INTO board(title, content, writer)
VALUES (#{title},#{content},#{writer})
""")
    int insert(GameBoard gameBoard);

    @Select("""
            SELECT id,title,writer,inserted
            FROM board
            ORDER BY bgId DESC
            """)
    List<GameBoard> selectAll();

    @Select("""
SELECT id, title, content, writer, inserted
FROM board
WHERE bgId=#{id}
""")
    GameBoard selectById(Integer bgId);

    @Update("""
UPDATE board
SET title= #{title},
content=#{content},
writer=#{writer}
WHERE id= #{id}
""")
}

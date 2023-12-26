package com.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;
import com.board.util.DBConn;

public class BoardDao {
	// num(글 번호)의 최대값입니다.
	public int getMaxNum() {
		int maxNum = 0;
		try {
			String sql = "select nvl(max(num),0) from board";
			ResultSet rs = DBConn.preparedQuery(sql);
			while (rs.next()) {
				maxNum = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return maxNum;
	}

	// insert(글 입력)
	public int insertData(BoardDto dto) {
		int result = 0;
		String sql = "INSERT INTO board(num, name, subject, content, pw, view_cnt, reg_date) VALUES(?,?,?,?,?,0,SYSDATE)";

		// PreparedStatement 사용
		try (PreparedStatement ps = DBConn.getInstance().prepareStatement(sql)) {
			ps.setInt(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getPw());

			result = ps.executeUpdate();
		}catch(SQLException e) {
		System.out.println(e.toString());
		}
		
		return result;
	}

	// 전체 데이터 갯수
	public int getDataCount(String searchKey, String searchValue) {
		int totalCount = 0;
		try {
			searchValue = "%" + searchValue + "%";
			String sql = "select nvl(count(*),0) from board ";
			sql += "where " + searchKey + " like ?";

			PreparedStatement ps = DBConn.getInstance().prepareStatement(sql);
			ps.setString(1, searchValue);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return totalCount;
	}

	// 전체 데이터 출력(페이지별 개수 제한)
	public List<BoardDto> getLists(int start, int end, String searchKey, String searchValue) {
		List<BoardDto> lists = new ArrayList<BoardDto>();
		try {
			searchValue = "%" + searchValue + "%";

			String sql = "select * from (";
			sql += "select rownum rnum, data.* from (";
			sql += "select num, name, subject, view_cnt,";
			sql += "to_char(reg_date,'YYYY-MM-DD') reg_date ";
			sql += "from board where " + searchKey + " like ? ";
			sql += "order by num desc) data) ";
			sql += "where rnum>=? and rnum<=?";

			PreparedStatement ps = DBConn.getInstance().prepareStatement(sql);

			ps.setString(1, searchValue);
			ps.setInt(2, start);
			ps.setInt(3, end);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setView_cnt(rs.getInt("view_cnt"));
				dto.setReg_date(rs.getString("reg_date"));

				lists.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;
	}

	// num으로 조회한 한개의 데이터(select one)
	public BoardDto getReadData(int num) {
		BoardDto result = new BoardDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from board where num=%d", num));
		if (rs != null) {
			try {
				rs.next();
				result = new BoardDto(rs.getInt("num"), rs.getString("name"), rs.getString("subject"),
						rs.getString("content"), rs.getInt("view_cnt"), rs.getString("reg_date"), rs.getString("pw"));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 조회수 증가
	public int updateViewCount(int num) {
		int result = DBConn.statementUpdate(String.format("update board set view_cnt=view_cnt+1 where num=%d", num));
		return result;
	}

	// 수정
	public int updateData(BoardDto dto) {
		int result = 0;
		try {
			String sql = "update board set name=?, subject=?, content=?, pw=? where num=?";
			PreparedStatement ps = DBConn.getInstance().prepareStatement(sql);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSubject());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPw());
			ps.setInt(5, dto.getNum());

			result = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	// 삭제
	public int deleteData(int num) {
		int result = DBConn.statementUpdate(String.format("delete from board where num=%d", num));
		return result;
	}
}

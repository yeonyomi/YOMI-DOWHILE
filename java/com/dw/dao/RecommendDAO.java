package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dw.dto.RecommendVO;

import util.DBManager;

public class RecommendDAO {
	private RecommendDAO() {
	}

	private static RecommendDAO instance = new RecommendDAO();

	public static RecommendDAO getInstance() {
		return instance;
	}

	public List<RecommendVO> ramdomExercise(String part) {
		String sql = "SELECT * FROM (SELECT * FROM recommend WHERE part = ? ORDER BY dbms_random.value) WHERE rownum <= 5";
       

		 List<RecommendVO> exerciselist = new ArrayList<RecommendVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, part);
			rs = pstmt.executeQuery();
			 
			while (rs.next()) {
			    RecommendVO rvo = new RecommendVO();
			    rvo.setPart(rs.getString("part"));
			    rvo.setKind(rs.getString("kind"));
			    rvo.setPosture(rs.getString("posture"));
			    exerciselist.add(rvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return exerciselist;
		

	}
}

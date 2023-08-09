package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dw.dto.workoutVO;

import util.DBManager;

public class workoutDAO {
	private workoutDAO(){
		
	}
	
	private static workoutDAO instance = new workoutDAO();
	public static workoutDAO getInstance() {
		return instance;
	}
	public ArrayList<workoutVO> selectallWorkout(){
		String sql = "select * from workout2 order by selectdate desc";
		ArrayList<workoutVO> workoutlist = new ArrayList<workoutVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				workoutVO wvo = new workoutVO();
				wvo.setSelectdate(rs.getString("selectdate"));
				wvo.setExercise(rs.getString("exercise"));
				wvo.setTime(rs.getString("time"));
				wvo.setPart(rs.getString("part"));
				wvo.setContent1(rs.getString("content1"));
				wvo.setContent2(rs.getString("content2"));
				wvo.setContent3(rs.getString("content3"));
				wvo.setContent4(rs.getString("content4"));
				wvo.setContent5(rs.getString("content5"));
				workoutlist.add(wvo);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return workoutlist;
	}
	
	public void insertWorkout(workoutVO wvo) {
		String sql = "insert into workout2 values(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wvo.getSelectdate());
			pstmt.setString(2, wvo.getExercise());
			pstmt.setString(3, wvo.getTime());
			pstmt.setString(4, wvo.getPart());
			pstmt.setString(5, wvo.getContent1());
			pstmt.setString(6, wvo.getContent2());
			pstmt.setString(7, wvo.getContent3());
			pstmt.setString(8, wvo.getContent4());
			pstmt.setString(9, wvo.getContent5());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public workoutVO getWorkout(String selectdate) {
		workoutVO wVo = null;
		Connection conn = null;
		String sql = "select * from workout2 where selectdate = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectdate);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wVo = new workoutVO();
				wVo.setSelectdate(rs.getString("selectdate"));
				wVo.setExercise(rs.getString("exercise"));
				wVo.setTime(rs.getString("time"));
				wVo.setPart(rs.getString("part"));
				wVo.setContent1(rs.getString("content1"));
				wVo.setContent2(rs.getString("content2"));
				wVo.setContent3(rs.getString("content3"));
				wVo.setContent4(rs.getString("content4"));
				wVo.setContent5(rs.getString("content5"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return wVo;
	}
	
	public int deleteWorkout(String selectdate) {
		int result = -1;
		String sql = "delete from workout2 where selectdate=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectdate);
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public void updateWorkout(workoutVO wvo) {
		System.out.println("update");
		String sql = "update workout2 set content1=?, content2=?,content3=?,content4=?,content5=? where selectdate=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wvo.getContent1());
			pstmt.setString(2, wvo.getContent2());
			pstmt.setString(3, wvo.getContent3());
			pstmt.setString(4, wvo.getContent4());
			pstmt.setString(5, wvo.getContent5());
			pstmt.setString(6, wvo.getSelectdate());
			pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}

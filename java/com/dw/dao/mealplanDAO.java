package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dw.dto.mealplanVO;

import util.DBManager;

public class mealplanDAO {
	public mealplanDAO() {
	}
	
	private static mealplanDAO instance = new mealplanDAO();
	
	public static mealplanDAO getInstance() {
		return instance;
	}
	
	public void insertMeal(mealplanVO mvo) {
		String sql = "insert into mealplan values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mvo.getSelectdate());
			pstmt.setString(2,mvo.getBreakfast());
			pstmt.setString(3,mvo.getBreakfastimage());
			pstmt.setString(4,mvo.getBreakfastmemo());
			pstmt.setString(5,mvo.getLunch());
			pstmt.setString(6,mvo.getLunchimage());
			pstmt.setString(7,mvo.getLunchmemo());
			pstmt.setString(8,mvo.getDinner());
			pstmt.setString(9,mvo.getDinnerimage());
			pstmt.setString(10,mvo.getDinnermemo());
			pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public mealplanVO getMeal(String selectdate) {
		
		mealplanVO mvo = null;
		String sql = "select * from mealplan where selectdate = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectdate);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new mealplanVO();
				mvo.setSelectdate(rs.getString("selectdate"));
				mvo.setBreakfast(rs.getString("breakfast"));
				mvo.setBreakfastimage(rs.getString("breakfastimage"));
				mvo.setBreakfastmemo(rs.getString("breakfastmemo"));
				mvo.setLunch(rs.getString("lunch"));
				mvo.setLunchimage(rs.getString("lunchimage"));
				mvo.setLunchmemo(rs.getString("lunchmemo"));
				mvo.setDinner(rs.getString("dinner"));
				mvo.setDinnerimage(rs.getString("dinnerimage"));
				mvo.setDinnermemo(rs.getString("dinnermemo"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	}
	
	public int deleteMealplan (String selectdate) {
		int result = -1;
		String sql = "delete from mealplan where selectdate=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,selectdate);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
}

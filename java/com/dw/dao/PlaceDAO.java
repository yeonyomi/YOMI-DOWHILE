package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dw.dto.PlaceVO;

import util.DBManager;

public class PlaceDAO {
	private PlaceDAO() {
	}

	private static PlaceDAO instance = new PlaceDAO();

	public static PlaceDAO getInstance() {
		return instance;
	}
	
	public List<PlaceVO> allGu(String gu) {
	    String sql = "SELECT DISTINCT dong FROM place WHERE gu =?";
	    List<PlaceVO> placeList = new ArrayList<PlaceVO>();

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, gu); // 첫 번째 매개 변수에 gu 값을 설정
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            PlaceVO pvo = new PlaceVO();
	            pvo.setDong(rs.getString("dong"));

	            placeList.add(pvo);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return placeList;
	}
	
	
	public List<PlaceVO> allDong(String dong) {
	    String sql = "SELECT * FROM place WHERE dong =?";
	    
	    System.out.println("어디동인지 나와야함 ->"+dong);
	    List<PlaceVO> placeList = new ArrayList<PlaceVO>();

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, dong); 
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            PlaceVO pvo = new PlaceVO();
	            pvo.setGym(rs.getString("gym")); // 수정된 부분

	            placeList.add(pvo);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return placeList;
	}
	
	public List<PlaceVO> allGym(String gym) {
	    String sql = "SELECT * FROM place WHERE gym =?";
	    
	    System.out.println("어디짐인지 나와야함 ->"+gym);
	    List<PlaceVO> placeList = new ArrayList<PlaceVO>();

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, gym); 
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            PlaceVO pvo = new PlaceVO();
	            pvo.setJuso(rs.getString("juso")); // 수정된 부분
	            pvo.setAddress(rs.getString("address"));

	            placeList.add(pvo);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return placeList;
	}
}
	

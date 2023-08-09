package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.dw.dto.PhysicalVO;

import util.DBManager;

public class PhysicalDAO {
   private PhysicalDAO() {
   }

   private static PhysicalDAO instance = new PhysicalDAO();

   public static PhysicalDAO getInstance() {
      return instance;
   }
   
   public void UserSpec(String id,String physicaldate, String weight, String height, String fat, String muscle) {
       Connection conn = null;
       PreparedStatement pstmt = null;

       try {
           conn = DBManager.getConnection();
           String sql = "INSERT INTO physical VALUES (?, ?, ?, ?, ?, ?)";
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, id);
           pstmt.setString(2, physicaldate);
           pstmt.setString(3, weight);
           pstmt.setString(4, height);
           pstmt.setString(5, fat);
           pstmt.setString(6, muscle);
           pstmt.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           DBManager.close(conn, pstmt);
       }
   }
   
   
   public PhysicalVO getUserSpec(String id) {
      PhysicalVO physical = null;
      String sql = "SELECT * FROM physical WHERE id=? ORDER BY physicaldate DESC";
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            physical = new PhysicalVO();
            
            physical.setId(rs.getString("id"));
            physical.setPhysicaldate(rs.getString("physicaldate"));
            physical.setWeight(rs.getString("weight"));
            physical.setHeight(rs.getString("height"));
            physical.setFat(rs.getString("fat"));
            physical.setMuscle(rs.getString("muscle"));
            
            System.out.println(physical);
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         DBManager.close(conn, pstmt, rs);
      }
      return physical;
   }
   
   public void getWeightData(HttpServletRequest request) {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;

	   try {
	       // 오라클 데이터베이스 접속
	       conn = DBManager.getConnection();

	       // 데이터 가져오기
	       String sql = "SELECT PHYSICALDATE, WEIGHT, MUSCLE, FAT FROM PHYSICAL";
	       pstmt = conn.prepareStatement(sql);
	       rs = pstmt.executeQuery();

	       // 데이터 가공
	       String physicaldates = "";
	       String weights = "";
	       String muscles = "";
	       String fats ="";
	       while (rs.next()) {
	           physicaldates += "'" + rs.getString("PHYSICALDATE") + "', ";
	           weights += rs.getDouble("WEIGHT") + ", ";
	           muscles += rs.getDouble("MUSCLE") + ", ";
	           fats += rs.getDouble("FAT") + ", ";
	       }
	       physicaldates = physicaldates.substring(0, physicaldates.length() - 2);
	       weights = weights.substring(0, weights.length() - 2);
	       muscles = muscles.substring(0, muscles.length() - 2);
	       fats = fats.substring(0, fats.length() - 2);

	       // JavaScript 코드로 전달
	       request.setAttribute("physicaldates", physicaldates);
	       request.setAttribute("weights", weights);
	       request.setAttribute("muscles", muscles);
	       request.setAttribute("fats", fats);
	   } catch (Exception e) {
	       e.printStackTrace();
	   } finally {
	      DBManager.close(conn, pstmt, rs);
	   }
   
   }
}

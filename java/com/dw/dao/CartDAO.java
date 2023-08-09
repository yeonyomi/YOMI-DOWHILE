package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dw.dto.CartVO;

import util.DBManager;

public class CartDAO {

   private CartDAO() {
   }

   private static CartDAO instance = new CartDAO();

   public static CartDAO getInstance() {
      return instance;
   }

   public void insertCart(CartVO cVo) {
      String sql = "INSERT INTO CART (ID, P_SEQ, IMAGE_PATH, NAME, QUANTITY, PRICE, CREATE_DATE) VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";

      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, cVo.getId());
         pstmt.setInt(2, cVo.getpSeq());
         pstmt.setString(3, cVo.getImagePath());
         pstmt.setString(4, cVo.getName());
         pstmt.setInt(5, cVo.getQuantity());
         pstmt.setInt(6, cVo.getPrice());
         

         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /* 삭제 */
   public void deleteCart(String name) {
      String sql = "DELETE CART WHERE NAME=?";
      Connection conn = null;
      // db와 연결
      PreparedStatement pstmt = null;
      // sql문 실행
      try {
         conn = DBManager.getConnection();
         // DBManager를 통해 데이터 베이스에 연결
         // getconnection를 통해 connection은 반환
         pstmt = conn.prepareStatement(sql);
         // 삭제하기 위한 sql문장 바인딩
         pstmt.setString(1, name);
         // 바인딩 변수는? 상품번호임
         pstmt.executeUpdate();
         // sql문실행 및 데이터 삭제
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }

   public List<CartVO> userCart(String id) {
      String sql = "SELECT * FROM CART WHERE ID=? ORDER BY CREATE_DATE";

      List<CartVO> cartList = new ArrayList<CartVO>();

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            CartVO cvo = new CartVO();

            cvo.setpSeq(rs.getInt("p_seq"));
            cvo.setImagePath(rs.getString("image_path"));
            cvo.setName(rs.getString("name"));
            cvo.setQuantity(rs.getInt("quantity"));
            cvo.setPrice(rs.getInt("price"));

            cartList.add(cvo);

         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }

      return cartList;
   }

   public void updateCart(CartVO cVo) {
      String sql = "UPDATE CART SET QUANTITY=?,PRICE=? WHERE NAME=?";
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cVo.getQuantity());
         pstmt.setInt(2, cVo.getPrice());
         pstmt.setString(3, cVo.getName());

         pstmt.executeUpdate();

      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);

      }
   }

   public CartVO selectAllCartBypseq(String pseq) {
      String sql = "SELECT * FROM CART WHERE P_SEQ=?";
      CartVO cVo = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, pseq);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            cVo = new CartVO();
            cVo.setId(rs.getString("id"));
            cVo.setpSeq(rs.getInt("p_seq"));
            cVo.setImagePath(rs.getString("image_path"));
            cVo.setName(rs.getString("name"));
            cVo.setQuantity(rs.getInt("quantity"));
            cVo.setCreatDate(rs.getDate("create_date"));
            cVo.setPrice(rs.getInt("price"));

         }
      } catch (SQLException e) {
         // TODO: handle exception
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }
      return cVo;
   }

   public int deleteAllCartItems(String id) {
      int result = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;

      String sql = "DELETE FROM cart WHERE id=?";

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }

      return result;
   }

}
package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dw.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> allProduct(String kind) {
	    String sql = "select * from product ";
	    if(kind != null && !kind.isEmpty()) {
	        sql += "where kind = ? ";
	    }
	    sql += "order by seq asc";
	    List<ProductVO> productList = new ArrayList<ProductVO>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        if(kind != null && !kind.isEmpty()) {
	            pstmt.setString(1, kind);
	        }
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            ProductVO pvo = new ProductVO();
	            pvo.setSeq(rs.getInt("seq"));
	            pvo.setName(rs.getString("name"));
	            pvo.setKind(rs.getString("kind"));
	            pvo.setCost(rs.getInt("cost"));
	            pvo.setPrice(rs.getInt("price"));
	            pvo.setContent(rs.getString("content"));
	            pvo.setContentImagePath(rs.getString("content_image_path"));
	            pvo.setImagePath(rs.getString("image_path"));
	            pvo.setThumbImagePath(rs.getString("thumb_image_path"));
	            pvo.setUseYn(rs.getString("use_yn"));
	            pvo.setBestYn(rs.getString("best_yn"));
	            pvo.setCreateDate(rs.getDate("create_date"));
	            pvo.setUpdateDate(rs.getDate("update_date"));
	            pvo.setUpdateBy(rs.getString("update_by"));
	            pvo.setCreateBy(rs.getString("create_by"));
	            
	            productList.add(pvo);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return productList;
	}

	public void insertProduct(ProductVO product) {
		String sql = "insert into product(SEQ, NAME, KIND, COST, PRICE, CONTENT, IMAGE_PATH, THUMB_IMAGE_PATH, USE_YN, BEST_YN, CREATE_DATE, UPDATE_BY, CREATE_BY) values(product_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getKind());
			pstmt.setInt(3, product.getCost());
			pstmt.setInt(4, product.getPrice());
			pstmt.setString(5, product.getContent());
			pstmt.setString(6, product.getImagePath());
			pstmt.setString(7, product.getThumbImagePath());
			pstmt.setString(8, product.getUseYn());
			pstmt.setString(9, product.getBestYn());
			pstmt.setString(10, product.getUpdateBy());
			pstmt.setString(11, product.getCreateBy());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public ProductVO getProduct(Integer seq) {
		ProductVO product = null;
		
		String sql = "select * from product where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
					
			if(rs.next()) {
				product = new ProductVO();
				product.setSeq(rs.getInt("seq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setCost(rs.getInt("cost"));
				product.setPrice(rs.getInt("price"));
				product.setContent(rs.getString("content"));
				product.setContentImagePath(rs.getString("content_image_path"));
				product.setImagePath(rs.getString("image_path"));
				product.setThumbImagePath(rs.getString("thumb_image_path"));
				product.setUseYn(rs.getString("use_yn"));
				product.setBestYn(rs.getString("best_yn"));
				product.setCreateDate(rs.getDate("create_date"));
				product.setUpdateDate(rs.getDate("update_date"));
				product.setUpdateBy(rs.getString("update_by"));
				product.setCreateBy(rs.getString("create_by"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return product;
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set name=?,kind=?,cost=?,price=?,content=?,content_image_path=?,image_path=?,thumb_image_path=?,use_yn=?,best_yn=?,update_date=sysdate,update_by=? where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pvo.getName());
			pstmt.setString(2, pvo.getKind());
			pstmt.setInt(3, pvo.getCost());
			pstmt.setInt(4, pvo.getPrice());
			pstmt.setString(5, pvo.getContent());
			pstmt.setString(6, pvo.getContentImagePath());
			pstmt.setString(7, pvo.getImagePath());
			pstmt.setString(8, pvo.getThumbImagePath());
			pstmt.setString(9, pvo.getUseYn());
			pstmt.setString(10, pvo.getBestYn());
			pstmt.setString(11, pvo.getUpdateBy());
			pstmt.setInt(12, pvo.getSeq());
			pstmt.executeUpdate();
			
			
			} catch (Exception e) {
			    e.printStackTrace();
			} finally {
			    DBManager.close(conn, pstmt);
			}
		
		
	}

	public void deleteProduct(int seq) {
		String sql = "delete product where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, seq);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	//명주------------
	/**
	 * 전체 상품 리스트 중 사용여부가 사용인 상품들을 조회하는 메소드
	 * @param kind 상품의 종류 1:단백질쉐이크, 2:
	 * 
	 * @return 상품 리스트
	 */
	public List<ProductVO> selectAllProducts(String kind){
	
		String sql = "SELECT * FROM PRODUCT WHERE USE_YN = 'Y' AND KIND = " + kind ;
		List<ProductVO> productList = new ArrayList<>();
		Connection conn = null;
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();			
			while (rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setSeq(rs.getInt("seq"));
				productVO.setName(rs.getString("name"));
				productVO.setKind(rs.getString("kind"));
				productVO.setCost(rs.getInt("cost"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setContent(rs.getString("content"));
				productVO.setContentImagePath(rs.getString("content_image_path"));
				productVO.setImagePath(rs.getString("image_path"));
				productVO.setThumbImagePath(rs.getString("thumb_image_path"));
				productVO.setUseYn(rs.getString("use_yn"));
				productVO.setBestYn(rs.getString("best_yn"));
				productVO.setCreateDate(rs.getDate("create_date"));
				productVO.setUpdateDate(rs.getDate("update_date"));
				productVO.setUpdateBy(rs.getString("update_by"));
				productVO.setCreateBy(rs.getString("create_by"));
				productList.add(productVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	/**
	 * 상품번호로 상품을 조회하는 메소드
	 * @param seq 상품번호
	 * @return 상품
	 */
	public ProductVO selectProduct(Integer seq) {
		String sql = "SELECT * FROM PRODUCT WHERE SEQ = ?";
		ProductVO productVO = new ProductVO();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				productVO.setSeq(rs.getInt("seq"));
				productVO.setName(rs.getString("name"));
				productVO.setKind(rs.getString("kind"));
				productVO.setCost(rs.getInt("cost"));
				productVO.setPrice(rs.getInt("price")); 
				productVO.setContent(rs.getString("content"));
				productVO.setContentImagePath(rs.getString("content_image_path"));
				productVO.setImagePath(rs.getString("image_path"));
				productVO.setThumbImagePath(rs.getString("thumb_image_path"));
				productVO.setUseYn(rs.getString("use_yn"));
				productVO.setBestYn(rs.getString("best_yn"));
				productVO.setCreateDate(rs.getDate("create_date"));
				productVO.setUpdateDate(rs.getDate("update_date"));
				productVO.setUpdateBy(rs.getString("update_by"));
				productVO.setCreateBy(rs.getString("create_by"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return productVO;
	}
	
	public List<ProductVO> selectBestProducts(){
		String sql = "SELECT SEQ, NAME, KIND, PRICE,THUMB_IMAGE_PATH FROM PRODUCT WHERE SEQ IN ("
				+ "        SELECT MIN(SEQ) AS SEQ FROM PRODUCT"
				+ "        WHERE BEST_YN = 'Y'"
				+ "        GROUP BY KIND"
				+ "    )"
				+ "    ORDER BY KIND ASC";
		List<ProductVO> productList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setSeq(rs.getInt("seq"));
				productVO.setName(rs.getString("name"));
				productVO.setKind(rs.getString("kind"));
				productVO.setPrice(rs.getInt("price")); 
				productVO.setThumbImagePath(rs.getString("thumb_image_path"));
				productList.add(productVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return productList;
		
	}

}

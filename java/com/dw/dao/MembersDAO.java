package com.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dw.dto.MembersVO;

import util.DBManager;

public class MembersDAO {
	private MembersDAO() {
	}

	private static MembersDAO instance = new MembersDAO();

	public static MembersDAO getInstance() {
		return instance;
	}

	public void insertMember(MembersVO member) {
		String sql = "insert into members values(members_seq.nextval,?,?,?,?,?,sysdate,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getLev());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public int userCheck(String id, String pass, String lev) {
		int result = 1;
		String sql = "select * from members where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String Pass = rs.getString("pass");
				String Lev = rs.getString("lev");
				if (Pass.equals(pass) && Lev != null && Lev.equals("A")) {
					result = 2; // 관리자 로그인 성공
				} else if (Pass.equals(pass)) {
					result = 1; // 로그인 성공
				} else {
					result = 0; // 비밀번호 불일치
				}
			} else {
				result = -1; // 해당 id가 존재하지 않음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public List<MembersVO> allUser() {
		String sql = "select * from members order by num asc";
		List<MembersVO> memberList = new ArrayList<MembersVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MembersVO mvo = new MembersVO();
				mvo.setNum(rs.getInt("num"));
				mvo.setId(rs.getString("id"));
				mvo.setPass(rs.getString("pass"));
				mvo.setName(rs.getString("name"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setJoindate(rs.getTimestamp("joindate"));
				mvo.setLev(rs.getString("lev"));
				memberList.add(mvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberList;
	}

	public MembersVO getMember(String id) {
		System.out.println("aa");
		MembersVO member = null;
		String sql = "select * from members where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MembersVO();

				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setJoindate(rs.getDate("joindate"));
				member.setLev(rs.getString("lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return member;
	}

	public void updateMember(MembersVO mvo) {
		String sql = "update members set pass=?,name=?,address=?,phone=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getPass());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getAddress());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void deleteMember(String id) {
		String sql = "delete members where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public boolean idCheck(String id) {
		boolean idCheck = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM members WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					idCheck = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return idCheck;
	}
	
}

package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		List<Map<String, String>> boardInfoList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD_INFO";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				try(ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						Map<String, String> boardInfo = new HashMap<>();
						boardInfo.put("biNum", rs.getString("BI_NUM"));
						boardInfo.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo.put("uiNum", rs.getString("UI_NUM"));
						boardInfo.put("creDat", rs.getString("CREDAT"));
						boardInfo.put("creTim", rs.getString("CRETIM"));
						boardInfo.put("lmoDat", rs.getString("LMODAT"));
						boardInfo.put("lmoTim", rs.getString("LMOTIM"));
						boardInfo.put("active", rs.getString("ACTIVE"));
						boardInfoList.add(boardInfo);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardInfoList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT * FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()) {
					if(rs.next()) {
						Map<String, String> boardInfo = new HashMap<>();
						boardInfo.put("biNum", rs.getString("BI_NUM"));
						boardInfo.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo.put("uiNum", rs.getString("UI_NUM"));
						boardInfo.put("creDat", rs.getString("CREDAT"));
						boardInfo.put("creTim", rs.getString("CRETIM"));
						boardInfo.put("lmoDat", rs.getString("LMODAT"));
						boardInfo.put("lmoTim", rs.getString("LMOTIM"));
						boardInfo.put("active", rs.getString("ACTIVE"));
						return boardInfo;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql = "INSERT INTO BOARD_INFO(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT,\r\n"
				+ "CRETIM, LMODAT, LMOTIM) \r\n"
				+ "VALUES(?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), \r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s')\r\n"
				+ ")";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql = "UPDATE BOARD_INFO\r\n"
				+ "SET BI_TITLE=?,\r\n"
				+ "BI_CONTENT=?,\r\n"
				+ "UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(), '%H%i%s')\r\n"
				+ "WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
//		Map<String, String> biMock = new HashMap<>();
//		biMock.put("biTitle", "test");
//		biMock.put("biContent", "test");
//		biMock.put("uiNum", "1");		
//		int result = biDAO.insertBoardInfo(biMock);
//		System.out.println("결과 : " + result);
		
//		System.out.println(biDAO.selectBoardInfoList(null));
//		System.out.println(biDAO.selectBoardInfo("2"));
		
//		Map<String, String> biMock = new HashMap<>();
//		biMock.put("biTitle", "수정2");
//		biMock.put("biContent", "수정2");
//		biMock.put("uiNum", "1");		
//		biMock.put("biNum", "2");		
//		int result = biDAO.updateBoardInfo(biMock);
//		System.out.println("결과 : " + result);
		
//		System.out.println(biDAO.deleteBoardInfo("4"));
	}
}

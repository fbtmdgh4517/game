package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.common.DBCon;
import com.game.dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String, String>> userInfoList = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("creDat", rs.getString("CREDAT"));
						ui.put("creTim", rs.getString("CRETIM"));
						ui.put("lmoDat", rs.getString("LMODAT"));
						ui.put("lmoTim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						userInfoList.add(ui);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, \r\n"
				+ "UI_IMG_PATH, UI_DESC, DATE_FORMAT(UI_BIRTH, '%Y-%m-%d') UI_BIRTH, CREDAT, \r\n"
				+ "CRETIM, LMODAT, LMOTIM, ACTIVE \r\n"
				+ "FROM user_info\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, uiNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("creDat", rs.getString("CREDAT"));
						ui.put("creTim", rs.getString("CRETIM"));
						ui.put("lmoDat", rs.getString("LMODAT"));
						ui.put("lmoTim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						return ui;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO user_info(\r\n"
				+ "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM, \r\n"
				+ "LMODAT, LMOTIM) \r\n"
				+ "VALUES (\r\n"
				+ "?, ?, ?, ?, \r\n"
				+ "?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), \r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, userInfo.get("uiName"));
				pstmt.setString(2, userInfo.get("uiId"));
				pstmt.setString(3, userInfo.get("uiPwd"));
				pstmt.setString(4, userInfo.get("uiImgPath"));
				pstmt.setString(5, userInfo.get("uiDesc"));
				pstmt.setString(6, userInfo.get("uiBirth"));
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE user_info \r\n"
				+ "SET UI_NAME=?, \r\n"
				+ "UI_ID=?, \r\n"
				+ "UI_PWD=?, \r\n"
				+ "UI_IMG_PATH=?, \r\n"
				+ "UI_DESC=?, \r\n"
				+ "UI_BIRTH=?, \r\n"
				+ "LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'),\r\n"
				+ "LMOTIM= DATE_FORMAT(NOW(), '%H%i%s')\r\n"
				+ "WHERE UI_NUM = ?";
		try(Connection con = DBCon.getCon()) {
			 try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				 pstmt.setString(1, userInfo.get("uiName"));
				 pstmt.setString(2, userInfo.get("uiId"));
				 pstmt.setString(3, userInfo.get("uiPwd"));
				 pstmt.setString(4, userInfo.get("uiImgPath"));
				 pstmt.setString(5, userInfo.get("uiDesc"));
				 pstmt.setString(6, userInfo.get("uiBirth"));
				 pstmt.setString(7, userInfo.get("uiNum"));
				 return pstmt.executeUpdate();
			 }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM user_info WHERE UI_NUM = ?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, uiNum);
				return pstmt.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql ="SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "DATE_FORMAT(UI_BIRTH,'%Y-%m-%d') UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE UI_ID=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiId);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserInfoDao dao = new UserInfoDaoImpl();
		System.out.println(dao.selectUserInfoList(null));
		System.out.println(dao.selectUserInfo("1"));
//		Map<String, String> map = new HashMap<>();
//		map.put("uiName", "name zz");
//		map.put("uiId", "id zz");
//		map.put("uiPwd", "pwd zz");
//		map.put("uiDesc", "desc zz");
//		map.put("uiBirth", "19990714");
//		System.out.println(dao.insertUserInfo(map));
//		Map<String, String> map2 = new HashMap<>();
//		map2.put("uiName", "name2 zz");
//		map2.put("uiId", "id2 zz");
//		map2.put("uiPwd", "pwd2 zz");
//		map2.put("uiDesc", "desc2 zz");
//		map2.put("uiNum", "2");
//		System.out.println(dao.updateUserInfo(map2));
		System.out.println(dao.deleteUserInfo("2"));
	}

}

package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO2;

public class UserInfoDAO2Impl implements UserInfoDAO2 {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String, String>> userInfoList = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, CREDAT, CRETIM, LMODAT, LMOTIM FROM user_info2";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("creDat", rs.getString("CREDAT"));
						ui.put("creTim", rs.getString("CRETIM"));
						ui.put("lmoDat", rs.getString("LMODAT"));
						ui.put("lmoTim", rs.getString("LMOTIM"));
						userInfoList.add(userInfo);
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
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, CREDAT, CRETIM, LMODAT, LMOTIM FROM user_info2 \r\n"
				+ "WHERE UI_NUM = ?";
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
						ui.put("creDat", rs.getString("CREDAT"));
						ui.put("creTim", rs.getString("CRETIM"));
						ui.put("lmoDat", rs.getString("LMODAT"));
						ui.put("lmoTim", rs.getString("LMOTIM"));						
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
		String sql = "INSERT INTO user_info2 (UI_NAME, UI_ID, UI_PWD) \r\n"
				+ "VALUES(?, ?, ?)";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, userInfo.get("uiName"));
				pstmt.setString(2, userInfo.get("uiId"));
				pstmt.setString(3, userInfo.get("uiPwd"));
				return pstmt.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE user_info2 SET UI_NAME=?, UI_ID=?, UI_PWD=? WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, userInfo.get("uiName"));
				pstmt.setString(2, userInfo.get("uiId"));
				pstmt.setString(3, userInfo.get("uiPwd"));
				pstmt.setString(4, userInfo.get("uiNum"));
				return pstmt.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "";
		return 0;
	}

}

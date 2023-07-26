package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDao;
import com.game.dao.impl.UserInfoDaoImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDao uiDao = new UserInfoDaoImpl();
	
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		return uiDao.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		return uiDao.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		return uiDao.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		return uiDao.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return uiDao.deleteUserInfo(uiNum);
	}

	@Override
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		String uiId = userInfo.get("uiId");
		Map<String, String> tmp = uiDao.selectUserInfoById(uiId);
		System.out.println(tmp);
		if(tmp != null) {
			// 맞는애 가져왔다는거
			String uiPwd = tmp.get("uiPwd");
			if(uiPwd.equals(userInfo.get("uiPwd"))) {
				session.setAttribute("user", tmp);
				return true;
			}
		}
		return false;
	}

}

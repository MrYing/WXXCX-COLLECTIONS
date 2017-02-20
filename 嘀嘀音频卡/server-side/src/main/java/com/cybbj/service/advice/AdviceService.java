package com.cybbj.service.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybbj.dao.advice.AdviceDao;

@Service(value="adviceService")
public class AdviceService {
	
	@Autowired
	private AdviceDao adviceDao;

	public int insertAdvice(String sadvice) {
		return adviceDao.insertAdvice(sadvice);
	}

}

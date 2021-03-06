package com.ssafy.pjt.provider.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.core.repository.mapper.ControversyMapper;
import com.ssafy.pjt.core.security.Role;
import com.ssafy.pjt.core.service.ControversyUseCase;
import com.ssafy.pjt.web.dto.ControversyDTO;

@Service
public class ControversyService implements ControversyUseCase{
	@Autowired
	private ControversyMapper mapper;
	
	@Override
	public List<ControversyDTO> all() throws SQLException {		  
		return mapper.all();
	}

	@Override
	public ControversyDTO detail(int controversyId) throws Exception {
		return mapper.detail(controversyId);
	}
	
	@Override
	public boolean hit(int controversyId,String check) throws Exception {
		return mapper.hit(controversyId,check);
	}
	
	@Override
	public boolean insert(ControversyDTO controversy) throws Exception {
		return mapper.insert(controversy);
	}

	@Override
	public boolean delete(int controversyId) throws Exception {	
		return mapper.delete(controversyId);
	}

	@Override
	public boolean update(ControversyDTO controversy) throws Exception {
		return mapper.update(controversy);
	}

	@Override
	public void overlab(int uuid, int controversyId) throws DataIntegrityViolationException {
		mapper.overlab(uuid, controversyId);
	}


}

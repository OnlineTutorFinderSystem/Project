package com.cg.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.DemoSession;
import com.cg.project.repository.DemoSessionDao;

@Service
public class DemoSessionServiceImpl implements DemoSessionService {

	@Autowired
	DemoSessionDao dao;

	@Override
	public DemoSession addSession(DemoSession session) {
		return dao.save(session);
	}

	@Override
	public DemoSession updateSession(DemoSession session) {
		return dao.save(session);
	}

	@Override
	public void deleteSession(int sessionId) {
		dao.deleteById(sessionId);

	}

	@Override
	public Optional<DemoSession> getSessionById(int sessionId) {

		return dao.findById(sessionId);
	}

}

package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.DemoSession;

public interface DemoSessionService {

	DemoSession addSession(DemoSession session);

	DemoSession updateSession(DemoSession session);

	void deleteSession(int sessionId);

	Optional<DemoSession> getSessionById(int sessionId);

	List<DemoSession> getAllSessions();

	List<DemoSession> getByDate(String date);
}

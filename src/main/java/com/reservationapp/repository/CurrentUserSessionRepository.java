package com.reservationapp.repository;

import com.reservationapp.entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession,Long> {
    CurrentUserSession findByUuid(String uuid);
}

package com.practical.positionapi.repo;

import com.practical.positionapi.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PositionDao extends JpaRepository<Position, Long> {

    List<Position> findByAccountIdAndPositionDate(String accountId, Date positionDate);
}

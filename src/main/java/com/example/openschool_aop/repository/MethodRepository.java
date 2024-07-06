package com.example.openschool_aop.repository;

import com.example.openschool_aop.model.entity.MethodTimeTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodRepository extends JpaRepository<MethodTimeTrackEntity, Long> {

    @Query(value = "SELECT AVG(COMPLETION_TIME) FROM TIME_TRACK", nativeQuery = true)
    Double findAvgTimeForAllMethods();

    @Query(value = "SELECT AVG(COMPLETION_TIME) FROM TIME_TRACK WHERE METHOD_NAME = :methodName", nativeQuery = true)
    Double findAvgTimeForMethod(@Param("methodName") String methodName);

    @Query(value = "SELECT SUM(COMPLETION_TIME) FROM TIME_TRACK", nativeQuery = true)
    Long findAllMethodsSummaryTimeTrack();
}

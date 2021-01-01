package com.ztrzaska.repository;

import com.ztrzaska.model.BatchProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchProcessRepository extends JpaRepository<BatchProcess, Long> {


}

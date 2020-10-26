package com.hunterdemon.plant.repository;

import com.hunterdemon.plant.model.ReportInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportReponstory  extends JpaRepository<ReportInfor,String> {

}

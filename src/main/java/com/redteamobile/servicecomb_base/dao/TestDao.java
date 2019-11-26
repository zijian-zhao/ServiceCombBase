package com.redteamobile.servicecomb_base.dao;

import com.redteamobile.servicecomb_base.dao.entity.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestDao extends JpaRepository<TestBean,Long> {

    TestBean findByName(String name);

}

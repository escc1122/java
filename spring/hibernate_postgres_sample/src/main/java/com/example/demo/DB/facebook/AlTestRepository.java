package com.example.demo.DB.facebook;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.DB.facebook.AlTest;

import java.util.List;

/**
 * Created by alma on 2019/10/15.
 */
@Repository
public interface AlTestRepository extends JpaRepository<AlTest, Long> {

  List<AlTest> findByAa(int aa);

  @Query(value = "select new AlTest(b.aa) from AlTest b")
  List<AlTest> findByAaC(int aa);

  @Query(value = "select new AlTest(b.aa) from AlTest b")
  List<AlTest> findByAaC();

  @Query(value = "select b from AlTest b")
  List<AlTest> findByAaD();
}

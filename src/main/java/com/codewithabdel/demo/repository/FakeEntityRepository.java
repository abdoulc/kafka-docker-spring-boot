package com.codewithabdel.demo.repository;

import com.codewithabdel.demo.entity.FakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakeEntityRepository extends JpaRepository<FakeEntity, Long> {
}

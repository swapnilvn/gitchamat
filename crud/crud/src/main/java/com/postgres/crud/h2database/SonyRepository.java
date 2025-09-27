package com.postgres.crud.h2database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SonyRepository extends JpaRepository<Sony, Long> {
}

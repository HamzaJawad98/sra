package com.example.sra.recSwaps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecSwapsServiceRepo extends JpaRepository<RecSwaps, String>{
}

package com.example.sra.recSwaps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecSwapsServiceRepo extends JpaRepository<RecSwaps, String>{
    @Query(value = "insert into received_swap_req OUTPUT 'true'" +
            " values(:swappingId, 1, :senderRollNum)", nativeQuery = true)
    String sendSwapRequest(@Param("swappingId") Integer swappingId, @Param("senderRollNum") String senderRollNum);
}

package com.example.sra.swapping;

import com.example.sra.otherModels.SwapsPlusReceivedSwaps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SwappingServiceRepo extends JpaRepository<Swapping, String>{
    @Query(value="select max(swapping_id) from Swapping", nativeQuery = true)
    Integer getMaxSwappingId();

    @Query(value = "insert into swapping OUTPUT 'true' " +
            "values(:swappingId, :valid, :creatorRollNum, :courseNameFrom, " +
            ":courseSecFrom, :courseNameTo, :courseSecTo)", nativeQuery = true)
    String insertNewSwapRequest(@Param("swappingId") Integer swappingId, @Param("valid") Integer valid, @Param("creatorRollNum") String creatorRollNum,
                                @Param("courseNameFrom") String courseNameFrom, @Param("courseSecFrom") String courseSecFrom,
                                @Param("courseNameTo") String courseNameTo, @Param("courseSecTo") String courseSecTo);

    @Query(value="select * from Swapping where creator_roll_num = :roll_num and valid = 1", nativeQuery = true)
    List<Swapping> getMySwapRequests(@Param("roll_num") String roll_num);

    @Query(value="select * from Swapping where swapping_id = :swappingId and valid = 1", nativeQuery = true)
    Swapping getSwapRequest(@Param("swappingId") Integer swappingId);

    @Query(value = "select s.swapping_id AS swappingId, s.creator_roll_num As creatorRollNum, rs.sender_roll_num AS senderRollNum, " +
            "s.course_name_from AS courseNameFrom, s.course_sec_from as courseSecFrom, " +
            "s.course_name_to AS courseNameTo, s.course_sec_to as courseSecTo\n" +
            "from swapping s\n" +
            "join received_swap_req rs on s.swapping_id = rs.swapping_id\n" +
            "where s.creator_roll_num = :rollNum and s.valid = 1", nativeQuery = true)
    List<SwapsPlusReceivedSwaps> getIncomingSwapRequests(@Param("rollNum") String rollNum);

    @Query(value = "insert into user_notif OUTPUT 'true' " +
            "values(:rollNum, :message)", nativeQuery = true)
    String sendMessage(@Param("rollNum") String rollNum, @Param("message") String message);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Swapping s set s.valid = ?2 where s.swappingId = ?1")
//    void deleteSwapRequest(Integer swappingId, Integer valid);
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update RecSwaps rs set rs.valid = ?2 where rs.swappingId = ?1")
//    void deleteRecSwapRequests(Integer swappingId, Integer valid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Swapping s where s.swappingId = ?1")
    void deleteSwapRequest(Integer swappingId, Integer valid);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("delete from RecSwaps rs where rs.swappingId = ?1")
//    void deleteRecSwapRequests(Integer swappingId, Integer valid);

    @Query(value="select * from Swapping where creator_roll_num != :rollNum and valid = 1", nativeQuery = true)
    List<Swapping> findAllSwapRequests(@Param("rollNum") String rollNum);

}

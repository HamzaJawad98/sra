package com.example.sra.swapping;

import com.example.sra.otherModels.SwapsPlusReceivedSwaps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SwappingServiceRepo extends JpaRepository<Swapping, String>{
    @Query(value="select max(swapping_id) from Swapping", nativeQuery = true)
    Integer getMaxSwappingId();

    @Query(value = "insert into swapping OUTPUT 'true' " +
            "values(:swappingId, :creatorRollNum, :courseNameFrom, " +
            ":courseSecFrom, :courseNameTo, :courseSecTo)", nativeQuery = true)
    String insertNewSwapRequest(@Param("swappingId") Integer swappingId, @Param("creatorRollNum") String creatorRollNum,
                                @Param("courseNameFrom") String courseNameFrom, @Param("courseSecFrom") String courseSecFrom,
                                @Param("courseNameTo") String courseNameTo, @Param("courseSecTo") String courseSecTo);

    @Query(value="select * from Swapping where creator_roll_num = :roll_num", nativeQuery = true)
    List<Swapping> getMySwapRequests(@Param("roll_num") String roll_num);

    @Query(value="select * from Swapping where swapping_id = :swappingId", nativeQuery = true)
    Swapping getSwapRequest(@Param("swappingId") Integer swappingId);

    @Query(value = "select s.swapping_id AS swappingId, s.creator_roll_num As creatorRollNum, rs.sender_roll_num AS senderRollNum, " +
            "s.course_name_from AS courseNameFrom, s.course_sec_from as courseSecFrom, " +
            "s.course_name_to AS courseNameTo, s.course_sec_to as courseSecTo\n" +
            "from swapping s\n" +
            "join received_swap_req rs on s.swapping_id = rs.swapping_id\n" +
            "where s.creator_roll_num = :rollNum", nativeQuery = true)
    List<SwapsPlusReceivedSwaps> getIncomingSwapRequests(@Param("rollNum") String rollNum);

    @Query(value = "insert into user_notif OUTPUT 'true' " +
            "values(:rollNum, :message)", nativeQuery = true)
    String sendMessage(@Param("rollNum") String rollNum, @Param("message") String message);

    @Query(value = "delete from swapping where swapping_id = :swappingId)", nativeQuery = true)
    Void deleteSwapRequest(@Param("swappingId") Integer swappingId);

    @Query(value = "insert into received_swap_req OUTPUT 'true'" +
            " values(:swappingId, :senderRollNum)", nativeQuery = true)
    String sendSwapRequest(@Param ("swappingId") Integer swappingId, @Param("senderRollNum") String senderRollNum);

    @Query(value="select * from Swapping where creator_roll_num != :rollNum", nativeQuery = true)
    List<Swapping> findAllSwapRequests(@Param("rollNum") String rollNum);
}

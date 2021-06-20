package com.example.sra.swapping;

import com.example.sra.otherModels.SwapsPlusReceivedSwaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SwappingController {
    public static Integer swappingId = 0;

    @Autowired
    private SwappingServiceRepo swappingServiceRepo;

    @GetMapping("/swapping")
    public List<Swapping> getAllSwappings() {
        return swappingServiceRepo.findAll();
    }

    @PostMapping("/requestSwap")
    public String requestSwap(@RequestBody Map<String, String> payLoad) {
        try {
            String answer = null;
            swappingId = swappingServiceRepo.getMaxSwappingId() + 1;
            String rollNum = payLoad.get("rollNum");
            String courseNameFrom = payLoad.get("courseNameFrom");
            String courseSecFrom = payLoad.get("courseSecFrom");
            String courseNameTo = payLoad.get("courseNameTo");
            String courseSecTo = payLoad.get("courseSecTo");
            //Swapping swappingReq = new Swapping(swappingID, rollNum, courseNameFrom, courseSecFrom, courseNameTo, courseSecTo);
            swappingServiceRepo.insertNewSwapRequest(swappingId, rollNum, courseNameFrom, courseSecFrom, courseNameTo, courseSecTo);
            return "Success";
        }
        catch (DataAccessException e){
            return "Failure";
        }
    }

    @GetMapping("/currUserSwapRequests")
    @ResponseBody
    public List<Swapping> getMySwapRequests(@RequestParam String rollNum){
        List<Swapping> mySwapRequests;
        mySwapRequests = swappingServiceRepo.getMySwapRequests(rollNum);
        return mySwapRequests;
    }

    @GetMapping("/incomingSwapRequests")
    @ResponseBody
    public List<SwapsPlusReceivedSwaps> getIncomingRequests(@RequestParam String rollNum){
        List<SwapsPlusReceivedSwaps> recSwaps = swappingServiceRepo.getIncomingSwapRequests(rollNum);
        return recSwaps;
    }

    @PostMapping("/acceptIncomingRequest")
    public String acceptIncomingRequest(@RequestBody Map<String, String> payload)
    {
        try {
            Integer swappingId = Integer.parseInt(payload.get("swappingId"));
            String senderRollNum = payload.get("senderRollNum");
            String message = "";
            Swapping swapReq  = swappingServiceRepo.getSwapRequest(swappingId);
            message = "Congrats! Your request to swap to " + swapReq.courseNameTo + " from " + swapReq.courseNameFrom + " has been accepted ";
            swappingServiceRepo.sendMessage(senderRollNum, message);
            swappingServiceRepo.deleteSwapRequest(swappingId);
            return "Success";
        }
        catch (DataAccessException e) {
            return "Failure";
        }
    }

    @GetMapping("/getAllSwapRequests")
    public List<Swapping> getAllSwapRequests(@RequestParam String rollNum) {
        return swappingServiceRepo.findAllSwapRequests(rollNum);
    }

    @PostMapping("/sendSwapRequest")
    public String sendSwapRequest(@RequestBody Map<String, String> payload)
    {
        try {
            Integer swappingId = Integer.parseInt(payload.get("swappingId"));
            String senderRollNum = payload.get("senderRollNum");
            String answer = swappingServiceRepo.sendSwapRequest(swappingId, senderRollNum);
            return "Success";
        }
        catch (DataAccessException e)
        {
            return "Failure";
        }
    }
}

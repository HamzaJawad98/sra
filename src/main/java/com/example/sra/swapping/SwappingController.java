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
            List<Swapping> checkPrevSwapRequests = swappingServiceRepo.getMySwapRequests(rollNum);
            Boolean exists = false;
            for (int i = 0; i<checkPrevSwapRequests.size(); i++)
            {
                if (courseNameFrom.equalsIgnoreCase(checkPrevSwapRequests.get(i).getCourseNameFrom()) && courseSecFrom.equalsIgnoreCase(checkPrevSwapRequests.get(i).getCourseSecFrom())
                && courseNameTo.equalsIgnoreCase(checkPrevSwapRequests.get(i).getCourseNameTo()) && courseSecTo.equalsIgnoreCase(checkPrevSwapRequests.get(i).getCourseSecTo())){
                    exists = true;
                }
            }
            if (exists == false) {
                swappingServiceRepo.insertNewSwapRequest(swappingId, 1, rollNum, courseNameFrom, courseSecFrom, courseNameTo, courseSecTo);
                return "Success";
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/currUserSwapRequests")
    @ResponseBody
    public List<Swapping> getMySwapRequests(@RequestParam String rollNum){
        try {
            List<Swapping> mySwapRequests;
            mySwapRequests = swappingServiceRepo.getMySwapRequests(rollNum);
            return mySwapRequests;
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/incomingSwapRequests")
    @ResponseBody
    public List<SwapsPlusReceivedSwaps> getIncomingRequests(@RequestParam String rollNum){
        try {
            List<SwapsPlusReceivedSwaps> recSwaps = swappingServiceRepo.getIncomingSwapRequests(rollNum);
            return recSwaps;
        }
        catch (Exception e) {
            return null;
        }
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
            swappingServiceRepo.deleteSwapRequest(swappingId,0);
            //swappingServiceRepo.deleteRecSwapRequests(swappingId, 0);
            swappingServiceRepo.sendMessage(senderRollNum, message);
            return "Success";
        }
        catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAllSwapRequests")
    public List<Swapping> getAllSwapRequests(@RequestParam String rollNum) {
        try {
            return swappingServiceRepo.findAllSwapRequests(rollNum);
        }
        catch (Exception e){
            return null;
        }
    }

}

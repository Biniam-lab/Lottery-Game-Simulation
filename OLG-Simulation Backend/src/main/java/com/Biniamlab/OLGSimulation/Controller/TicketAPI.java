package com.Biniamlab.OLGSimulation.Controller;

import com.Biniamlab.OLGSimulation.Constant.LotteryType;
import com.Biniamlab.OLGSimulation.DataModel.Ticket;
import com.Biniamlab.OLGSimulation.Service.Lotto649Service;
import com.Biniamlab.OLGSimulation.Service.LottoMaxService;
import com.Biniamlab.OLGSimulation.UtilityClasses.LotteryTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lottery")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketAPI {

    private final LottoMaxService lottoMaxService;
    private final Lotto649Service lotto649Service;

    @Autowired
    public TicketAPI(LottoMaxService lottoMaxService, Lotto649Service lotto649Service) {
        this.lottoMaxService = lottoMaxService;
        this.lotto649Service = lotto649Service;
    }

    @GetMapping("/info")
    public ResponseEntity<List<LotteryTypeDTO>> info(){
        List<LotteryTypeDTO> lotteryTypes = Arrays.stream(LotteryType.values())
                                            .map(lotteryType -> {
                                                                 LotteryTypeDTO dto = new LotteryTypeDTO();
                                                                 dto.setLotteryName(lotteryType.name());
                                                                 dto.setLowerLimit(lotteryType.getLowerLimit());
                                                                 dto.setUpperLimit(lotteryType.getUpperLimit());
                                                                 dto.setNumberOfNumbers(lotteryType.getNumberOfNumbers());
                                                                 dto.setNumberOfLines(lotteryType.getNumberOfLines());
                                                                 return dto;
                                                                 }).collect(Collectors.toList());
        return ResponseEntity.ok(lotteryTypes);
    }

    @GetMapping("lottomax")
    public ResponseEntity<List<Integer>> generateLottoMaxLine(){
        return new ResponseEntity<>(lottoMaxService.generateLine(), HttpStatus.OK);
    }

    @PostMapping("lottomax/purchase")
    public ResponseEntity<Ticket> generateLottoMaxTicket(@RequestBody List<Integer> generatedLine){
        return new ResponseEntity<>(lottoMaxService.generateTicket(generatedLine), HttpStatus.CREATED);
    }

    @GetMapping("lottomax/all")
    public ResponseEntity<List<Ticket>> getAllLottoMaxTickets(){
        return new ResponseEntity<>(lottoMaxService.findAllTicketsByLotteryType(), HttpStatus.OK);
    }

    @GetMapping("lotto649")
    public ResponseEntity<List<Integer>> generateLotto649Line(){
        return new ResponseEntity<>(lotto649Service.generateLine(), HttpStatus.OK);
    }

    @PostMapping("lotto649/purchase")
    public ResponseEntity<Ticket> generateLotto649Ticket(@RequestBody List<Integer> generatedLine){
        return new ResponseEntity<>(lotto649Service.generateTicket(generatedLine), HttpStatus.CREATED);
    }

    @GetMapping("lotto649/all")
    public ResponseEntity<List<Ticket>> getAllLotto649Tickets(){
        return new ResponseEntity<>(lotto649Service.findAllTicketsByLotteryType(), HttpStatus.OK);
    }
}

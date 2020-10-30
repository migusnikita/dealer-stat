package ru.mail.migus_nikita.dealerstat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.TraderInfoRepository;

@Controller
public class TraderInfoController {

    private final TraderInfoRepository traderInfoRepository;

    public TraderInfoController(TraderInfoRepository traderInfoRepository) {this.traderInfoRepository = traderInfoRepository;}

    @GetMapping(path = "/get-traders-waiting-for-approves")
    public List<TraderInfo> getTraderInfo() {
        return traderInfoRepository.getTraderWaitingForApproved();
    }

}

package ru.mail.migus_nikita.dealerstat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.dto.NameAndCategoryTraderDto;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.TraderInfoRepository;

@RestController
public class TraderInfoController {

    @Autowired
    private final TraderInfoRepository traderInfoRepository;

    public TraderInfoController(TraderInfoRepository traderInfoRepository) {this.traderInfoRepository = traderInfoRepository;}

    @PostMapping("/post/add-trader")
    public void addUser(NameAndCategoryTraderDto nameAndCategoryTraderDto) {
        traderInfoRepository.addTrader(nameAndCategoryTraderDto);
    }

    @GetMapping(path = "/get-traders-waiting-for-approves/{status}")
    public List<TraderInfo> getTraderInfo(@PathVariable TraderInfoStatus status) {
        return traderInfoRepository.getTraderByStatus(status);
    }

    @GetMapping(path = "/change-status/{id}/{status}")
    public void changeStatusTrader(@PathVariable("id") int id, @PathVariable("status") TraderInfoStatus traderInfoStatus) {
        traderInfoRepository.changeStatusTrader(id, traderInfoStatus);
    }

    @GetMapping(path = "/get-approved-traders")
    public List<TraderInfo> getApprovedTraderInfo() {
        return traderInfoRepository.getTraderByStatus(TraderInfoStatus.APPROVED);
    }

}

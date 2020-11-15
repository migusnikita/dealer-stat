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
import ru.mail.migus_nikita.dealerstat.service.TraderInfoService;

@RestController
public class TraderInfoController {

    @Autowired
    private TraderInfoService traderInfoService;

    @PostMapping("/traders/add")
    public void addUser(NameAndCategoryTraderDto nameAndCategoryTraderDto) {
        traderInfoService.addTrader(nameAndCategoryTraderDto);
    }

    @GetMapping(path = "/traders/by-status/{status}")
    public List<TraderInfo> getTraderInfoByStatus(@PathVariable TraderInfoStatus status) {
        return traderInfoService.getTraderByStatus(status);
    }

    @GetMapping(path = "/traders/change-status/{id}/{status}")
    public void changeStatusTrader(@PathVariable("id") int id, @PathVariable("status") TraderInfoStatus traderInfoStatus) {
        traderInfoService.changeStatusTrader(id, traderInfoStatus);
    }

    @GetMapping(path = "/traders/get-approved-traders")
    public List<TraderInfo> getApprovedTraderInfo() {
        return traderInfoService.getTraderByStatus(TraderInfoStatus.APPROVED);
    }

}

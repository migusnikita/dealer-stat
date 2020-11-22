package ru.mail.migus_nikita.dealerstat.service;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.dto.NameAndCategoryTraderDto;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;

public interface TraderInfoService {

    List<TraderInfo> getTraderByStatus(TraderInfoStatus traderInfoStatus);

    void addTrader(NameAndCategoryTraderDto traderInfo);

    void changeStatusTrader(int id, TraderInfoStatus traderInfoStatus);

    TraderInfo findById(int id);

}

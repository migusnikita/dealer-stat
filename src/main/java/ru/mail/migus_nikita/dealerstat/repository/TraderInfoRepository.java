package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;

public interface TraderInfoRepository {

    List<TraderInfo> getTraderByStatus(TraderInfoStatus traderInfoStatus);

    void addTrader(TraderInfo traderInfo);

    void changeStatusTrader(int id, TraderInfoStatus traderInfoStatus);

    TraderInfo findById(int id);


}

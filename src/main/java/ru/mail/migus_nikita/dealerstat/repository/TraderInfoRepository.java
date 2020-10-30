package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.model.TraderInfo;

public interface TraderInfoRepository {

    List<TraderInfo> getTraderWaitingForApproved();

//    void addTrader(TraderInfo traderInfo);
//
//    void updateTrader(TraderInfo traderInfo);

}

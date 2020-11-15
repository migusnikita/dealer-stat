package ru.mail.migus_nikita.dealerstat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;
import ru.mail.migus_nikita.dealerstat.dto.NameAndCategoryTraderDto;
import ru.mail.migus_nikita.dealerstat.model.TraderInfo;
import ru.mail.migus_nikita.dealerstat.repository.TraderInfoRepository;
import ru.mail.migus_nikita.dealerstat.service.TraderInfoService;

@Service
public class TraderInfoServiceImpl implements TraderInfoService {

    private final TraderInfoRepository traderInfoRepository;

    public TraderInfoServiceImpl(TraderInfoRepository traderInfoRepository) {
        this.traderInfoRepository = traderInfoRepository;
    }

    @Override
    public List<TraderInfo> getTraderByStatus(TraderInfoStatus traderInfoStatus) {
        return traderInfoRepository.getTraderByStatus(traderInfoStatus);
    }

    @Override
    public void addTrader(NameAndCategoryTraderDto nameAndCategoryTraderDto) {

        TraderInfo traderInfo = new TraderInfo();
        traderInfo.setName(nameAndCategoryTraderDto.getName());
        traderInfo.setTraderCategory(nameAndCategoryTraderDto.getCategory());
        traderInfo.setTraderStatus(TraderInfoStatus.WAITING_FOR_APPROVE);
        traderInfoRepository.addTrader(traderInfo);
    }

    @Override
    public void changeStatusTrader(int id, TraderInfoStatus traderInfoStatus) {
        traderInfoRepository.changeStatusTrader(id, traderInfoStatus);

    }

    @Override
    public TraderInfo findById(int id) {
        return traderInfoRepository.findById(id);
    }

}


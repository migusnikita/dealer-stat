package ru.mail.migus_nikita.dealerstat.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoStatus;

@Getter
@Setter
public class NameAndStatusTraderDto {

    private String name;
    private TraderInfoStatus traderInfoStatus;

}

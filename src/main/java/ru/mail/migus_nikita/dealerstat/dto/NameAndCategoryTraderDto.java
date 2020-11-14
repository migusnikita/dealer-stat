package ru.mail.migus_nikita.dealerstat.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mail.migus_nikita.dealerstat.dictionary.TraderInfoCategory;

@Getter
@Setter
public class NameAndCategoryTraderDto {

    private String name;
    private TraderInfoCategory category;

}

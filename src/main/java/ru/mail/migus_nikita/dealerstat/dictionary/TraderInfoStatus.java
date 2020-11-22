package ru.mail.migus_nikita.dealerstat.dictionary;

/**
 * WAITING_FOR_APPROVE - в ожидании апрува админом/модератором
 * APPROVED - админ одобрил
 * DECLINED - админ отклонил
 * <p>
 * на главной странице отображаются только APPROVED посты, у себя на странице админ видит WAITING_FOR_APPROVE + APPROVED посты
 */
public enum TraderInfoStatus {
    APPROVED,
    DECLINED,
    WAITING_FOR_APPROVE;
}

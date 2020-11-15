package ru.mail.migus_nikita.dealerstat.dictionary;

/**
 *  WAITING_FOR_APPROVE - в ожидании апрува админом/модератором
 *  APPROVED - админ одобрил
 *  DECLINED - админ отклонил
 *
 *  в постах отображаются только APPROVED комменты, у себя на странице админ видит WAITING_FOR_APPROVE комментарии
 */
public enum CommentStatus {
    APPROVED,
    DECLINED,
    WAITING_FOR_APPROVE;
}

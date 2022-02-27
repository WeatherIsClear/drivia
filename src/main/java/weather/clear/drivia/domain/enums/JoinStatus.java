package weather.clear.drivia.domain.enums;

public enum JoinStatus {
    Request, // 신청, 대기
    Accept, // 수락
    Reject, // 거절
    Expire, // 만
    FailPayment, //결제 실패
}

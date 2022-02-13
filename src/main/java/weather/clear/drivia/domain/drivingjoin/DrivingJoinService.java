package weather.clear.drivia.domain.drivingjoin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.driving.repository.DrivingRepository;
import weather.clear.drivia.domain.drivingjoin.dto.DrivingJoinRequestDto;
import weather.clear.drivia.domain.drivingjoin.dto.DrivingJoinResponseDto;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;
import weather.clear.drivia.domain.drivingjoin.repository.DrivingJoinRepository;
import weather.clear.drivia.domain.member.MemberRepository;
import weather.clear.drivia.domain.member.entity.Member;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DrivingJoinService {

    private final MemberRepository memberRepository;
    private final DrivingRepository drivingRepository;
    private final DrivingJoinRepository drivingJoinRepository;

    public void drivingJoinRequest(DrivingJoinRequestDto request) {

        Member member = memberRepository.findById(request.getDriverId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Driving driving = drivingRepository.findById(request.getDrivingId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 드라이빙입니다."));

        DrivingJoin drivingJoin = DrivingJoin.of(member, driving);
        drivingJoinRepository.save(drivingJoin);
    }

    public void drivingJoinResponse(DrivingJoinResponseDto request) {

        DrivingJoin drivingJoin = drivingJoinRepository.findById(request.getDrivingJoinId()).orElseThrow(
                () -> new IllegalArgumentException("드라이버가 조인 요청을 취소하였습니다."));

        drivingJoin.joinResult(request.getStatus());
    }
}

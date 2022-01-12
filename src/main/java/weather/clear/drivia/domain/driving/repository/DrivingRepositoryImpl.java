package weather.clear.drivia.domain.driving.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import weather.clear.drivia.domain.driving.dto.DrivingInfoDto;

import javax.persistence.EntityManager;

public class DrivingRepositoryImpl implements DrivingRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public DrivingRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public DrivingInfoDto drivingInfo(Long drivingId) {
        return null;
    }
}

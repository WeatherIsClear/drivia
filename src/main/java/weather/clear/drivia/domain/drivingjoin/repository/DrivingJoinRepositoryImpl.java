package weather.clear.drivia.domain.drivingjoin.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

import javax.persistence.EntityManager;
import java.util.List;

import static weather.clear.drivia.domain.drivingjoin.entity.QDrivingJoin.*;
import static weather.clear.drivia.domain.member.entity.QMember.*;

public class DrivingJoinRepositoryImpl implements DrivingJoinRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public DrivingJoinRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<DrivingJoin> findWithDrivingDriver(Driving driving) {
        return queryFactory
                .selectFrom(drivingJoin)
                .join(drivingJoin.member, member).fetchJoin()
                .where(drivingJoin.driving.eq(driving))
                .fetch();
    }
}

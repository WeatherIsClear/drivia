package weather.clear.drivia.domain.driving.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import weather.clear.drivia.domain.car.QCar;
import weather.clear.drivia.domain.carmodel.QCarModel;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.driving.QDriving;
import weather.clear.drivia.domain.member.entity.QMember;

import javax.persistence.EntityManager;

import static weather.clear.drivia.domain.car.QCar.*;
import static weather.clear.drivia.domain.carmodel.QCarModel.*;
import static weather.clear.drivia.domain.driving.QDriving.*;
import static weather.clear.drivia.domain.member.entity.QMember.*;

public class DrivingRepositoryImpl implements DrivingRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public DrivingRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Driving drivingInfo(Long drivingId) {
        return queryFactory
                .selectFrom(driving)
                .join(driving.member, member).fetchJoin()
                .join(driving.car, car).fetchJoin()
                .join(driving.car.carModel, carModel).fetchJoin()
                .where(driving.id.eq(drivingId))
                .fetchOne();
    }
}

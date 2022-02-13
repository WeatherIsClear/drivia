package weather.clear.drivia.domain.drivingjoin.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class DrivingJoinRepositoryImpl {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public DrivingJoinRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }



}

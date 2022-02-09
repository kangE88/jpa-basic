package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member();
//            member.setUserName("C");
//
//            em.persist(member);

//            수정
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.Id >>" + findMember.getId());
//            System.out.println("findMember.name >>" + findMember.getName());
//
//            findMember.setName("kangA");

            //JPQL
//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class).getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("JpaMain.main member.name =" + member.getName());
//            }

            //Team team = new Team();
            //team.setName("TeamA");
            //team.getMembers().add(member);
            //em.persist(team);

            //Member member = new Member();
            //member.setUsername("member1");
            //member.setTeam(team);
            //em.persist(member);



            //em.flush(); //위 영속성 컨텍스트 안에 있는 내용을 먼저 실행
            //em.clear(); //영속성 컨텍스트 초기화
            // flush 와 clear 사용하면 아래 문장은 select 쿼리 실행한다

            //Member findMember = em.find(Member.class, member.getId());

            //Team findTeam = findMember.getTeam();
            //System.out.println("findTeam = " + findTeam.getName());

            // 100번째 데이터를 찾아 수정하기
            //Team newTeam = em.find(Team.class, 100L);
            //findMember.setTeam(newTeam);

            //List<Member> members = findMember.getTeam().getMembers();
            //for (Member m : members) {
            //    System.out.println("JpaMain.main m = " + m.getUsername());
            //}

            /*
            * 고급매핑 - 조인 전략
            */
//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);

            //InheritanceType.JOINED 사용 예제

            //프록시 예제 start
//            Member member = new Member();
//            member.setName("hello");
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setName("mem2");
//            em.persist(member2);
//
//
//            em.flush();
//            em.clear();
//
//            System.out.println("m1 == m2:" + (member.getClass() == member2.getClass()));
//
//            //
//            //Member findMember = em.find(Member.class, member.getId());
//            //System.out.println("findMember.getId() = " + findMember.getId());
//            //System.out.println("findMember.getName() = " + findMember.getName());
//
//            Member findMember = em.getReference(Member.class, member.getId());
//            Member findMember2 = em.find(Member.class, member2.getId());
//
//            System.out.println("findMember == findMember2 = " + (findMember.getClass() == findMember2.getClass()));
//
//            //영속성 컨텍스트 삭제
//            //em.detach(findMember);
//            //em.close();
//            //em.clear();
//
//            System.out.println("findMember = " + findMember.getClass());
//            //System.out.println("findMember.getId() = " + findMember.getId());
//            //System.out.println("findMember.getName() = " + findMember.getName());
//
//            //프록시 인스턴스 초기화 여부 확인
//            System.out.println("isLoaded = "+ emf.getPersistenceUnitUtil().isLoaded(findMember));
//
//            findMember2.getName(); //강제초기화
//            Hibernate.initialize(findMember2); //강제초기화 - Hibernate

            //프록시 예제 End

            //즉시 로딩과 지연 로딩 start
            //지연로딩 LAZY를 사용해서 프록시로 조회
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setName("member1");
//            member1.setTeam(team);
//
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member1.getId());
//            //현 시점엔 select member만 조회
//
//            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//            //team 정보가 프록시에 setting됨
//            //프록시 설정된 상태에서 아래의 getTeam을 통해 team을 select하여 프록시에 저장
//            System.out.println("JpaMain.main ======");
//            m.getTeam().getName(); //
//            System.out.println("JpaMain.main ======");
//
//            //JPQL 지연로딩을 통한 team엔티티 조인 방법
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
//            //member와 team을 조인해서 가져옴 지연로딩일떄 member entity안에 team을 가져올때 사용하는 방법

            //즉시 로딩과 지연 로딩 End

            //영속성 전이(CASCADE)와 고아 객체
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            //parent와 child1 child2를 저장한다 가정했을때.. 아래와 같이 선언한다.
            em.persist(parent);
            //em.persist(child1);
            //em.persist(child2);

            //하지만 parent 만 저장할때 child 까지 한번에 해결하기위해선. Entity 설정에 cascade를 적용하면 된다.
            //ALL : 모두 적용 PERSIST: 영속 REMOVE: 삭제 MERGE: 병합 REFRESH: REFRESH, DETACH: DETACH
            //child Entity가 다른곳에서도 쓰인다면 cascade를 사용하면 안된다.

            //고아 객체
            // orphanRemoval = true 엔티티에 적용하면 같이 parent에 같이 바라보는 child는 같이 삭제가 된다.
            //
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);
//            findParent.getChildList().remove(0);

            //고아 객체
            //영속성 전이(CASCADE)와 고아 객체


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

package hellojpa;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
            //Child child1 = new Child();
            //Child child2 = new Child();

            //Parent parent = new Parent();
            //parent.addChild(child1);
            //parent.addChild(child2);

            //parent와 child1 child2를 저장한다 가정했을때.. 아래와 같이 선언한다.
            //em.persist(parent);
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

            //임베디드 타입 설정
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city", "Street", "10000"));
//            member.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));
//
//            em.persist(member);
            //임베디드 타입 설정

            //값 타입과 불변 객체
//            Address address = new Address("city", "Street", "10000");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            //새로 생성해서 새로 집어 넣어야 한다.
//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member.setHomeAddress(newAddress);


//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);

            //첫번째 멤버만 주소를 변경하고 싶을때.. 아래와 같이 사용할것이다.
            //member.getHomeAddress().setCity("newCity"); //이제 사용 불
            //DB를 조회하면 둘다 변경되어 있다.


            //값 타입과 불변 객체

            //값 타입 컬렉션
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1","street","1000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "1001"));
            member.getAddressHistory().add(new AddressEntity("old2", "street2", "1002"));

            em.persist(member);

            em.flush();
            em.clear();

            //
            System.out.println("JpaMain.main=======");
            Member findMember = em.find(Member.class, member.getId());

            //지연로딩이라 FavoriteFoods와 AddressHistory는 나오지 않는다.

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
            //위처럼 선언하고 사용해야 select쿼리가 실행된다.

            //값 타입의 필드를 하나를 변경하고자 한다면 인스턴스를 새로 생성해서 교체해줘야 한다. 그렇지 않으면 서브사이드 쿼리에 의해 다른 컬럼도 전부 수정된다.
            //city1 -> netCity
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("netCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            // 찾는 대상은 equals hashcode 동작한다
            // 그러므로 아래와 같이 검색하여 삭제 후 등록 하는 방식을 사용한
            findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "1001"));
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "1001"));

            //값 타입 컬렉션

            //JPQL
            List<Member> resultList = em.createQuery("select m FROM Member m where m.username like '%mem%'", Member.class).getResultList();

            for (Member result : resultList) {
                System.out.println("result = " + result.getUsername());
            }
            //JPQL

            //Criteria

            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            //루트 클래스 (조회를 시작할 클래스)
            Root<Member> from = query.from(Member.class);

            //쿼리 생성
            CriteriaQuery<Member> where = query.select(from).where(cb.equal(from.get("username"), "mem"));
            List<Member> resultList1 = em.createQuery(where).getResultList();

            for (Member member1 : resultList1) {
                System.out.println("member1 = " + member1.getUsername());
            }

            //Criteria

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

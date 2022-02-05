package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

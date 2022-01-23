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

            Member member = new Member();
            member.setUserName("C");

            em.persist(member);

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

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

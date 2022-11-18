package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(4L);
//            member.setName("HelloD");
//            Member findMember = em.find(Member.class, 4L);
//            findMember.setName("HelloJPA"); // How? -> JPA 를 통해 Entity 를 가져오면, 관리해줌. Transaction 전에 업데이트 쿼리를 날려줌. 헉!
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList(); // 멤버 객체들을 전부 가져와. (테이블 대상이 아닌 객체 대상)

            for (Member member : result
                 ) {
                System.out.println(member.getName());
            }

            tx.commit();

//            findMember.setName("UpdatedMemberD");
//            em.persist(member);
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

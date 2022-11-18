package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPATutorial {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hallo");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setId(5L);
        member.setName("Tutorial");

        em.persist(member);

//        Member findMember = em.find(Member.class, 3L);
//        findMember.setName("seongbo");

        tx.commit();

        em.close();
        emf.close();

    }
}

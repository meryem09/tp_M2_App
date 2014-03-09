package ejb;


import java.util.*;

import javax.ejb.*;
import javax.persistence.*;

import Model.Marin;

@Stateless
public class MarinEJB {
	@PersistenceContext(unitName="paumardproject")
	private EntityManager em ;

	public Long createMarin(Marin marin) {

		em.persist(marin) ;
		return marin.getId() ;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List deleteMarin(Marin marin ){

		javax.persistence.Query q = em.createQuery("select Marin from Marin marin where marin.nom =" +"'" +marin.getNom()+"'" );
		List<Marin> marins = q.getResultList() ;
		for (Marin marin1 : marins) {
			em.remove(marin1);
		}
		return marins;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List deleteMarinByPrenom(Marin marin ){

		javax.persistence.Query q = em.createQuery("select Marin from Marin marin where marin.prenom =" +"'" +marin.getPrenom()+"'" );
		List<Marin> marins = q.getResultList() ;
		for (Marin marin1 : marins) {
			em.remove(marin1);
		}
		return marins;
	}
	@SuppressWarnings("unused")
	public void retreaveMarin(Long Id ){
		Marin marin=new Marin();
		marin= em.find(Marin.class, Id);

	}

}
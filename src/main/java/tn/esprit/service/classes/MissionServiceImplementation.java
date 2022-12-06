package tn.esprit.service.classes;


import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.dao.entities.Mission;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.MissionRepository;
import tn.esprit.service.interfaces.MissionService;

@Service
@Slf4j
public class MissionServiceImplementation implements MissionService {

	  @Autowired
		MissionRepository missrep ;
	  @Autowired
	  ContratRepository contrep ;
	    
	
	@Override
	public List<Mission> retrieveAllMissions() {
		return missrep.findAll();
	}

	@Override
	public Mission addMission(Mission m) {
		
			missrep.save(m);	
			return m;
	}

	@Override
	public Mission updateMission(Mission m) {
		Mission m1=retrieveMission(m.getIdMission());
		 if(m.hashCode()!=m1.hashCode()) {
	    	 // log.info("new Value saved "+m);
	     }else {
	    	//  log.info("not saved "+m);

	     }
	      return missrep.save(m); 
 
	}

	@Override
	public Mission retrieveMission(Integer idMission) {
		return missrep.findById(idMission).get();
	}

	@Override
	public void removeMission(Integer idMission) {
		 missrep.deleteById(idMission);	
		
	}

	
	@Override
	public void assignMissionToContrat(Integer missionId, Integer contratId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Mission> retrieveMissionsByContrat(Integer idContrat) {
		
		return missrep.getMissionsByContrat(idContrat);
	}

}


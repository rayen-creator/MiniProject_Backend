package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dto.ContratDto;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.dto.mapper.ContratMapper;
import tn.esprit.service.interfaces.ContratService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ContratServiceImpl implements ContratService {
    @Autowired
    ContratRepository cRep;
    @Autowired
    ContratMapper cMapper;

    @Override
    public Contrat afficherContrat(int id) {

    	return cRep.findById(id).get();
    }
    @Override
    public List<Contrat> afficherContratDto(int id) {

    	return cRep.findAll();
    }

    @Override
    public int ajouterContrat(Contrat c) {
        cRep.save(c);
        log.info("contrat "+c.getIdContrat()+" ajouté avec success");
        return c.getIdContrat();
    }



    @Override
    public void supprimerContrat(int id) {
        cRep.deleteById(id);
        log.info("contrat supprimé");
    }

    @Override
    public List<Contrat> chercherContrats() {
        List<Contrat> contrats = (List<Contrat>) cRep.findAll();
        for(Contrat contrat: contrats) {
            log.info("contrat : " + contrat);
        }
        return contrats;
    }

    @Scheduled(cron="* * 13 * * *")
    @Override
    public String retrieveAndUpdateStatusContrat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        List<Contrat> listContrats = this.chercherContrats();
        String result = "";
        for(Contrat c : listContrats) {
            if(c.getDateFinContrat().compareTo(date) == 1) {
                c.setArchive(true);
                this.cRep.save(c);
                result += c.getDateFinContrat() + " "+c.getSpecialite()+ " "+c.getEtudiant();
            }
        }
        return result;
    }
    @Override
    public List<ContratDto> ContratsValides(Date startDate, Date endDate){
        List<Contrat> listCon = cRep.ContratValideByDate(startDate, endDate);
        List<ContratDto> contratDtoList = cMapper.toDtoList(listCon);
        return contratDtoList;

    }
    @Override
    public Integer nbContratsValides(Date startDate, Date endDate){
        List<Contrat> listCon = cRep.ContratValideByDate(startDate, endDate);
        List<ContratDto> contratDtoList = cMapper.toDtoList(listCon);
        Integer count = Math.toIntExact(contratDtoList.stream().count());
        return count;

    }
    
	@Override
	public int affecterContratToEtudiant(int i,int idc) {
      return cRep.affecterContratToEtudiant(i,idc);	
	}

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listCon = cRep.ContratValideByDate(startDate, endDate);
        List<ContratDto> contratDtoList = cMapper.toDtoList(listCon);
        float total = 0f;

        long monthsBetween = 0;

        long daysDiff = 0;
        for (ContratDto contrat : contratDtoList) {
            if (Objects.equals(contrat.getSpecialite().toString(), "IA")){
            long dateBeforeInMs = contrat.getDateDebutContrat().getTime();
            long dateAfterInMs = contrat.getDateFinContrat().getTime();
            long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);
            daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            total += (daysDiff * 10);}
            else if (Objects.equals(contrat.getSpecialite().toString(), "RESEAUX")) {
                long dateBeforeInMs = contrat.getDateDebutContrat().getTime();
                long dateAfterInMs = contrat.getDateFinContrat().getTime();
                long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);
                daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
                total += (daysDiff * (350/30));
            }
            else if (Objects.equals(contrat.getSpecialite().toString(), "CLOUD")) {
                long dateBeforeInMs = contrat.getDateDebutContrat().getTime();
                long dateAfterInMs = contrat.getDateFinContrat().getTime();
                long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);
                daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
                total += (daysDiff * (400/30));
            }
            else if (Objects.equals(contrat.getSpecialite().toString(), "SECURITE")) {
                long dateBeforeInMs = contrat.getDateDebutContrat().getTime();
                long dateAfterInMs = contrat.getDateFinContrat().getTime();
                long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);
                daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
                total += (daysDiff * (450/30));
            }


        }
        System.out.println(daysDiff);
        return total;
    }
	@Override
	public Contrat mettreAjourContrat(Contrat c) {
			Contrat ce1=afficherContrat(c.getIdContrat());
		//log.info(""+ce.getIdContrat()+"Data before saving:");
	     // log.info("saving new contrat values  ...");
	     if(c.hashCode()!=ce1.hashCode()) {
	    	 // log.info("new Value saved "+ce);
	     }else {
	    	//  log.info("not saved "+ce);

	     }
	      return cRep.saveAndFlush(c);
	}
	@Override
	public List<Contrat> chercherContratsDto() {
		System.out.println(cRep.findAll());
		return cRep.findAll();
	}
}

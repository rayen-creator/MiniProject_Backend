package tn.esprit.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.dao.entities.Mission;
import tn.esprit.service.interfaces.MissionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/controllerMission")
public class MissionController {

	  @Autowired
	  MissionService missServ;
	 
	 
	  @GetMapping("/DisplayMissions")
	  public List<Mission> DisplayMissions() {
		  return missServ.retrieveAllMissions();
	  }
	   
	  @GetMapping("/DisplayMissionById/{id}")
	  public Mission displayMissionByID(@PathVariable("id") int id) {
		  
		  return missServ.retrieveMission(id); 
		  }
	  @GetMapping("/DisplayMissionByContrat/{idc}")
	  public List<Mission> DisplayMissionByContrat(@PathVariable("idc") int id) {
		  
		  return missServ.retrieveMissionsByContrat(id); 
		  }
	  
	  @PostMapping("/ajouterMission")
	  public Mission addMission(@RequestBody Mission m) {
		  m=missServ.addMission(m);
		  return  m ;
	  }
	  
	  @PutMapping("/updateMissionById")
	  public Mission updateMission(@RequestBody Mission m) {
		return  missServ.updateMission(m);
			}
	  
	  @DeleteMapping("/deleteMission/{id}")
	  public String deleteMissionById(@PathVariable("id") int id){
		  missServ.removeMission(id);
	   return ""+displayMissionByID(id).getTitle()+"deleted successfully"; 
	   }
	  

	  
		@PutMapping("assignMissionToContrat/{idc}/{idm}")
		public void assignMissionToContrat( @PathVariable("idc") Integer idc, @PathVariable("idm") Integer idm) {
			missServ.assignMissionToContrat(idc, idm);
		}
	  }

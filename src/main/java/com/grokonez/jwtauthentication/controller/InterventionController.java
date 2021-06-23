package com.grokonez.jwtauthentication.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Intervention;
import com.grokonez.jwtauthentication.entitys.Machine;
import com.grokonez.jwtauthentication.entitys.Notifications;
import com.grokonez.jwtauthentication.message.response.AddIntervention;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.InterventionRepository;
import com.grokonez.jwtauthentication.repository.MachineRepository;
import com.grokonez.jwtauthentication.repository.NotificationsRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;

import java.util.ArrayList;
import java.util.Date;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
	
	@Autowired
	InterventionRepository interventionRepository;
	
	@Autowired
	MachineRepository machineRepository;
	
    @Autowired
    JwtProvider jwtProvider;
    
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	NotificationsRepository notificationsRepository;
	
	
	@GetMapping("/list")
	public List<Intervention> getALLInterventions(){
		return this.interventionRepository.findAll();
	}
	

	@GetMapping("/mylist")
	public List<Intervention> getUserInterventions( HttpServletRequest req){
		
        User current;
        String token = req.getHeader("authorization").replace("Bearer " ,"");
        System.out.println(token);
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username).get();
        
        List<Intervention> tmp = new ArrayList<Intervention>();
        List<Intervention> all = this.interventionRepository.findAll();
        
        for( Intervention i:all ) {
        	if( i.getUser().getId() == current.getId() ) {
        		tmp.add(i);
        	}
        }
		
		return tmp;
	}
	
	
	
	 @PostMapping("/add")
	 public Intervention addNewMachine(@RequestBody AddIntervention intervention, HttpServletRequest req ){
		 
		 
				
        Optional<User> current;
        String token = req.getHeader("authorization").replace("Bearer " ,"");
        System.out.println(token);
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username);
        
		        
		 Intervention i = new Intervention();
		 
		 i.setDescription(intervention.getDescription());
		 i.setMachine(
				 this.machineRepository.findById(intervention.getId_machine()).get()
				 );
		 i.setParametersString(intervention.getParametersString());
		 i.setUtilTimestamp( new Date());
		 i.setUser(current.get());
		 
		 
		 
		 // send notifications
		 
		 	Notifications n = new Notifications();
			
			n.setTitle("Nouvelle interventions");
			n.setMessage( current.get().getName()+" a ajouté une nouvelle intervention sur machine "+i.getMachine().getName() );
			n.setAdddate(new Date());
			n.setSeen(false);
			n.setUser( this.userRepository.findByUsername("admin").get() ) ;
			
			Notifications n2 = new Notifications();
			
			n2.setTitle("Nouvelle interventions");
			n2.setMessage( current.get().getName()+" a ajouté une nouvelle intervention sur machine "+i.getMachine().getName() );
			n2.setAdddate(new Date());
			n2.setSeen(false);
			n2.setUser( this.userRepository.findByUsername("proccess").get() ) ;
			
			this.notificationsRepository.save(n);
			this.notificationsRepository.save(n2);
			
		 
		 
		 
		 
		 
		 return this.interventionRepository.save(i);
	 }
	
	
	
	

}

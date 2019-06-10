package org.project.proxibank.security.seeders;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.project.proxibank.entities.User;
import org.project.proxibank.security.entities.Authority;
import org.project.proxibank.security.entities.AuthorityName;
import org.project.proxibank.security.repostiory.AuthorityRepository;
import org.project.proxibank.security.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
//	@Autowired
//    private UserRepository userRepository;
//    
//    @Autowired
//	private AuthorityRepository authorityRepository;
//	
//
//    @Override
//    public void run(String... args) throws Exception {
//    	/*Profil picture folder*/
//    	new File((new File("").getAbsolutePath()+File.separator+"profil")).mkdirs();
//    
//    	/*Insert Roles*/
//    	List<Authority> authoritiesToStore= new LinkedList<Authority>();
//    	
//    	authoritiesToStore.add(new Authority(1L, AuthorityName.ROLE_CLIENT));
//    	authoritiesToStore.add(new Authority(2L, AuthorityName.ROLE_ADMIN));
//    	
//    	List<Authority> authoritiesFromDb= authorityRepository.findAll();
//    	for (Authority authorityToStore : authoritiesToStore) {
//    		boolean found= false;
//    		for(Authority authorityFromDb : authoritiesFromDb){
//    			if(authorityToStore.getName().toString().equals(authorityFromDb.getName().toString())) {
//    				found= true;
//    			}
//    		}
//    		if(!found) {
//    			authorityRepository.save(authorityToStore);
//    		}
//		}
    	
    	/*Insert User*/
//        User user =  userRepository.findByEmail("admin@admin.com");
//
//        if(user==null){
//            List<Authority> authorities = new ArrayList<>();
//            authorities.add(authorityRepository.findByName(AuthorityName.ROLE_ADMIN));
//
//            user = new User();
//            user.setAuthorities(authorities);
//            user.setEmail("admin@admin.com");
//            user.setFirstname("admin");
//            user.setLastname("admin");
//            user.setEnabled(true);
//            user.setPassword(encodePassword("admin1"));
//            userRepository.save(user);
//        }
//    	
//    }
//    
//    private String encodePassword(String password){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(password);
//    }
	
}

package org.project.proxibank.controller;

import org.project.proxibank.entities.vo.Virement;
import org.project.proxibank.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/virement")
@CrossOrigin("*")
public class VirementController {

    @Autowired
    private IOperationService operationService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Virement virement){
    	boolean isDone = operationService.debit(virement.getAccountDeb(), virement.getAmount());
    	if(!isDone) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
        operationService.credit(virement.getAccountCred(), virement.getAmount());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

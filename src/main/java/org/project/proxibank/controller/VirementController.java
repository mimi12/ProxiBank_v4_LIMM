package org.project.proxibank.controller;

import org.project.proxibank.entities.VO.Virement;
import org.project.proxibank.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/virement")
@CrossOrigin("*")
public class VirementController {

    @Autowired
    private IOperationService operationService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Virement virement){
        operationService.credit(virement.getAccountCred(), virement.getAmount());
        operationService.debit(virement.getAccountDeb(), virement.getAmount());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

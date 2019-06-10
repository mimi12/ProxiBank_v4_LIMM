package org.project.proxibank.controller;

import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.Operation;
import org.project.proxibank.entities.vo.OperationVo;
import org.project.proxibank.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operation")
@CrossOrigin("*")
public class OperationController {

    @Autowired
    IOperationService operationService;

    @GetMapping("/{id}")
    public List<Operation> getClient(@PathVariable("id") Long id) {
        return operationService.findByAccountId(id);
    }
    
    @GetMapping("/audit")
    public List<OperationVo> audit() {
        return operationService.audit().stream().map(OperationVo::new).collect(Collectors.toList());
    }
}

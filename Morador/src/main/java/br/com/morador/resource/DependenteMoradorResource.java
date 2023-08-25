package br.com.morador.resource;

import br.com.morador.service.DependentesMoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dependente")
public class DependenteMoradorResource {
    @Autowired
    private DependentesMoradorService dependentesMoradorService;
}

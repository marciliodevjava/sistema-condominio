package br.com.morador.manager;

import br.com.morador.query.DependentesMoradorQuery;
import br.com.morador.repository.DependentesMoradorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependentesManager {
    @Autowired
    private DependentesMoradorRepository dependentesMoradorRepository;
    @Autowired
    private DependentesMoradorQuery dependentesMoradorQuery;
    @Autowired
    private HttpServletRequest request;
}

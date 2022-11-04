package com.tienda.service;

import com.tienda.dao.CreditoDao;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditoServiceImpl implements CreditoService {
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Credito> getCreditos() {
        return (List<Credito>) creditoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Credito credito) {
        creditoDao.save(credito);
    }

    @Override
    @Transactional
    public void delete(Credito credito) {
        creditoDao.delete(credito);
    }

    @Override
    @Transactional(readOnly = true)
    public Credito getCredito(Credito credito) {
        return creditoDao.findById(credito.getIdCredito()).orElse(null);
    }
}

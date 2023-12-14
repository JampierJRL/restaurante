package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.model.entity.DepartamentosModel;
import com.aturiasrest.model.entity.DistritosModel;
import com.aturiasrest.model.entity.ProvinciasModel;
import com.aturiasrest.model.repository.DepartamentosRepository;
import com.aturiasrest.model.repository.DistritosRepository;
import com.aturiasrest.model.repository.ProvinciasRepository;
import com.aturiasrest.model.service.UbigeoService;

@Service
public class UbigeoServiceImple implements UbigeoService {

	@Autowired
	private DepartamentosRepository departamentoRepository;

	
	@Autowired
	private ProvinciasRepository provinciasRepository;
	
	
	@Autowired
	private DistritosRepository distritosRepository;
	
	@Override
	public List<DepartamentosModel> srvListaDepartamentos() {
		List<DepartamentosModel> lista = new ArrayList<>();
		try {
			lista = departamentoRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public List<ProvinciasModel> srvListaProvincias(int codDepartamento) {
		List<ProvinciasModel> lista = new ArrayList<>();
		try {
			lista = provinciasRepository.findByDepartamentoCodDepartamento(codDepartamento);
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public List<DistritosModel> srvListaDistritos(int codProvincia) {
		List<DistritosModel> lista = new ArrayList<>();
		try {
			lista = distritosRepository.findByProvinciaCodProvincia(codProvincia);
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}
}

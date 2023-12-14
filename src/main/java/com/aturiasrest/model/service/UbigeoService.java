package com.aturiasrest.model.service;

import java.util.List;

import com.aturiasrest.model.entity.DepartamentosModel;
import com.aturiasrest.model.entity.DistritosModel;
import com.aturiasrest.model.entity.ProvinciasModel;

public interface UbigeoService {

	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA CATEGORIAS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<DepartamentosModel> srvListaDepartamentos();
	
	List<ProvinciasModel> srvListaProvincias(int codDepartamento);
	
	List<DistritosModel> srvListaDistritos(int codProvincia);
	
	
	
}

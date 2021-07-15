package br.com.dev.jr.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dev.jr.dto.EnderecoDTO;

@Repository
public class EnderecoDAO {
	
	private static List<EnderecoDTO> bdDeEnderecos = new ArrayList<EnderecoDTO>();

	public void salvar(EnderecoDTO enderecoDTO) {
		bdDeEnderecos.add(enderecoDTO);
	}
	
	public List<EnderecoDTO> listarTodos(){
		return bdDeEnderecos;
	}
	
	public Boolean buscarEnderecoPorCep(String cep) {
		Boolean jaExiste = false;
		for (int i = 0; i < bdDeEnderecos.size(); i++) {
			if (bdDeEnderecos.get(i).getCep().equals(cep)) {
				jaExiste = true;
				break;
			}
		}
		return jaExiste;
	}

}

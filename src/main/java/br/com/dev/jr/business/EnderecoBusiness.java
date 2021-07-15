package br.com.dev.jr.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.jr.dao.EnderecoDAO;
import br.com.dev.jr.dto.EnderecoDTO;

@Service
public class EnderecoBusiness {

	@Autowired
	private EnderecoDAO enderecoDAO;
	
	private void validarCamposObrigatorios(EnderecoDTO enderecoDTO) throws Exception {
		if (enderecoDTO.getCep() == null) {
			throw new Exception("Cep não pode ser nulo.");
		}
		
		Boolean jaExiste = this.enderecoDAO.buscarEnderecoPorCep(enderecoDTO.getCep());
		if (jaExiste) {
			throw new Exception("Não é permitido cadastrar mais de um cep.");
		}
	}

	public void adicionarEndereco(EnderecoDTO enderecoDTO) throws Exception {
		this.validarCamposObrigatorios(enderecoDTO);
		this.enderecoDAO.salvar(enderecoDTO);
	}

	public List<EnderecoDTO> listarTodos(){
		return this.enderecoDAO.listarTodos();
	}
	
}

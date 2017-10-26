package ine5448;

import java.util.HashMap;
import java.util.LinkedList;

public class Projeto {
	
	//Funcionário é da empresa não do projeto
	private LinkedList<Funcionario> listaFuncionarios;
	private HashMap<Integer, Ocorrencia> listaOcorrencias;
	private String nome; 
	
	public Projeto(String nome) {
		
		this.nome = nome;
		listaFuncionarios = new LinkedList<Funcionario>();
		listaOcorrencias = new HashMap<Integer, Ocorrencia>();
	}
	
	public void adicionarFuncionario(Funcionario umFuncionario) {
		
		if (!listaFuncionarios.contains(umFuncionario))
			listaFuncionarios.add(umFuncionario);
	}
	
	public void adicionarOcorrencia(Ocorrencia umaOcorrencia, Funcionario responsavel) throws Exception {
		
		if(listaOcorrencias.containsKey(umaOcorrencia.obterCodigo()) == true)		
			throw new Exception("Código existente ou negativo");
		umaOcorrencia.adicionarResponsavel(responsavel);
		responsavel.adicionarOcorrencia(umaOcorrencia);
		listaOcorrencias.put(umaOcorrencia.obterCodigo(),umaOcorrencia);
	}

	public Ocorrencia obterOcorrencia(int codigo) throws Exception{
		if (listaOcorrencias.containsKey(codigo)) {
			return listaOcorrencias.get(codigo);
		}
		throw new Exception ("Ocorrencia nao existe");
	}
	
	public HashMap<Integer,Ocorrencia> obterOcorrencias() {	
		return listaOcorrencias;
	}

	public String obterNome() {
		return nome;
	}

}

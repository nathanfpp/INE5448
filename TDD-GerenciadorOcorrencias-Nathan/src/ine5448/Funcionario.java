package ine5448;

import java.util.LinkedList;

public class Funcionario {

	private static final int LIMITE_OCORRENCIAS = 10;
	private LinkedList<Ocorrencia> listaOcorrencias;
	private LinkedList<Projeto> listaProjetos;
	private String nome;

	public Funcionario(String nome) {
		this.nome = nome;
		listaOcorrencias = new LinkedList<Ocorrencia>();
		listaProjetos = new LinkedList<Projeto>();
	}

	public void adicionarOcorrencia(Ocorrencia umaOcorrencia) throws Exception {
		if (listaOcorrencias.size() < LIMITE_OCORRENCIAS)
			listaOcorrencias.add(umaOcorrencia);
		else
			throw new Exception("O Funcionario: " + nome + " ja atingiu o limite de 10 ocorrencias");
	}
	
	public void adicionarProjeto(Projeto umProjeto) throws Exception {
			listaProjetos.add(umProjeto);
	}
	
	public void removerOcorrencia(Ocorrencia ocorrencia) {
		for (int i = 0; i < listaOcorrencias.size(); i++) {
			if (listaOcorrencias.get(i) == ocorrencia)
				listaOcorrencias.remove(i);
		}
	}

	public String obterNome() {
		return nome;
	}

	public LinkedList<Ocorrencia> obterOcorrencias() {
		return listaOcorrencias;
	}

	public LinkedList<Projeto> obterProjetos() {
		return listaProjetos;
	}

	
}

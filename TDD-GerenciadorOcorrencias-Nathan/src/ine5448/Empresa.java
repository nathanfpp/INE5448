package ine5448;

import java.util.LinkedList;

import ine5448.Ocorrencia.Estados;
import ine5448.Ocorrencia.Prioridades;

public class Empresa {

	private LinkedList<Funcionario> listaFuncionarios;
	private LinkedList<Projeto> listaProjetos;

	public Empresa() {
		listaFuncionarios = new LinkedList<Funcionario>();
		listaProjetos = new LinkedList<Projeto>();
	}
	
	public void cadastrarFuncionario(Funcionario umFuncionario) throws Exception {
		
			listaFuncionarios.add(umFuncionario);
	}
	

	public void cadastrarProjeto(Projeto umProjeto) throws Exception {
		//Feio, utilizar colchetes!!!
		if(naoContemProjeto(umProjeto.obterNome()))
			listaProjetos.add(umProjeto);
	}
	
	public void cadastrarFuncionarioProjeto(Funcionario umFuncionario, String nomeProjeto) throws Exception {
		Projeto oProjeto = obterProjeto(nomeProjeto);
		oProjeto.adicionarFuncionario(umFuncionario);	
		umFuncionario.adicionarProjeto(oProjeto);
	}
	
	public void cadastrarOcorrenciaDeProjeto(String nomeProjeto, Ocorrencia umaOcorrencia, String nomeResponsavel)
			throws Exception {
		Projeto projetoCadastrado = obterProjeto(nomeProjeto);
		Funcionario responsavel = obterFuncionario(nomeResponsavel);
		projetoCadastrado.adicionarOcorrencia(umaOcorrencia, responsavel);
	}
	
	public void atulizarOcorrencia(String nomeProjeto, int codigo, Prioridades novaPrioridade, Estados novoEstado)
			throws Exception {
		Projeto projetoCadastrado = obterProjeto(nomeProjeto);
		Ocorrencia atualizacao = projetoCadastrado.obterOcorrencia(codigo);
		atualizacao.atualizar(novaPrioridade, novoEstado);
	}

	public void atulizarResponsavelOcorrencia(String nomeProjeto, int codigo, String nomeResponsavel) throws Exception {
		Projeto projetoCadastrado = obterProjeto(nomeProjeto);
		Ocorrencia atualizacao = projetoCadastrado.obterOcorrencia(codigo);
		Funcionario novoResponsavel = obterFuncionario(nomeResponsavel);
		atualizacao.atualizarResponsavel(novoResponsavel);
	}
	
	public LinkedList<Projeto> obterProjetos() {
		return listaProjetos;
	}

	public LinkedList<Funcionario> obterFuncionarios() {
		return listaFuncionarios;
	}

	public Projeto obterProjeto(String nomeProjeto) throws Exception {
		for (int i = 0; i < listaProjetos.size(); i++) {
			if (listaProjetos.get(i).obterNome() == nomeProjeto) {
				return listaProjetos.get(i);
			}
		}
		throw new Exception("Projeto nao existe");
	}

	public Funcionario obterFuncionario(String nome) throws Exception {
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			if (listaFuncionarios.get(i).obterNome() == nome) {
				return listaFuncionarios.get(i);
			}
		}
		throw new Exception("Funcionario: " + nome + " inexistente");
	}

	public Ocorrencia obterOcorrenciaDeProjeto(String nomeProjeto, int codigo) throws Exception {
		Projeto projetoCadastrado = obterProjeto(nomeProjeto);
		return projetoCadastrado.obterOcorrencia(codigo);
	}
	
	private boolean naoContemProjeto(String nomeProjeto) throws Exception {
		for (int i = 0; i < listaProjetos.size(); i++) {
			if(listaProjetos.get(i).equals(nomeProjeto)) {
				throw new Exception("Já existe projeto com esse nome");
			}
		}
		return true;
	}
	

}

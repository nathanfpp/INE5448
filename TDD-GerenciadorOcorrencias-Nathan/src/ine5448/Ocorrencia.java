package ine5448;

public class Ocorrencia {

	private int codigo;
	private Estados estado;
	private Prioridades prioridade;
	private Funcionario responsavel;
	private String resumo;

	public enum Tipos {
		TAREFA, BUG, MELHORIA;
	}

	public enum Prioridades {
		ALTA, MEDIA, BAIXA;
	}

	public enum Estados {
		ABERTA, COMPLETADA;
	}

	public Ocorrencia(int codigo, Tipos tipo, Prioridades prioridade, String resumo) {
		this.codigo = codigo;
		estado = Estados.ABERTA;
		this.prioridade = prioridade;
		this.resumo = resumo;
	}

	public void atualizar(Prioridades novaPrioridade, Estados novoEstado) {
		if (novaPrioridade != null)
			prioridade = novaPrioridade;

		if (novoEstado != null) {
			estado = novoEstado;
			if (estado == Ocorrencia.Estados.COMPLETADA)
				responsavel.removerOcorrencia(this);
		}
	}
	
	public void adicionarResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	
	public void atualizarResponsavel(Funcionario novoResponsavel) throws Exception {
		responsavel.removerOcorrencia(this);
		responsavel = novoResponsavel;
		responsavel.adicionarOcorrencia(this);
	}

	public Funcionario obterResponsavel() {
		return responsavel;
	}

	public String obterResumo() {
		return resumo;
	}

	public int obterCodigo() {
		return codigo;
	}

	public Estados obterEstado() {
		return estado;
	}

	public Prioridades obterPrioridade() {
		return prioridade;
	}

}
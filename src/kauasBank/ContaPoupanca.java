package kauasBank;

public class ContaPoupanca extends Conta {

	private int contadorMovimentacoes;

	public ContaPoupanca(String nome, String numero, double limite) {
		super(nome, numero, limite);
	}
	
	public int getContadorMovimentacoes() {
		return this.contadorMovimentacoes;
	}
	
	
	@Override
	public boolean sacar(double valor) throws ValorIndisponivelException, QuantidadeDeOperacoesException {
		if (valor > 0 && valor <= (this.getLimite() + this.getSaldo()) && this.contadorMovimentacoes <= 4) {
			super.sacar(valor);
			this.contadorMovimentacoes += 1;
			return true;
		}
		else if (this.getContadorMovimentacoes() == 5) {
			throw new QuantidadeDeOperacoesException("A quantidade de movimentacoes possiveis para saque ja foi utilizadas.");
		}
		else {
			throw new ValorIndisponivelException("O valor esta indisponivel. Valor disponivel: " + (this.getLimite() + this.getSaldo()));
		}
	}
	
	@Override
	public void transferirParaOutraConta(Conta conta, double valor) {
		if(this.sacar(valor) && this.getContadorMovimentacoes() <= 4) {
			conta.depositar(valor);
		}
		else if (this.getContadorMovimentacoes() == 5) {
			throw new QuantidadeDeOperacoesException("A quantidade de movimentacoes possiveis para transferencias ja foi utilizadas.");
		}
		else {
			throw new ValorIndisponivelException("O valor esta indisponivel. Valor disponivel: " + (this.getLimite() + this.getSaldo()));
	}
  }
}

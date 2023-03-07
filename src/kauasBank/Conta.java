package kauasBank;

public abstract class Conta {
	protected String nome;
	protected String numero;
	private double saldo;
	protected double limite;
	private int agencia = 20;
	private String moeda = "real";
	
	public Conta(String nome, String numero, double limite) {
		this.nome = nome;
		this.numero = numero;
		this.limite = limite;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getLimite() {
		return this.limite;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public boolean sacar(double valor) {
		if(valor > 0 && valor <= this.saldo + this.limite) {
			this.saldo -= valor;
			return true;
		}
		else {
			throw new ValorIndisponivelException("O valor esta indisponivel. Valor disponivel: " + (this.getLimite() + this.getSaldo()));
		}
	}
	
	public void transferirParaOutraConta(Conta conta, double valor) {
		if(this.sacar(valor)) {
			conta.depositar(valor);
		}
	 }
  }


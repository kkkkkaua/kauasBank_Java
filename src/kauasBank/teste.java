package kauasBank;

public class teste {
	public static void main(String[] args) {
		ContaPoupanca cc = new ContaPoupanca("kaua", "42", 500);
		ContaPoupanca cp = new ContaPoupanca("giovanna", "555", 500);
		cc.depositar(500);
		cc.transferirParaOutraConta(cp, 20);
		System.out.println(cc.getContadorMovimentacoes());
		cc.transferirParaOutraConta(cp, 20);
		System.out.println(cc.getContadorMovimentacoes());
		cc.transferirParaOutraConta(cp, 20);
		System.out.println(cc.getContadorMovimentacoes());
		cc.transferirParaOutraConta(cp, 20);
		System.out.println(cc.getContadorMovimentacoes());
	}
}

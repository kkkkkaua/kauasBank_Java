package kauasBank;

public class teste {
	public static void main(String[] args) {
		Conta cc = new ContaPoupanca("kaua", "42", 500);
		cc.depositar(500);
		System.out.println(cc.getSaldo());
//		cc.sacar(0);
		Conta cp =  new ContaPoupanca("leticia", "52", 500);
		cc.transferirParaOutraConta(cp, 1100);
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
	}
}

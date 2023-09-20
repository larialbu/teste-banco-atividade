package env;

import java.util.ArrayList;
import user.*;

public class Banco {
  private ArrayList<Conta> accounts;

  public Banco() {
    this.accounts = new ArrayList<Conta>();
  }

  private boolean contaExistente(String accountNumber){
    if(getConta(accountNumber) == null){
      return false;
    }
    return true;
  }

  public void realizarDepositoEmConta(double valor, String nConta){
    Conta conta = getConta(nConta);
    if (conta != null){
      conta.deposit(valor);
    }
  }

  Conta getConta(String nConta) {
    for(Conta conta: accounts){
      if(conta.getAccountNumber() == nConta){
        return conta;
      }
    }
    return null;
  }

  public void realizarSaqueEmConta (double valor, String nConta){
    Conta conta = getConta(nConta);
    if (conta != null){
      conta.withdraw(valor);
    }
  }

  public void criarConta(String accountNumber, String userName){
    if (!contaExistente(accountNumber)){
      Conta conta = new Conta(accountNumber, userName);
      accounts.add(conta);
    }
  }

  public int getNumeroContas(){
    return accounts.size();
  }

  public double getTotalDeSaldoBanco(){
    double saldo = 0;
    for(Conta conta: accounts){
      saldo += conta.getBalance();
    }
    return saldo;
  }

  public boolean removerConta(String numeroConta){
    Conta conta = getConta(numeroConta);
    if (conta != null){
      accounts.remove(conta);
      return true;
    }
    return false;
  }
}

package env;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BancoTest {
  // CRIAR AS SEGUINTES CLASSES:
  // contasEmBancoTest() - Verifica se a criação de novas contas está correta
  // contasEmBancoAposRemocaoTest() - Verifica se a remoção de contas está correta
  // totalEmContasTest() - Verifica se o balanço de todas as contas juntas está igual ao balanço total do banco
  // transferenciaEmContasTest() - Verifica se a retirada do dinheiro de uma conta para inserir em outra modifica os valores de ambas as contas
  @Test
  public void contasEmBancoTest() {
      Banco banco = new Banco();
      banco.criarConta("123", "Alice");
      banco.criarConta("456", "Bob");

      Assertions.assertEquals(2, banco.getNumeroContas());
  }

  @Test
  public void contasEmBancoAposRemocaoTest() {
      Banco banco = new Banco();
      banco.criarConta("123", "Alice");
      banco.criarConta("456", "Bob");
      banco.removerConta("123");

      Assertions.assertEquals(1, banco.getNumeroContas());
  }

  @Test
  public void totalEmContasTest() {
      Banco banco = new Banco();
      banco.criarConta("123", "Alice");
      banco.criarConta("456", "Bob");
      
      banco.realizarDepositoEmConta(1000, "123");
      banco.realizarDepositoEmConta(500, "456");

      double saldoTotal = banco.getTotalDeSaldoBanco();

      Assertions.assertEquals(1500.0, saldoTotal, 0.001);
  }

  @Test
  public void transferenciaEmContasTest() {
      Banco banco = new Banco();
      banco.criarConta("123", "Alice");
      banco.criarConta("456", "Bob");

      banco.realizarDepositoEmConta(1000, "123");
      
      banco.realizarSaqueEmConta(500, "123");
      banco.realizarDepositoEmConta(500, "456");

      double saldoConta123 = banco.getConta("123").getBalance();
      double saldoConta456 = banco.getConta("456").getBalance();

      Assertions.assertEquals(500.0, saldoConta123, 0.001);
      Assertions.assertEquals(500.0, saldoConta456, 0.001);
  }

}

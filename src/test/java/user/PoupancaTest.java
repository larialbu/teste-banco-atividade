package user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PoupancaTest {
  // CRIAR AS SEGUINTES CLASSES:
  // depositoContaTest() - Verificar se o deposito em uma poupança retorna o valor com juros corretamente
  @Test
  public void depositoContaTest() {
      Poupanca poupanca = new Poupanca("123", "Alice");
      poupanca.deposit(1000);
      poupanca.renderJuros(); // Aplica juros de 1% ao saldo

      Assertions.assertEquals(1010.0, poupanca.getBalance(), 0.001);
  }

}

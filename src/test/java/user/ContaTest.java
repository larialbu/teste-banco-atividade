package user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Conta;

public class ContaTest {
  // CRIAR AS SEGUINTES CLASSES:
  // setUp() - Método usado para setar o @BeforeEach 
  // sysoutInfo() - Método usado para setar o @After para imprimir na tela o balanço da conta
  // depositoEmContaTest() - Verifica se o deposito em uma determinada conta funciona
  // saqueEmContaTeste() - Verifica se o saque em uma determinada conta funciona
  // falhaSaqueEmContaTeste() - Falha em verificar se o saque em uma determinada conta funciona. Pula o teste se o balanço for menor que o valor solicitado de saque
      private Conta conta;

    @BeforeEach
    public void setUp() {
        conta = new Conta("123", "Alice");
    }

    @AfterEach
    public void sysoutInfo() {
        System.out.println("Balanço da Conta: " + conta.getBalance());
    }

    @Test
    public void depositoEmContaTest() {
        conta.deposit(500);
        Assertions.assertEquals(500.0, conta.getBalance(), 0.001);
    }

    @Test
    public void saqueEmContaTeste() {
        conta.deposit(1000);
        conta.withdraw(500);
        Assertions.assertEquals(500.0, conta.getBalance(), 0.001);
    }

    @Test
    public void falhaSaqueEmContaTeste() {
        conta.deposit(500);
        // Tente sacar um valor maior do que o saldo atual (deve falhar)
        boolean saqueBemSucedido = conta.withdraw(1000);
        Assertions.assertFalse(saqueBemSucedido);
    }

}

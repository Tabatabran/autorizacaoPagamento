/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ufes.autorizacaopagamento.business.GerenteGeral;
import com.ufes.autorizacaopagamento.business.GerenteImediato;
import com.ufes.autorizacaopagamento.business.ProcessaPagamentoService;
import com.ufes.autorizacaopagamento.business.SuperiorHierarquico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Aluno
 */
public class PagamentoJUnitTest {
    
    public PagamentoJUnitTest() {
    }
    
    @Test
    @DisplayName("Um valor inferior a 500 e maior que zero")
    public void C1(){
        SuperiorHierarquico superior = new GerenteImediato(true);
        double valor = 300;
        String tratador = superior.toString();
        String frase = tratador + " autorizando pagamento no valor de R$ " + valor;
        
        ProcessaPagamentoService processa = new ProcessaPagamentoService();
        processa.addTratador(superior);
        
        assertEquals(processa.processaAprovacao(valor), frase);
        
    }
    
    @Test
    @DisplayName("Um valor inferior a 1500 e maior que 500")
    public void C2(){
        SuperiorHierarquico superior = new GerenteGeral(true);
        double valor = 1000;
        String tratador = superior.toString();
        String frase = tratador + " autorizando pagamento no valor de R$ " + valor;
        
        ProcessaPagamentoService processa = new ProcessaPagamentoService();
        processa.addTratador(superior);
        
        assertEquals(processa.processaAprovacao(valor), frase);
        
    }
}

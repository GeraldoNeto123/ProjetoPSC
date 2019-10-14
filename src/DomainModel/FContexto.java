/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;
import Apresentacao.JFCaixa;
import Apresentacao.JFHome;
import Apresentacao.JFListarMercadorias;
import Apresentacao.JFLogin;
import Apresentacao.JFNovoUsuario;
import Apresentacao.JFMercadoria;
import Apresentacao.JFNovaVenda;
import Apresentacao.JFRelatorioCaixa;
import Apresentacao.JFRelatorioEstoque;
import Apresentacao.JFRelatorioVendas;
import Apresentacao.JFRelatorios;
import Apresentacao.JFTroco;

public class FContexto {
    public static void main(String[] args) {
        FContexto.getLogin().setVisible(true);
   }

    
private static JFLogin jfLogin;
private static JFNovoUsuario jfNovoUsuario;
private static JFHome jfHome;
private static JFMercadoria jfMercadoria;
private static JFNovaVenda jfNovaVenda;
private static JFListarMercadorias jfListarMercadorias;
private static JFCaixa jfCaixa;
private static JFRelatorios jfRelatorios;
private static JFRelatorioCaixa jfRelatorioCaixa;
private static JFRelatorioEstoque jfRelatorioEstoque;
private static JFRelatorioVendas jfRelatorioVendas;
private static JFTroco jfTroco;

public static JFLogin getLogin(){
        if(jfLogin==null){
            jfLogin = new JFLogin();
        }
        return jfLogin;
    }

public static JFNovoUsuario getNovoUsuario(){
        if(jfNovoUsuario==null){
            jfNovoUsuario = new JFNovoUsuario();
        }
        return jfNovoUsuario;
    }

public static JFHome getHome(){
        if(jfHome==null){
            jfHome = new JFHome();
        }
        return jfHome;
    }

public static JFMercadoria getMercadoria(){
        if(jfMercadoria==null){
            jfMercadoria = new JFMercadoria();
        }
        return jfMercadoria;
    }
public static JFNovaVenda getNovaVenda(){
        if(jfNovaVenda==null){
            jfNovaVenda = new JFNovaVenda();
        }
        return jfNovaVenda;
    }
public static JFListarMercadorias getListarMercadorias(){
        if(jfListarMercadorias==null){
            jfListarMercadorias = new JFListarMercadorias();
        }
        return jfListarMercadorias;
    }    
public static JFCaixa getCaixa(){
        if(jfCaixa==null){
            jfCaixa = new JFCaixa();
        }
        return jfCaixa;
    } 
public static JFRelatorios getRelatorio(){
        if(jfRelatorios==null){
            jfRelatorios = new JFRelatorios();
        }
        return jfRelatorios;
    }
public static JFRelatorioCaixa getRelatorioCaixa(){
        if(jfRelatorioCaixa==null){
            jfRelatorioCaixa = new JFRelatorioCaixa();
        }
        return jfRelatorioCaixa;
    }
public static JFRelatorioEstoque getRelatorioEstoque(){
        if(jfRelatorioEstoque==null){
            jfRelatorioEstoque = new JFRelatorioEstoque();
        }
        return jfRelatorioEstoque;
    }
public static JFTroco getTroco(){
        if(jfTroco==null){
            jfTroco = new JFTroco();
        }
        return jfTroco;
    }
public static JFRelatorioVendas getRelatorioVendas(){
        if(jfRelatorioVendas==null){
            jfRelatorioVendas = new JFRelatorioVendas();
        }
        return jfRelatorioVendas;
    }
}
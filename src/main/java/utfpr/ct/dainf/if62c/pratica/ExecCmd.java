/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.IOException;

/**
 *
 * @author askoda
 */
public class ExecCmd extends Thread {
    
    private String comando;
    private Process processo;
    
    public ExecCmd(String comando) {
        this.comando = comando;
        this.run();
    }
    
    @Override
    public void run() {
        try {
            processo =  Runtime.getRuntime().exec(comando);
        } catch (IOException ex ) {
            System.out.println("Não foi possivel iniciar o processo: " + ex.getLocalizedMessage());
        }

    }
    
    public void cancela() {
        if(processo != null)
            processo.destroy();
    }
    
    public boolean terminado() {
        if(processo.isAlive())
            return false;
        return true;
    }
    
}

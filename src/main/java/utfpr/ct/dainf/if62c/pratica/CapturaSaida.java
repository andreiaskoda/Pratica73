/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author askoda
 */
public class CapturaSaida extends Thread {

    private final InputStream is;

    public CapturaSaida(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linha;
            
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}

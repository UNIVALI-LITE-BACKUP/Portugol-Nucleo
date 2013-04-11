package br.univali.portugol.nucleo.execucao.calc;

import java.lang.reflect.Method;

public abstract class Operacao
{
    public Object executar(Object a, Object b){
        try {            
            Class ca = a.getClass();
            Class cb = b.getClass();
            
            Method metodo = this.getClass().getDeclaredMethod("executar", ca, cb);
            return metodo.invoke(this, a, b);            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
    
}

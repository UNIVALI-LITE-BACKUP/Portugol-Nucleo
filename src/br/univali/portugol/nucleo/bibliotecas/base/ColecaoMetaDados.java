package br.univali.portugol.nucleo.bibliotecas.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Luiz Fernando Noschang
 */
abstract class ColecaoMetaDados<Y extends MetaDados> implements Iterable<Y>
{
    private Map<String, Y> mapa;
    private List<Y> lista;
    private String mensagemErroRemocao;

    public ColecaoMetaDados(String mensagemErroRemocao)
    {
        this.mapa = new TreeMap<String, Y>();
        this.lista = new ArrayList<Y>();
    }

    public final int quantidade()
    {
        return lista.size();
    }
    
    public final boolean vazio()
    {
        return lista.isEmpty();
    }

    final boolean contem(String nome)
    {
        return mapa.containsKey(nome);
    }
    
    final void incluir(Y metaDado)
    {
        mapa.put(metaDado.getNome(), metaDado);
        lista.add(metaDado);
    }

    public final Y obter(String nome)
    {
        return mapa.get(nome);
    }

    public final Y obter(int indice)
    {
        return lista.get(indice);
    }

    @Override
    public final Iterator<Y> iterator()
    {
        return new IteradorImutavel<Y>(lista.iterator(), mensagemErroRemocao);
    }

    private class IteradorImutavel<T> implements Iterator<T>
    {
        private Iterator<T> iteradorOriginal;
        private String mensagemErroRemocao;

        public IteradorImutavel(Iterator<T> iteradorOriginal, String mensagemErroRemocao)
        {
            this.iteradorOriginal = iteradorOriginal;
            this.mensagemErroRemocao = mensagemErroRemocao;
        }

        @Override
        public boolean hasNext()
        {
            return this.iteradorOriginal.hasNext();
        }

        @Override
        public T next()
        {
            return this.iteradorOriginal.next();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException(this.mensagemErroRemocao);
        }
    }
}

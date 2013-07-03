package br.univali.portugol.nucleo.bibliotecas.base.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Luiz Fernando Noschang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExportarVariavel
{
    public String descricao();
    public String referencia() default "";
}

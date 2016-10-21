programa                                             
{                                                            
    inclua biblioteca Util --> u

    funcao inicio()                                         
    {                                                       
        inteiro a = 2
        inteiro b = 4
        inteiro m[2][2]
        inteiro v[3] 
        inteiro c = teste(a, m, v) + teste(b, m, v) * a * b
        c = u.numero_linhas(m)
        c = u.numero_elementos(v)
    }                                                       
    
    funcao inteiro teste(inteiro & x, inteiro matriz[][], inteiro vetor[])                               
    {                                                      
        x = x * 2
        matriz[0][0] = matriz[0][0]
        vetor[0] = vetor[0]
        retorne 1
    }                                                       
}

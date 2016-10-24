programa                                             
{                                                            
    inteiro i = -1

    funcao inicio()                                         
    {                                                       
        inteiro m = 0
        teste(i)
        teste(m)
    }                                                       
    
    funcao teste(inteiro &a)                               
    {                                                      
        inteiro m = 1
        teste_escopo(m)
    }

    funcao teste_escopo(inteiro &a)
    {
        teste(a)
    }
}

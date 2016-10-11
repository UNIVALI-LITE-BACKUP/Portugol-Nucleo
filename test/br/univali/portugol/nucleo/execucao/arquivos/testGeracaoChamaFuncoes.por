programa 
{                                     
    funcao inicio() {                                       
        inteiro x = 1                                       
        faca{                                               
            teste(x)                                        
        }                                                   
        enquanto(x < 10)                                    
    }                                                       
    
    funcao teste(inteiro a) {                               
        escreva(testeRetorno(a))                          
    }                                                       
    
    funcao logico testeRetorno(inteiro a) {                 
        retorne a % 2 == 0                                 
    }                                                       
}
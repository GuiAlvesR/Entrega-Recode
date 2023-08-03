Algoritmo "Entrega"

Var
   clientes: vetor[1..5] de caracter
   destinos: vetor[1..5] de caracter
   email: vetor[1..5] de caracter
   preco: vetor[1..5] de real
   opcao:inteiro
   x:inteiro
   z:inteiro
   y:inteiro
   i:inteiro


Inicio
   escreval("  - ========----------------------------------------===========")
   escreval("  - ======== Bem Vindos a Agência Turistica Noturna ===========")
   escreval("  - ========----------------------------------------===========")
   escreval("")
   repita

      escreval("1 - ================== Cadastrar Cliente: ====================")
      escreval("2 - ================== Consultar Clientes: ===================")
      escreval("3 - ================== Cadastrar Destinos: ===================")
      escreval("4 - ================== Consultar Destinos: ===================")
      escreval("5 - ========================= Sair ========================== ")
      escreval("")
      leia(opcao)

      escolha(opcao)

      caso 1
         limpatela
         escreval("====================== Cadastro de Clientes: =====================")
         escreval("")
         para x de 1 ate 5 faca
            escreval("Digete o nome do",x,"° cliente: ")
            leia(clientes[x])
         fimpara
         para y de 1 ate 5 faca
            escreval("Digite o email",y,"° do cliente : ")
            leia(email[y])
         fimpara
      caso 2
         limpatela
         escreval("====================== Consulta de Clientes: ===================")
         escreval("")
         para x de 1 ate 5 faca
            escreval(x,"° Cliente Consultado : ",clientes[x])
         fimpara
         para y de 1 ate 5 faca
            escreval("Email do",y,"° Cliente Consultado :",email[y])
         fimpara
         escreval("")
      caso 3
         limpatela
         escreval("====================== Cadastra de Destinos: =====================")
         escreval("")
         para z de 1 ate 5 faca
            escreval("Digete o",z," ° Destino : ")
            leia(destinos[z])
         fimpara
         para i de 1 ate 5 faca
            escreval("Digete o Valor a pagar para esse",i,"° Destino : ")
            leia(preco[i])
         fimpara
      caso 4
         limpatela
         escreval("===================== Consulta de Destinos: ====================")
         escreval("")
         para z de 1 ate 5 faca
            escreval(z,"° Destino Consultado : ",destinos[z])
         fimpara
         para i de 1 ate 5 faca
            escreval("Preço do ",i," ° Destino Consultado :",preco[i])
         fimpara
         escreval("")
      caso 5
         limpatela
         escreval("-----------Programa Finalizado!!!--------")
         escreval("----------------Obrigado!----------------")
         escreval("---------O Menu foi Concluido!!!---------")

      outrocaso
         limpatela
         escreval("Opcao Invalida!")
         escreval("Tente Novamente!")
      fimescolha

   ate opcao = 5

Fimalgoritmo


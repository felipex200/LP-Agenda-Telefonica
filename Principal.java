package agendatelefonica;

import java.util.Scanner;

/**
 * @author Orlando Nascimento
 * @author Felipe Viana
 */
public class Principal {

    
    public static void main(String[] args) {
    AgendaTel Lista = new AgendaTel();
    
    Contato ct1 = new Contato ("Fulano",99999999,"Rua A", "UFF");
    Lista.inserir(ct1);
    Contato ct2 = new Contato ("Ciclano",88888888,"Rua B", "Cederj");
    Lista.inserir(ct2);
    Contato ct3 = new Contato ("Beltrano",88889999,"Rua C", "Infância");
    Lista.inserir(ct3);
   System.out.println(Lista);
        System.out.println(" ");
    Contato alt = new Contato ("Fulano",77777777,"Rua D","n");
    Lista.alterar(alt);
    System.out.println(Lista);
        System.out.println(" ");
    Lista.remover("Ciclano");
    System.out.println(Lista);
    //*Métodos para Salvar/Recuperar agenda
    
    
    Scanner op = new Scanner(System.in);	
    Scanner Palavras = new Scanner(System.in);
    int option;
    
      do{
        System.out.println("\n-----------------MENU--------------");
        System.out.println("|1 - Adicionar um Contato         |");
        System.out.println("|2 - Alterar um Contato           |");
        System.out.println("|3 - Remover um Contato           |");
        System.out.println("|4 - Buscar um Contato por nome   |");
        System.out.println("|5 - Imprimir toda a Agenda       | ");
        System.out.println("|6 - Salvar Agenda                |");
        System.out.println("|7 - Recuperar Agenda             |");
        System.out.println("|8 - Sair                         |");
        System.out.println("-----------------------------------");
        System.out.print("Digite a opção: ");
        option = op.nextInt();
       
        switch(option){
          case 1:
            Contato ct_aux = new Contato(null,0,null,null);
            System.out.print("\nNome: ");
            ct_aux.setNome(Palavras.nextLine());
            System.out.print("\nNúmero: ");
            ct_aux.setTelefone(op.nextInt());
            System.out.print("\nEndereço: ");
            ct_aux.setEnd(Palavras.nextLine());
            System.out.print("\nRelação: ");
            ct_aux.setRelation(Palavras.nextLine());
            Lista.inserir(ct_aux);
          break;
          case 2:
            Contato ct_aux2 = new Contato(null,0,null,null);
            System.out.print("\nNome: ");
            ct_aux2.setNome(Palavras.nextLine());
            System.out.print("\nNúmero [Digite 0 para não alterar este campo]: ");
            ct_aux2.setTelefone(op.nextInt());
            System.out.print("\nEndereço [Digite n para não alterar este campo]: ");
            ct_aux2.setEnd(Palavras.nextLine());
            System.out.print("\nRelação [Digite n para não alterar este campo]: ");
            ct_aux2.setRelation(Palavras.nextLine());
            if(Lista.alterar(ct_aux2))
                System.out.println("Contato alterado!");
            else
                  System.out.println("Contato não encontrado!");
          break;
          case 3:
            System.out.print("Nome do contato a ser removido: ");
            if(Lista.remover(Palavras.nextLine()))
                  System.out.println("Contato Removido!");
            else
                  System.out.println("Impossivel remover contato inexistente!");
          break;
          case 4:
            System.out.println("Nome do contato: ");
            String ajuda = Palavras.nextLine();
            Contato ct_aux3 = Lista.buscar(ajuda);
            if(ct_aux3 != null)
                System.out.format("Nome:%s  Numero: %d Endereço: %s Relação: %s \n", ct_aux3.getNome(), ct_aux3.getTelefone(),ct_aux3.getEnd(),ct_aux3.getRelation());
            else
                  System.out.println("Contato não existe!");
            break;
          case 5:
            System.out.println(Lista);
          break;
          case 6:
            System.out.print("Nome do .txt a ser criado: ");
            String NomeSalvar = Palavras.nextLine();
            Lista.salvar(NomeSalvar);
          break;
          case 7:
            System.out.print("Nome do .txt a ser recuperado: ");
            String NomeLer = Palavras.nextLine();
            Lista.recuperar(NomeLer);
          break;
          case 8:
            System.out.println("Bye Bye");
          break;
          default:
            System.out.println("Opção Inválida");
        }
      }while(option !=8);
      op.close();
      Palavras.close();
    }
    
}

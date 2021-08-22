package agendatelefonica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class AgendaTel{

  public List <Contato> contatos;

  public AgendaTel(){
        contatos = new ArrayList<>();
    }

  public AgendaTel(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
  public List<Contato> getContatos(){
      return contatos;
  }

  public void inserir(Contato contato){
      boolean a = false;
      for (int i =0;i < contatos.size();i++){
          if (contatos.get(i).getNome().equals(contato.getNome())){
              a = alterar(contato);
          }
      }
      if(a== false){
          contatos.add(contato); 
      }
  }
  
  public boolean alterar(Contato contato)
  {
      for (int i =0; i < contatos.size();i++)
      {
          if (contatos.get(i).getNome().equals(contato.getNome())){
              Contato auxiliar = new Contato(contato.getNome(),0,null,null);
              if(contato.getTelefone()!=0 )
                  auxiliar.setTelefone(contato.getTelefone());
              else
                  auxiliar.setTelefone(contatos.get(i).getTelefone());
                  
              if(!contato.getEnd().equals("n"))
                  auxiliar.setEnd(contato.getEnd());
              else
                  auxiliar.setEnd(contatos.get(i).getEnd());
              
              if(!contato.getRelation().equals("n"))
                  auxiliar.setRelation(contato.getRelation());
              else
                  auxiliar.setRelation(contatos.get(i).getRelation());
              contatos.set(i,auxiliar);
              return true;
          }
      }
      return false;
  }
  
      
  public Contato buscar(String nome){
      Contato result = null;
      for(int i=0; i < contatos.size(); i++){
          if (contatos.get(i).getNome().contains(nome)){
              return contatos.get(i);
          }
      }
      return result;
  }

  public boolean remover(String nome){
    for(int i=0; i < contatos.size(); i++){
      if (contatos.get(i).getNome().equals(nome)){
        contatos.remove(i);
        return true;
      }
    }
    return false;
  }

public boolean salvar(String nomeArquivo){
      try{
        FileWriter arquivoAgenda = new FileWriter(nomeArquivo+".txt");
        PrintWriter gravarAgenda = new PrintWriter(arquivoAgenda);
        for(Contato contato : this.contatos){
            gravarAgenda.write(contato.getNome()+"\n");
            gravarAgenda.write(Integer.toString(contato.getTelefone())+"\n");
            gravarAgenda.write(contato.getEnd()+"\n");
            gravarAgenda.write(contato.getRelation()+"\n");
        };
        gravarAgenda.close();
        return true;
      }catch(IOException e){
            System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
            return false;
      }
  }
    
    public boolean recuperar(String nomeArquivo){
        try{
            FileReader arquivoContatos = new FileReader(nomeArquivo+".txt");
            BufferedReader lerArq = new BufferedReader(arquivoContatos);
            String linha=lerArq.readLine(); 
            while(linha!=null){
                Contato Rec = new Contato(linha,0,null,null);
                Rec.setTelefone(Integer.parseInt(lerArq.readLine()));
                Rec.setEnd(lerArq.readLine());
                Rec.setRelation(lerArq.readLine());
                linha = lerArq.readLine();
                contatos.add(Rec);
            }
            arquivoContatos.close();
            return true;
        }catch(IOException e){
            System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
            return false;
        }
    }


  public void imprimirAgenda(){
    for (int i =0; i < contatos.size(); i++){
        System.out.format("\nNome:%s  Telefone: %d Endereço: %s Relação: %s", contatos.get(i).getNome(), contatos.get(i).getTelefone(),contatos.get(i).getEnd(),contatos.get(i).getRelation());
    }
  } 

}
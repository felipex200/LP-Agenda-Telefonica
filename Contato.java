package agendatelefonica;

public class Contato
{
  private String nome;
  private int telefone;
  private String end;
  private String relation;


  public Contato(String nome, int telefone, String endereco, String relation) {
    this.nome = nome;
    this.telefone = telefone;
    this.end = endereco;
    this.relation = relation;
        
    }
  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public int getTelefone() {
        return telefone;
    }

  public void setTelefone(int telefone) {
      this.telefone = telefone;
  }

  public String getEnd(){
    return end;
  }

  public void setEnd(String end){
    this.end = end;
  }

  public String getRelation(){
    return relation;
  }

  public void setRelation(String relation){
    this.relation = relation;
  }
  
}
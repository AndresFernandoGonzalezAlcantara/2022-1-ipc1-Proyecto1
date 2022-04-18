package recursos;


public class comida {
    int  codigo,tipo;
    String  nombre;

    public comida(int codigo,String nombre, int tipo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre(){ 
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }  
    public int getTipo(){
        return tipo;
    }
}

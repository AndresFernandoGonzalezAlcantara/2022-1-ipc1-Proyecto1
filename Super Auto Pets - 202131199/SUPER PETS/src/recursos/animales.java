package recursos;

public class animales {
        public int ataque, defensa, vida, codigo;
        public String  tipo1,tipo2, tipo3, nombre;
        
        public animales(int ataque, int defensa, int vida, int codigo,String tipo1,String tipo2, String tipo3, String name){
            this.codigo = codigo;
            this.ataque = ataque;
            this.defensa = defensa;
            this.vida = vida;
            this.tipo1 = tipo1;
            this.tipo2 = tipo2;
            this.tipo3 = tipo3;
            this.nombre = name;
        }
        public int getVida() {
            return vida;
        }
        public int getAtaque() {
            return ataque;
        }
        public int getDefensa(){
            return defensa;
        }
        public String getTipo1(){
            return tipo1;
        }
        public String getTipo2(){
            return tipo2;
        }
        public String getTipo3(){
            return tipo3;
        }
        public String getNombre()
        {
            return nombre;
        }
        public void setAtaque(int ataque){
            this.ataque = ataque;
        }
        public void setVida(int vida){
            this.vida = vida;
        }        
        public void setTipo1(String tipo1){
            this.tipo1 = tipo1;
        }  
        public void setTipo2(String tipo2){
            this.tipo2 = tipo2;
        }        
        public void setTipo3(String tipo3){
            this.tipo3 = tipo3;
        }
        public void setDefensa(int defensa){
            this.defensa = defensa;
        }
        
        public int [] getNdates()
        {
            int Ndates [] = {getDefensa(), getAtaque(), getVida()};
            return Ndates;
        }
        public String [] getSdates()
        {
            return new String[] {getNombre(),getTipo1(),getTipo2(),getTipo3()};
        }
}

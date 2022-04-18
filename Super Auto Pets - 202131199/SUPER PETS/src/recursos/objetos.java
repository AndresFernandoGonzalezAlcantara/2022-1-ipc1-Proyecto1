package recursos;
public class objetos{
    public int [] getNdatosA(int codigo)
    {
        int dates []={0,0,0};
        switch(codigo)
        {
            case 1:  dates = Hormiga.getNdatos(); break;
            case 2:  dates = Pescado.getNdatos(); break;
            case 3:  dates = Mosquito.getNdatos(); break;
            case 4:  dates = Grillo.getNdatos(); break;
            case 5:  dates = Castor.getNdatos(); break;
            case 6:  dates = Caballo.getNdatos(); break;
            case 7:  dates = Nutria.getNdatos(); break;
            case 8:  dates = Escarabajo.getNdatos(); break;
            case 9:  dates = Sapo.getNdatos(); break;
            case 10:  dates = Dodo.getNdatos(); break;
            case 11:  dates = Elefante.getNdatos(); break;
            case 12:  dates = Puercoespin.getNdatos(); break;
            case 13:  dates = Pavoreal.getNdatos(); break;
            case 14:  dates = Rata.getNdatos(); break;
            case 15:  dates = Zorro.getNdatos(); break;
            case 16:  dates = Arania.getNdatos(); break;
            case 17:  dates = Camello.getNdatos(); break;
            case 18:  dates = Mapache.getNdatos(); break;
            case 19:  dates = Jirafa.getNdatos(); break;
            case 20:  dates = Tortuga.getNdatos(); break;
            case 21:  dates = Caracol.getNdatos(); break;
            case 22:  dates = Oveja.getNdatos(); break;
            case 23:  dates = Conejo.getNdatos(); break;
            case 24:  dates = Lobo.getNdatos(); break;
            case 25:  dates = Buey.getNdatos(); break;
            case 26:  dates = Canguro.getNdatos(); break;
            case 27:  dates = Buho.getNdatos(); break;
            case 28:  dates = Venado.getNdatos(); break;
            case 29:  dates = Loro.getNdatos(); break;
            case 30:  dates = Hipopotamo.getNdatos(); break;
            case 31:  dates = Delfin.getNdatos(); break;
            case 32:  dates = Puma.getNdatos(); break;
            case 33:  dates = Ballena.getNdatos(); break;
            case 34:  dates = Ardilla.getNdatos(); break;
            case 35:  dates = LLama.getNdatos(); break;
            case 36:  dates = Foca.getNdatos(); break;
            case 37:  dates = Jaguar.getNdatos(); break;
            case 38:  dates = Escorpion.getNdatos(); break;
            case 39:  dates = Rinoceronte.getNdatos(); break;
            case 40:  dates = Mono.getNdatos(); break;
            case 41:  dates = Cocodrilo.getNdatos(); break;
            case 42:  dates = Vaca.getNdatos(); break;
            case 43:  dates = Chompipe.getNdatos(); break;
            case 44:  dates = Panda.getNdatos(); break;
            case 45:  dates = Gato.getNdatos(); break;
            case 46:  dates = Tigre.getNdatos(); break;
            case 47:  dates = Serpiente.getNdatos(); break;
            case 48:  dates = Mamut.getNdatos(); break;
            case 49:  dates = Leopardo.getNdatos(); break;
            case 50:  dates = Gorila.getNdatos(); break;
            case 51:  dates = Pulpo.getNdatos(); break;
            case 52:  dates = Mosca.getNdatos(); break;
            case 53:  dates = Quetzal.getNdatos(); break;
            case 54:  dates = Camaleon.getNdatos(); break;
            case 55:  dates = Grillo_Zombie.getNdatos(); break;
            case 56:  dates = Dirty_Rat.getNdatos(); break;
            case 57:  dates = Carnero.getNdatos(); break;
            case 58:  dates = Autobus.getNdatos(); break;
            case 59:  dates = Zombie_Fly.getNdatos(); break;
        }
    
      return dates;
    }
    public String [] getSdatos(int codigo)
    {
        String dates [] = {"","","",""};
        switch(codigo){
            case 1:  dates = Hormiga.getSdatos(); break;
            case 2:  dates = Pescado.getSdatos(); break;
            case 3:  dates = Mosquito.getSdatos(); break;
            case 4:  dates = Grillo.getSdatos(); break;
            case 5:  dates = Castor.getSdatos(); break;
            case 6:  dates = Caballo.getSdatos(); break;
            case 7:  dates = Nutria.getSdatos(); break;
            case 8:  dates = Escarabajo.getSdatos(); break;
            case 9:  dates = Sapo.getSdatos(); break;
            case 10:  dates = Dodo.getSdatos(); break;
            case 11:  dates = Elefante.getSdatos(); break;
            case 12:  dates = Puercoespin.getSdatos(); break;
            case 13:  dates = Pavoreal.getSdatos(); break;
            case 14:  dates = Rata.getSdatos(); break;
            case 15:  dates = Zorro.getSdatos(); break;
            case 16:  dates = Arania.getSdatos(); break;
            case 17:  dates = Camello.getSdatos(); break;
            case 18:  dates = Mapache.getSdatos(); break;
            case 19:  dates = Jirafa.getSdatos(); break;
            case 20:  dates = Tortuga.getSdatos(); break;
            case 21:  dates = Caracol.getSdatos(); break;
            case 22:  dates = Oveja.getSdatos(); break;
            case 23:  dates = Conejo.getSdatos(); break;
            case 24:  dates = Lobo.getSdatos(); break;
            case 25:  dates = Buey.getSdatos(); break;
            case 26:  dates = Canguro.getSdatos(); break;
            case 27:  dates = Buho.getSdatos(); break;
            case 28:  dates = Venado.getSdatos(); break;
            case 29:  dates = Loro.getSdatos(); break;
            case 30:  dates = Hipopotamo.getSdatos(); break;
            case 31:  dates = Delfin.getSdatos(); break;
            case 32:  dates = Puma.getSdatos(); break;
            case 33:  dates = Ballena.getSdatos(); break;
            case 34:  dates = Ardilla.getSdatos(); break;
            case 35:  dates = LLama.getSdatos(); break;
            case 36:  dates = Foca.getSdatos(); break;
            case 37:  dates = Jaguar.getSdatos(); break;
            case 38:  dates = Escorpion.getSdatos(); break;
            case 39:  dates = Rinoceronte.getSdatos(); break;
            case 40:  dates = Mono.getSdatos(); break;
            case 41:  dates = Cocodrilo.getSdatos(); break;
            case 42:  dates = Vaca.getSdatos(); break;
            case 43:  dates = Chompipe.getSdatos(); break;
            case 44:  dates = Panda.getSdatos(); break;
            case 45:  dates = Gato.getSdatos(); break;
            case 46:  dates = Tigre.getSdatos(); break;
            case 47:  dates = Serpiente.getSdatos(); break;
            case 48:  dates = Mamut.getSdatos(); break;
            case 49:  dates = Leopardo.getSdatos(); break;
            case 50:  dates = Gorila.getSdatos(); break;
            case 51:  dates = Pulpo.getSdatos(); break;
            case 52:  dates = Mosca.getSdatos(); break;
            case 53:  dates = Quetzal.getSdatos(); break;
            case 54:  dates = Camaleon.getSdatos(); break;
            case 55:  dates = Grillo_Zombie.getSdatos(); break;
            case 56:  dates = Dirty_Rat.getSdatos(); break;
            case 57:  dates = Carnero.getSdatos(); break;
            case 58:  dates = Autobus.getSdatos(); break;
            case 59:  dates = Zombie_Fly.getSdatos(); break;
        }    
        return dates;
    }
    public String getNombre(int codigo)
    {
        String dates="";
        switch(codigo){
            case 1:  dates = Hormiga.getNombre(); break;
            case 2:  dates = Pescado.getNombre(); break;
            case 3:  dates = Mosquito.getNombre(); break;
            case 4:  dates = Grillo.getNombre(); break;
            case 5:  dates = Castor.getNombre(); break;
            case 6:  dates = Caballo.getNombre(); break;
            case 7:  dates = Nutria.getNombre(); break;
            case 8:  dates = Escarabajo.getNombre(); break;
            case 9:  dates = Sapo.getNombre(); break;
            case 10:  dates = Dodo.getNombre(); break;
            case 11:  dates = Elefante.getNombre(); break;
            case 12:  dates = Puercoespin.getNombre(); break;
            case 13:  dates = Pavoreal.getNombre(); break;
            case 14:  dates = Rata.getNombre(); break;
            case 15:  dates = Zorro.getNombre(); break;
            case 16:  dates = Arania.getNombre(); break;
            case 17:  dates = Camello.getNombre(); break;
            case 18:  dates = Mapache.getNombre(); break;
            case 19:  dates = Jirafa.getNombre(); break;
            case 20:  dates = Tortuga.getNombre(); break;
            case 21:  dates = Caracol.getNombre(); break;
            case 22:  dates = Oveja.getNombre(); break;
            case 23:  dates = Conejo.getNombre(); break;
            case 24:  dates = Lobo.getNombre(); break;
            case 25:  dates = Buey.getNombre(); break;
            case 26:  dates = Canguro.getNombre(); break;
            case 27:  dates = Buho.getNombre(); break;
            case 28:  dates = Venado.getNombre(); break;
            case 29:  dates = Loro.getNombre(); break;
            case 30:  dates = Hipopotamo.getNombre(); break;
            case 31:  dates = Delfin.getNombre(); break;
            case 32:  dates = Puma.getNombre(); break;
            case 33:  dates = Ballena.getNombre(); break;
            case 34:  dates = Ardilla.getNombre(); break;
            case 35:  dates = LLama.getNombre(); break;
            case 36:  dates = Foca.getNombre(); break;
            case 37:  dates = Jaguar.getNombre(); break;
            case 38:  dates = Escorpion.getNombre(); break;
            case 39:  dates = Rinoceronte.getNombre(); break;
            case 40:  dates = Mono.getNombre(); break;
            case 41:  dates = Cocodrilo.getNombre(); break;
            case 42:  dates = Vaca.getNombre(); break;
            case 43:  dates = Chompipe.getNombre(); break;
            case 44:  dates = Panda.getNombre(); break;
            case 45:  dates = Gato.getNombre(); break;
            case 46:  dates = Tigre.getNombre(); break;
            case 47:  dates = Serpiente.getNombre(); break;
            case 48:  dates = Mamut.getNombre(); break;
            case 49:  dates = Leopardo.getNombre(); break;
            case 50:  dates = Gorila.getNombre(); break;
            case 51:  dates = Pulpo.getNombre(); break;
            case 52:  dates = Mosca.getNombre(); break;
            case 53:  dates = Quetzal.getNombre(); break;
            case 54:  dates = Camaleon.getNombre(); break;
            case 55:  dates = Grillo_Zombie.getNombre(); break;
            case 56:  dates = Dirty_Rat.getNombre(); break;
            case 57:  dates = Carnero.getNombre(); break;
            case 58:  dates = Autobus.getNombre(); break;
            case 59:  dates = Zombie_Fly.getNombre(); break;
        }    
        return dates;
    }
    public int getTipo(int codigo)
    {
        int tipo =0;
        switch(codigo)
        {
            case 1:  tipo = Manzana.getTipo(); break;
            case 2:  tipo = Naranja.getTipo(); break;
            case 3:  tipo = Miel.getTipo(); break;
            case 4:  tipo = Pastelito.getTipo(); break;
            case 5:  tipo = Huesodecarne.getTipo(); break;
            case 6:  tipo = Pastillaparadormir.getTipo(); break;
            case 7:  tipo = Ajo.getTipo(); break;
            case 8:  tipo = Ensalada.getTipo(); break;
            case 9:  tipo = Comidaenlatada.getTipo(); break;
            case 10:  tipo = Pera.getTipo(); break;
            case 11:  tipo = Chile.getTipo(); break;
            case 12:  tipo = Chocolate.getTipo(); break;
            case 13:  tipo = Sushi.getTipo(); break;
            case 14:  tipo = Melon.getTipo(); break;
            case 15:  tipo = Hongo.getTipo(); break;
            case 16:  tipo = Pizza.getTipo(); break;
            case 17:  tipo = Carne.getTipo(); break;
            case 18:  tipo = Gelatina.getTipo(); break;
        }
        return tipo;
    }
    public String getNombreC(int codigo)
    {
        String nombre = "";
        switch(codigo)
        {
        case 1:  nombre = Manzana.getNombre(); break;
        case 2:  nombre = Naranja.getNombre(); break;
        case 3:  nombre = Miel.getNombre(); break;
        case 4:  nombre = Pastelito.getNombre(); break;
        case 5:  nombre = Huesodecarne.getNombre(); break;
        case 6:  nombre = Pastillaparadormir.getNombre(); break;
        case 7:  nombre = Ajo.getNombre(); break;
        case 8:  nombre = Ensalada.getNombre(); break;
        case 9:  nombre = Comidaenlatada.getNombre(); break;
        case 10:  nombre = Pera.getNombre(); break;
        case 11:  nombre = Chile.getNombre(); break;
        case 12:  nombre = Chocolate.getNombre(); break;
        case 13:  nombre = Sushi.getNombre(); break;
        case 14:  nombre = Melon.getNombre(); break;
        case 15:  nombre = Hongo.getNombre(); break;
        case 16:  nombre = Pizza.getNombre(); break;
        case 17:  nombre = Carne.getNombre(); break;
        case 18:  nombre = Gelatina.getNombre(); break;
        }
       return nombre;
    }

    /**
     * Animales creados, protegidos para no poder ser modificados
     * se crean con las siguientes caracteristicas/habilidades:
     * ataque  defefensa  vida   codigo  tipo1  tipo2 tipo3
     */
    protected animales Hormiga = new animales(2, 2, 2, 1, "Insecto", "Terrestre","","Hormiga");
    protected animales Pescado = new animales(2, 3, 3, 2, "Acuatico", "","","Pescado");
    protected animales Mosquito = new animales(2, 1, 2, 3, "Volador", "","","Mosquito");
    protected animales Grillo = new animales(1, 3, 2, 4, "Insecto", "","","Grillo");
    protected animales Castor = new animales(2, 3, 2, 5, "Terrestre", "Acuatico","","Castor");
    protected animales Caballo = new animales(2, 4, 1, 6, "Mamifero", "Domestico","","Caballo");
    protected animales Nutria = new animales(1, 3, 2, 7, "Mamifero", "","","Nutria");
    protected animales Escarabajo = new animales(2, 5, 3, 8, "Insecto", "","","Escarabajo");
    protected animales Sapo = new animales(3, 4, 3, 9, "Terrestre", "Acuatico","","Sapo");
    protected animales Dodo = new animales(2, 5, 3, 10, "Volador", "","","Dodo");
    protected animales Elefante = new animales(3, 7, 5, 11, "Mamifero", "Terrestre","","Elefante");
    protected animales Puercoespin = new animales(3, 3, 2, 12, "Solitario", "Terrestre","","Puercoespin");
    protected animales Pavoreal = new animales(2, 4, 5, 13, "Domestico", "Solitario","","Pavoreal");
    protected animales Rata = new animales(4, 4, 5, 14, "Terrestre", "Solitario","","Rata");
    protected animales Zorro = new animales(5, 3, 2, 15, "Solitario", "Terrestre","","Zorro");
    protected animales Arania = new animales(2, 3, 2, 16, "Insecto", "","","Araña");
    protected animales Camello = new animales(2, 4, 5, 17, "Mamifero", "Desertico","","Camello");
    protected animales Mapache = new animales(5, 3, 4, 18, "Solitario", "","","Mapache");
    protected animales Jirafa = new animales(2, 5, 5, 19, "Mamifero", "Terrestre","","Jirafa");
    protected animales Tortuga = new animales(1, 5, 2, 20, "Reptil", "","","Tortuga");
    protected animales Caracol = new animales(2, 4, 2, 21, "Insecto", "Solitario","","Caracol");
    protected animales Oveja = new animales(2, 3, 2, 22, "Domestico", "Terrestre","","Oveja");
    protected animales Conejo = new animales(3, 2, 2, 23, "Mamifero", "","","Conejo");
    protected animales Lobo = new animales(3, 3, 4, 24, "Solitario", "Terrestre","","Lobo");
    protected animales Buey = new animales(1, 5, 4, 25, "Mamifero", "","","Buey");
    protected animales Canguro = new animales(1, 4, 2, 26, "Mamifero", "Terrestre","","Canguro");
    protected animales Buho = new animales(5, 2, 3, 27, "Volador", "Solitario","","Buho");
    protected animales Venado = new animales(1, 3, 1, 28, "Mamifero", "","","Venado");
    protected animales Loro = new animales(5, 2, 3, 29, "Volador", "","","Loro");
    protected animales Hipopotamo = new animales(4, 6, 7, 30, "Acuatico", "Terrestre","","Hipopotamo");
    protected animales Delfin = new animales(4, 4, 6, 31, "Acuatico", "","","Delfin");
    protected animales Puma = new animales(3, 4, 7, 32, "Mamifero", "Terrestre","","Puma");
    protected animales Ballena = new animales(3, 7, 8, 33, "Acuatico", "","","Ballena");
    protected animales Ardilla = new animales(2, 3, 5, 34, "Domestico", "","","Ardilla");
    protected animales LLama = new animales(3, 4, 6, 35, "Terrestre", "","","LLama");
    protected animales Foca = new animales(3, 3, 8, 36, "Acuatico", "Mamifero","","Foca");
    protected animales Jaguar = new animales(7, 4, 4, 36, "Mamifero", "Terrestre","","Jaguar");
    protected animales Escorpion = new animales(1, 2, 1, 37, "Desertico", "Solitario","","Escorpion");
    protected animales Rinoceronte = new animales(5, 5, 8, 38, "Desertico", "Terrestre","","Rinoceronte");
    protected animales Mono = new animales(1, 3, 2, 39, "Mamifero", "","","Mono");
    protected animales Cocodrilo = new animales(8, 4, 4, 40, "Reptil", "Solitario","","Cocodrilo");
    protected animales Vaca = new animales(4, 4, 6, 41, "Mamifero", "Terrestre","","Vaca");
    protected animales Chompipe = new animales(3, 3, 4, 42, "Terrestre", "Volador","","Chompipe");
    protected animales Panda = new animales(5, 4, 5, 43, "Mamifero", "Solitario","","Panda");
    protected animales Gato = new animales(4, 3, 5, 44, "Mamifero", "Domestico","","Gato");
    protected animales Tigre = new animales(4, 4, 3, 45, "Terrestre", "Mamifero","","Tigre");
    protected animales Serpiente = new animales(6, 3, 6, 46, "Reptil", "Terrestre","Desertico","Serpiente");
    protected animales Mamut = new animales(3, 5, 10, 47, "Mamifero", "Terrestre","Solitario","Mamut");
    protected animales Leopardo = new animales(10, 4, 4, 48, "Mamifero", "Terrestre","","Leopardo");
    protected animales Gorila = new animales(6, 4, 9, 49, "Mamifero", "Terrestre","","Gorila");
    protected animales Pulpo = new animales(8, 3, 8, 50, "Acuatico", "Solitario","","Pulpo");
    protected animales Mosca = new animales(5, 3, 5, 52, "Volador", "Insecto","","Mosca");
    protected animales Quetzal = new animales(10, 7, 10, 53, "Volador", "Solitario","","Quetzal");
    protected animales Camaleon = new animales(8, 5, 8, 54, "Reptil", "Solitario","","Camaleon");
    protected animales Grillo_Zombie = new animales(1, 4, 1, 55, "Insecto", "", "","Grillo_Zombie");
    protected animales Dirty_Rat = new animales(1, 2, 1, 56, "Terrestre", "Solitario", "","Dirty_Rat");
    protected animales Carnero = new animales(2, 4, 2, 57, "Domestico", "Terrestre", "","Carnero");
    protected animales Autobus = new animales(5, 5, 5, 58, "Terrestre", "", "","Autobus");
    protected animales Zombie_Fly = new animales(5, 3, 5, 59, "Volador", "Insecto", "","Zombie_Fly");
    protected animales Miniarania = new animales(1,  1,  1,  60, "Insecto","", "", "Miniarania");


    /**
     * Comida creada y protegida para su no modificacion
     * Creadas con las siguientes caracteristicas:
     * codigo   nombres   tipo
     */
    protected comida Manzana = new comida(1 , "Manzana" , 0 );
    protected comida Naranja = new comida(2 , "Naranja" , 1 );
    protected comida Miel = new comida(3 , "Miel" , 1 );
    protected comida Pastelito = new comida(4 , "Pastelito" , 1 );
    protected comida Huesodecarne = new comida(5 , "Huesodecarne" , 1 );
    protected comida Pastillaparadormir = new comida(6 , "Pastillaparadormir" , 1 );
    protected comida Ajo = new comida(7 , "Ajo" , 1 );
    protected comida Ensalada = new comida(8 , "Ensalada" , 0 );
    protected comida Comidaenlatada = new comida(9 , "Comidaenlatada" , 1 );
    protected comida Pera = new comida(10 , "Pera" , 0 );
    protected comida Chile = new comida(11 , "Chile" , 1 );
    protected comida Chocolate = new comida(12 , "Chocolate" , 0 );
    protected comida Sushi = new comida(13 , "Sushi" , 0 );
    protected comida Melon = new comida(14 , "Melon" , 1 );
    protected comida Hongo = new comida(15 , "Hongo" , 1 );
    protected comida Pizza = new comida(16 , "Pizza" , 1 );
    protected comida Carne = new comida(17 , "Carne" , 1 );
    protected comida Gelatina = new comida(18 , "Gelatina" , 1 );
}
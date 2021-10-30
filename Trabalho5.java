
/**
 * Trabalho 5 envolvendo matrizes  .
 *
 * @author (Jeniffer Bittencourt(20103091), Gabriel Souza(20107910)) 
 * @version (30/06/2020)
 */
import java.util.Scanner;
public class Trabalho5{
    //Metodo que apresenta o menu de opções
    public static void Menu(){
        System.out.println(" ________________________________________________________");
        System.out.println("|                   Cine Giravapolis                     |");
        System.out.println("|________________________________________________________|");
        System.out.println("|                                                        |");
        System.out.println("|       1. Comprar ingresso                              |");
        System.out.println("|       2. Ver poltronas                                 |");
        System.out.println("|       3. Ver estante                                   |");
        System.out.println("|       4. Informações da estante                        |");
        System.out.println("|       5. Sair                                          |");
        System.out.println("|________________________________________________________|");
    }
    //Método que imprime para o usuário as poltronas da sala
    public static void imprimePoltronas(int [][] poltronas, String filme){
        int cont = 1; //contador que numera as poltronas
        System.out.println("Apresentação das poltronas do filme '"+filme+"':");
        for (int i = 0; i < 11; i++) {
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                if(poltronas[i][j] == 0){ //Se o conteudo da poltrona for 0
                    System.out.print("|Livre: "+cont+"|"); //avisa que a poltrona está livre e mostra seu número
                }else{ //senão
                    System.out.print("|Ocupado: "+cont+"|");//avisa ue a poltrona está ocupada e mostra seu número
                }
                cont++; //contador soma +1
            }
        }
        System.out.println(""); //só pra pular uma linha mesmo 
    }
    //Método que imprime para o usuário a estante
    public static void imprimeEstante(double [][] estante){
        int cont = 1;//contador que numera os lugares da estante
        System.out.println("Apresentação da estante:");
        for (int i = 0; i < 11; i++) {
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                if(estante[i][j] == 0){ //se o lugar da estante estiver vazio
                    System.out.print("|Livre: "+cont+"|"); //avisa que o lugar esta livre e mostra o nº
                }else{ //senão
                    System.out.print("|Ocupado: "+cont+"|"); //avisa ue o lugar esta ocupado e mostra o nº
                }
                cont++; //contador soma +1
            }
        }
        System.out.println(""); //só pra deixar uma linha em branco novamente
    }
    //Método que imprime o balcão
    public static void imprimeBalcao(double [] balcao){
        int cont = 1; //contador que númera os lugares do balcão
        System.out.println("Apresentação de balcão:");
        for (int i = 0; i < 10; i++) {
            if(balcao[i] == 0){ //se o conteúdo do balcão for vazio
                System.out.println("|Livre: "+cont+"|"); //avisa que o lugar esta livre e mostra o nº
            }else{ //senão
                System.out.println("|Ocupado: "+cont+"|"); //avisa que o lugar esta ocupado e mostra o nº
            }
            cont++; //contador soma +1
        }
    }
    //Método para selecionar o lugar
    public static void selecionarLugar(int [][] poltronas, int lugar){
        int cont = 1; //contador que númera os lugares
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
                if(cont == lugar){ //se o contador for igual ao lugar digitado pelo usuário
                    if(poltronas[i][j] == 0){ //e se o lugar estiver vazio
                        poltronas[i][j] =  lugar; //o lugar na matriz recebe o conteudo da variavel lugar
                        System.out.println("Lugar selecionado com sucesso!"); // e avisa o usuario que o lugar foi selecionado
                    }else{ //senão
                        System.out.println("O lugar já está ocupado!"); //avisa que o lugar já esta ocupado
                    }
                }
                cont++; //contador soma +1
            }
        }
    }
    //Método que guarda o objeto na estante conforme o lugar da poltrona
    public static void guardarObjeto(double [][] estante, double balcao[], int lugar, int controle){
        double volume = 20*50*30; //armazena o volume máximo permetido pra estante
        double h, l, p = 0; //h = altura, l = largura, p = profundidade 
        double vol = 0; // volume final pra comparar com a variavel de volume
        
        Scanner leia = new Scanner(System.in);
        //solicita informações ao usuário
        System.out.println("informe as medidas do item:");
        System.out.println("Altura:");
        h = leia.nextInt(); //lê a altura digitada pelo usuário
        System.out.println("Largura:");
        l = leia.nextInt(); //lê a largura digitada pelo usuário
        System.out.println("Profundidade:");
        p = leia.nextInt(); //lê a profundidade digitada pelo usuário
        
        vol = h*l*p; //guarda na variavel vol o volume total das medidas informadas
        
        if (vol <= volume){ //Se o vol for menor que volume
            int cont = 1;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 5; j++) {
                    if(cont == lugar){ //e se contador for igual ao lugar do usuario
                        if(estante[i][j] == 0){ // e se a estante estiver vazia
                            estante[i][j] =  vol;    //então estante recebe vol
                        }else{ //senão
                            System.out.println("Estante já ocupada!"); //apresenta que a estante ta ocupada
                        }
                    }
                    cont++; //contador soma mais 1
                }
            }                    
        }else{ //se o vol for maior que o volume permitido, então...
            if(controle >= 10){ //se meu balcão já estiver cheio
                System.out.println("Não há mais espaço no balcão!");//apresenta pro usuário que não há mais lugar disponivel
            }else{ //senão
                balcao[controle] = vol; //meu balcao recebe o obj na próxima posição livre 
                System.out.println("Objeto guardado com sucesso!");
                controle++; //controle soma +1
            }                     
        }
    }
    //Método que retorna a porcentagem da estante ocupada
    public static double porcentagem(double [][] estante){
        double porcentagem = 0; //variavel que recebera a porcentagem
        int cont = 1; //contador para somar lugares
        int ocupado = 0; //contador para somar lugares ocupados 
        
        for (int i = 0; i < 11; i++) { //for relaciondo a linha
            for (int j = 0; j < 5; j++) { //for relacionado a coluna
                if(estante [i][j] != 0){ //se o conteudo da estante for diferente de 0
                    ocupado++; //então... ocupado soma +1
                }
                cont++; //contador soma +1
            }
        }
        porcentagem = (ocupado * 100)/cont; //calculo da porcentagem
        
        return porcentagem; //retorna a porcentagem
    }
    //Método retorna ual fileira teve mais gente que deixou objetos
    public static void fileiraObjEstante(int [][] poltrona, double [][] estante){
        int fileira = 0; //variavel pra guardar o nº da fileira/linha
        int coluna = 0; //variavel que irá somar as colunas ue possuem conteudo
        int aux = 0; //variavel que recebe a quantidade maior de elementos de uma linha   
        for (int i = 0; i < 11; i++) {
            coluna = 0;
            for (int j = 0; j < 5; j++) {
                if(poltrona[i][j] != 0 && estante[i][j] != 0 ){
                    coluna++; //coluna soma +1
                }
            }
            if(coluna > aux){ //se coluna for maior ue aux então
              aux = coluna; //aux recebe conteudo da coluna 
              fileira = i+1; //fileira recebe a fileira correspondente
            }
        }
        System.out.println("A fileira com mais objetos guardados é: "+fileira);
    }
    //Método que retorna o objeto mais volumoso
    public static void objVolumoso(double [][] estante, double balcao[]){
        double obj = 0; //variavel que guarda o obj mais volumoso da estante
        int linha = 0; //variavel que informa a linha
        int coluna = 0; //variavel que informa a coluna
        double obj1 = 0; //variavel ue guarda o objeto mais volumoso do balcao
        int prateleira = 0; //prateleira do balcão
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
               if(estante [i][j] > obj){ //se o conteudo da estante for maior que o obj
                   obj = estante[i][j]; //obj recebe o conteudo da estante
                   linha = i+1; //linha recebe o número da fileira
                   coluna = j+1; // coluna recebe a identificação da coluna
               } 
            }
        }
        System.out.println("Na estante o objeto mais volumoso esta na fileira "+linha+", na coluna "+coluna+" e seu volume é :"+obj);
        
        for (int i = 0; i < 10; i++) {
            if(balcao[i] > obj1){
                obj1 = balcao[i];
                prateleira = i+1;
            }
        }
        System.out.println("No balcão o objeto mais volumoso esta na parteleira "+prateleira+" e seu volume é: "+obj1);
        
        if(obj > obj1){
            System.out.println("E entre o balcao e estante o maior objeto é: "+obj+"que se encontra na estante na fileira "+linha+" e na coluna"+coluna+".");
        }else{
            System.out.println("E entre o balcao e estante o maior objeto é: "+obj1+"que se encontra no balcão na parteleira "+prateleira+".");
        }
    }
    //Método que retorna a quantidade de itens dentro do balcão
    public static int objBalcao(double [] balcao){
        int cont = 0; //variavel que irá armazenar a quantia de itens dentro de uo balcão
        for (int i = 0; i < 10; i++) {
            if(balcao[i] != 0){ //se o conteudo for diferente de 0
                cont++; //contador soma +1
            }
        }
        return cont; //retorna o contador
    }
    public static void main(String[] args) {
        int opcao = 0; //váriavel que recebe a opção digitada pelo usuário
        int lugar = 0; //váriavel que guarda o valor digitado pelo usuário
        int controle = 0; //variavel de controle do vetor
        double balcao [] = new double [10]; //vetor do balcão
        int poltronas [][] = new int [11][5]; //Matriz para lugares
        double estante [][] = new double [11][5]; //Matriz para estante
        String filme = "A viagem de Chihiro"; //nome de um filme aleatório
        
        Scanner leia = new Scanner(System.in); //classe ue simula um teclado, para ler os dados que o usuario informa
        
        do{
            Menu();//Apresenta o menu principal
            System.out.println("Selecione uma das opções acima:");
            opcao = leia.nextInt(); //lê a opção digitada pelo usuário
            
            if(opcao == 1){ //Se ele digitar 1, entra na opção de comprar ingresso

                imprimePoltronas(poltronas, filme); //imprime os lugares que tem disponivel para o usuário escolher
                System.out.println("");
                        
                System.out.println("Escolha o lugar que deseja sentar:");
                lugar = leia.nextInt(); //lê a o lugar digitado pelo usuário
                        
                selecionarLugar(poltronas, lugar); //método que seleciona o lugar desejado
                        
                System.out.println("");//já sabemos que isso é só pra enfeite
                        
                System.out.println("Deseja guardar algum item no armário?");
                System.out.println("1.sim || 2.não");
                opcao = leia.nextInt(); //lê a opção digitada pelo usuário
                        
                if(opcao == 1){ //Se o usuário digitar 1, então...
                    guardarObjeto(estante, balcao, lugar, controle); //Método que guarda o objeto na estante ou balcão é chamado
                    System.out.println("");
                }
            }
            
            if(opcao == 2){ //apresenta ao usuario os lugares disponiveis
                imprimePoltronas(poltronas, filme); //Método que imprime as poltronas
                System.out.println("");
            }
            
            if(opcao == 3){ //apresenta os lugares disponiveis na estante
                imprimeEstante(estante); //Método que imprime a estante
                System.out.println(""); //enfeite
                imprimeBalcao(balcao); //Método que imprime balcão
                System.out.println(""); //enfeite
            }
            
            if(opcao == 4){ //retorna informações sobre a estante
                System.out.println("Porcentagem ocupada na estante: "+porcentagem(estante)+"%");
                fileiraObjEstante(poltronas, estante);
                objVolumoso(estante, balcao);
                System.out.println("O total de objetos que ficaram no balcão é: "+objBalcao(balcao));
                System.out.println("");
            }             
        }while(opcao != 5);
        System.out.println("    /)/)\n" +
                       "   ( ..\\\n" +
                       "   /'-._)\n" +
                       "  /#/\n" +
                       " /#/  ");
            System.out.println("_______Fim!");
    }
}

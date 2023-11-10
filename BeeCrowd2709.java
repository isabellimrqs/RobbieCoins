import java.util.Scanner;

public class BeeCrowd2709
{
    public static void main(String[] args)
    {
        // Definição de variáveis e instânciação do Scanner
        Scanner sc = new Scanner(System.in);
        boolean valorInvalido = true;
        int qtdMoedas = 0;
        int soma = 0;

        // Loop para checar quantidade de moedas que serão inseridas
        while(valorInvalido)
        {
            System.out.println("Insira o número de moedas que deseja jogar: [2-20]");
            qtdMoedas = sc.nextInt();

            if(qtdMoedas<2 || qtdMoedas>20)
            {
                System.out.println("Valor inválido! Insira um valor válido!");
            }
            else{
                valorInvalido = false;
            }
        }

        int moedas[] = new int[qtdMoedas];

        // Adicionar moedas na lista
        for(int cont=0; cont<qtdMoedas; cont++)
        {
            System.out.println("Insira o valor da "+(cont+1)+"° moeda: ");
            int valor = sc.nextInt();
            if(valor<0 || valor>500)
            {
                System.out.println("Valor inválido!");
                cont-=1;
                continue;
            }
            moedas[cont] = valor;
        }

        // Mostrar as moedas que foram inseridas
        System.out.println("\n=================================================\n");
        System.out.println("Valores de moedas inseridos: ");
        for(int moeda : moedas) {
            System.out.println(moeda);
        }

        // Capturar salto das moedas
        System.out.println("\nInsira o salto entre as moedas [Intervalo de soma]: ");
        int salto = sc.nextInt();

        // Calcular soma aplicando o salto
        for(int cont=qtdMoedas-1; cont>= 0; cont-=salto)
        {
            soma += moedas[cont];
        }
        System.out.println("A soma dos números após o salto foi " +soma);
        
        // Chamada de método para checar número primo
        boolean primo = checarNumPrimo(soma);

        // Definindo mensagem para caso seja primo ou não
        if(primo)
        {
            System.out.println("Você é zika, Robbie!");
        } else{
            System.out.println("Vacilão, você está me roubando!");
        }
        sc.close();
    }

    // Método para checar se um número é primo ou não
    public static boolean checarNumPrimo(int soma)
    {
        for(int mult=2; mult<soma-1; mult++)
        {
            if(soma%mult==0)
            {
                return false;
            }
        }
        return true;
    }
}

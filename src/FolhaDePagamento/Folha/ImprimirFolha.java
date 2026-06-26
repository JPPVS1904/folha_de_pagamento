package FolhaDePagamento.Folha;

public class ImprimirFolha {

    private static final int LARGURA_LINHA = 45;
    private static final int LARGURA_VALOR = 8;

    private static void linha(String descricao, double valor) {

        String valorFormatado = String.format("%.2f", valor);

        int pontos = LARGURA_LINHA - descricao.length() - LARGURA_VALOR - 3;

        StringBuilder pontilhado = new StringBuilder();
        for (int i = 0; i < pontos; i++) {
            pontilhado.append(".");
        }

        System.out.printf("%s%sR$ %"+LARGURA_VALOR+"s%n",
                descricao,
                pontilhado.toString(),
                valorFormatado);
    }

    private static String mesFolha(int mes){
        switch (mes){
            case 1:  return   "Janeiro";
            case 2:  return "Fevereiro";
            case 3:  return     "Março";
            case 4:  return     "Abril";
            case 5:  return      "Maio";
            case 6:  return     "Junho";
            case 7:  return     "Julho";
            case 8:  return    "Agosto";
            case 9:  return  "Setembro";
            case 10: return   "Outubro";
            case 11: return  "Novembro";
            case 12: return  "Dezembro";
        }
        return "";
    }

    public static void imprimir(ResultadoFolha r) {

        System.out.printf("===== FOLHA DE PAGAMENTO ====="
                +"\n%s de %d"
                +"\nFuncionário: %s"
                +"\nCargo: %s\n", mesFolha(r.mesFolha), r.anoFolha, r.nome, r.cargo);

        System.out.println("\n--- PROVENTOS ---");
        for (ItemFolha p : r.proventos) {
            linha(p.getDescricao(), p.getValor());
        }

        System.out.println("\n--- DESCONTOS ---");
        for (ItemFolha d : r.descontos) {
            linha(d.getDescricao(), d.getValor());
        }

        if (!r.informativos.isEmpty()) {
            System.out.println("\n--- INFORMATIVOS ---");
            for (ItemFolha i : r.informativos) {
                linha(i.getDescricao(), i.getValor());
            }
        }

        System.out.println("\n--- TOTAIS ---");
        linha("TOTAL BRUTO", r.getTotalProventos());
        linha("TOTAL LÍQUIDO", r.getLiquido());
    }
}

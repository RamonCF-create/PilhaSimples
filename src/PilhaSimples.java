public class PilhaSimples implements IEstruturaSimples {

    private Object[] elementos = new Object[10];
    private int topo = -1;

    @Override
    public void inserirElemento(Object elemento) {
        if (estaCheia()) {
            dobrarCapacidade();
        }
        topo++;
        elementos[topo] = elemento;
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        System.out.println("Operação inválida para pilha. Inserção só pode ser no topo.");
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            for (Object e : (Object[]) elementos) {
                inserirElemento(e);
            }
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) return false;
        elementos[topo] = null;
        topo--;
        return true;
    }

    @Override
    public Object removerIndice(int indice) {
        System.out.println("Operação inválida para pilha. Só é possível remover do topo.");
        return null;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            for (Object e : (Object[]) elementos) {
                removerTodasOcorrencias(e);
            }
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        Object[] novaPilha = new Object[elementos.length];
        int novoTopo = -1;

        for (int i = 0; i <= topo; i++) {
            if (!elementos[i].equals(elemento)) {
                novaPilha[++novoTopo] = elementos[i];
            }
        }

        elementos = novaPilha;
        topo = novoTopo;
    }

    @Override
    public boolean estaCheia() {
        return topo == elementos.length - 1;
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        for (int i = 0; i <= topo; i++) {
            if (elementos[i].equals(elemento)) return true;
        }
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice < 0 || indice > topo) return null;
        return elementos[indice];
    }

    @Override
    public void ordenarCrescente() {
        for (int i = 0; i <= topo; i++) {
            for (int j = 0; j < topo - i; j++) {
                Object atual = elementos[j];
                Object proximo = elementos[j + 1];

                double numA = parseDoubleSafe(atual);
                double numB = parseDoubleSafe(proximo);

                if (!Double.isNaN(numA) && !Double.isNaN(numB)) {
                    if (numA > numB) {
                        Object temp = elementos[j];
                        elementos[j] = elementos[j + 1];
                        elementos[j + 1] = temp;
                    }
                } else {
                    System.out.println("Tipos incompatíveis entre posições " + j + " e " + (j + 1));
                }
            }
        }
    }

    private double parseDoubleSafe(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        } else if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                return Double.NaN;
            }
        }
        return Double.NaN;
    }


    @Override
    public void ordenarDecrescente() {
        for (int i = 0; i <= topo; i++) {
            for (int j = 0; j < topo - i; j++) {
                Object atual = elementos[j];
                Object proximo = elementos[j + 1];

                double numA = parseDoubleSafe(atual);
                double numB = parseDoubleSafe(proximo);

                if (!Double.isNaN(numA) && !Double.isNaN(numB)) {
                    if (numA < numB) {
                        Object temp = elementos[j];
                        elementos[j] = elementos[j + 1];
                        elementos[j + 1] = temp;
                    }
                } else {
                    System.out.println("Tipos incompatíveis entre posições " + j + " e " + (j + 1));
                }
            }
        }
    }


    @Override
    public int quantidadeElementos() {
        return topo + 1;
    }

    @Override
    public void dobrarCapacidade() {
        Object[] novoArray = new Object[elementos.length * 2];
        for (int i = 0; i <= topo; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray;
    }

    @Override
    public void editarElemento(Object antigo, Object novoElemento) {
        for (int i = 0; i < topo; i++) {
            if (elementos[i].equals(antigo)) {
                elementos[i] = novoElemento;
                break;
            }
        }
    }

    @Override
    public void limpar() {
        for (int i = 0; i <= topo; i++) {
            elementos[i] = null;
        }
        topo = -1;
    }

    @Override
    public void exibir() {
        System.out.print("Pilha: [");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i]);
            if (i < topo) System.out.print(", ");
        }
        System.out.println("]");
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) return null;
        return elementos[0];
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) return null;
        return elementos[topo];
    }
}
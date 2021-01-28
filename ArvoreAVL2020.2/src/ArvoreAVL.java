
public class ArvoreAVL {
	
	 No raiz;

	    public void rotacaoSimplesEsquerda(No desbalanceado) {
	        No pivo = desbalanceado.direita;
	        pivo.pai = desbalanceado.pai;
	        desbalanceado.direita = pivo.esquerda;
	        pivo.esquerda = desbalanceado;
	        desbalanceado.pai = pivo;
	        if (desbalanceado == raiz) {
	            raiz = pivo;
	        } else {
	            if (pivo.pai.valor <= pivo.valor) {
	                pivo.pai.direita = pivo;
	            } else {
	                pivo.pai.esquerda = pivo;
	            }
	        }
	    }

	    public void rotacaoSimplesDireita(No desbalanceado) {
	        No pivo = desbalanceado.esquerda;
	        pivo.pai = desbalanceado.pai;
	        desbalanceado.esquerda = pivo.direita;
	        pivo.direita = desbalanceado;
	        desbalanceado.pai = pivo;
	        if (desbalanceado == raiz) {
	            raiz = pivo;
	        } else {
	            if (pivo.pai.valor <= pivo.valor) {
	                pivo.pai.direita = pivo;
	            } else {
	                pivo.pai.esquerda = pivo;
	            }
	        }
	    }

	    public void rotacaoDuplaDireita(No desbalanceado) {
	        rotacaoSimplesEsquerda(desbalanceado.esquerda);
	        rotacaoSimplesDireita(desbalanceado);
	    }

	    public void rotacaoDuplaEsquerda(No desbalanceado) {
	        rotacaoSimplesDireita(desbalanceado.direita);
	        rotacaoSimplesEsquerda(desbalanceado);
	    }

	    public int fatorBalanceamento(No no) {
	        return altura(no.esquerda) - altura(no.direita);
	    }

	    public int altura(No no) {
	        if (no == null || (no.esquerda == null && no.direita == null)) {
	            return 0;
	        } else if (no.esquerda==null){
	            return 1 + altura(no.direita);
	        }else if (no.direita==null)
	            return 1 + altura(no.esquerda);
	        else if(altura(no.esquerda) > altura(no.direita)){
	        	return (1 + altura(no.esquerda)); 
	        }else {
	        	return (1 + altura(no.direita));
	        }
	        
	    }

}

package pt.pa.adts.queue;

import java.util.List;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;


    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        this.header = null;  // Não há elementos, então header é null
        this.trailer = null; // Também não há elementos, então trailer é null
        this.size = 0;       // O tamanho da fila é 0
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {

        // Verifica se o elemento é nulo
        if (elem == null) {
            throw new NullPointerException("O elemento não pode ser nulo.");
        }

        // Cria o novo nó, o novo nó "prev" é o trailer atual, e o próximo é null
        ListNode newNode = new ListNode(elem, null, trailer);

        if (size == 0) {
            // Se a fila estiver vazia, o novo nó será tanto o header quanto o trailer
            header = newNode;
            trailer = newNode;
        } else {
            // Caso contrário, adiciona o novo nó ao final da fila
            trailer.next = newNode; // O próximo do trailer atual aponta para o novo nó
            trailer = newNode;      // O novo nó se torna o trailer
        }

        // Incrementa o tamanho da fila
        size++;
    }


    @Override
    public T dequeue() throws QueueEmptyException {
        T a = header.element;
       if(size == 0) {
           throw new QueueEmptyException("ta vazia");
       }else {
           header = header.next;
           header.prev = null;
           size--;

       }
        return a;
    }
    // Front - Retorna o próximo elemento
    @Override
    public T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException("ta vazia");
        }
        return header.element;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if( size == 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {

       for(int i = 0; i <= size; i++) {
           header = header.next;
           header.prev = null;
           header.next = null;
       }
       header = null;
       trailer = null;
       size = 0;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

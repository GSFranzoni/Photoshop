
package Model;

import java.util.Stack;

public class Operacoes {
    Stack<Imagem>[] stack;

    public Operacoes() {
        this.stack = (Stack<Imagem>[]) new Stack[3];
        for(int i=0; i<3; i++){
            stack[i] = new Stack<>();
        }
    }
    
    public void setImage(int i, Imagem image){
        this.stack[i].push(image);
    }
    
    public void popImage(int i){
        if(this.stack[i].size()>1)
            this.stack[i].pop();
    }
    
    public void refresh(int i){
        while(this.stack[i].size()>1)
            this.stack[i].pop();
    }
    
    public Imagem getImage(int i){
        return this.stack[i].peek().getClone();
    }
    
    public Stack getStack(int i){
        return this.stack[i];
    }
}

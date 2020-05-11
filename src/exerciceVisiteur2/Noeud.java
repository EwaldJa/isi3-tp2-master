package exerciceVisiteur2;


public interface Noeud {

    public void accept(Visitor v);

    public boolean isHighPriority();
}


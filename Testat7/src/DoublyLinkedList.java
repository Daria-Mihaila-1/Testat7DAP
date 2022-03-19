public class DoublyLinkedList
{
    // hier fuer Testat ergaenzen

    public void apply( Object obj ) {

       if (!this.isEmpty()) {

           if (this.first.content.equals(obj) || this.last.content.equals(obj)) {

                this.last.content = obj;
            } else {

               Element current = first;
                boolean found = false;

                while (current.hasSucc() && found) {

                    if (current.content.equals(obj)) {

                        found = true;
                    }
                }
                if (found) {
                    this.last.content = obj;
                }
            }
        }
    }

    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    // Element

    private class Element
    {
        private Object content;
        private Element pred, succ;

        Element( Object c )
        {
            content = c;
            pred = succ = null;
        }

        Object getContent()
        {
            return content;
        }

        void setContent( Object c )
        {
            content = c;
        }

        boolean hasSucc()
        {
            return succ != null;
        }

        Element getSucc()
        {
            return succ;
        }

        void disconnectSucc()
        {
            if ( hasSucc() ) 
            {
                succ.pred = null;
                succ = null;
            }
        }

        void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null ) 
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        boolean hasPred()
        {
            return pred != null;
        }

        Element getPred()
        {
            return pred;
        }

        void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }

    }
}    

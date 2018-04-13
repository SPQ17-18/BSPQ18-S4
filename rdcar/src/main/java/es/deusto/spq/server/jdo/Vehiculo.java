package es.deusto.spq.server.jdo;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@PersistenceCapable
public class Vehiculo {

	long id;

    String name = null;

    //@Persistent(mappedBy="Vehiculo")
    Set<Alquiler> customerRelations = new HashSet();

    public Vehiculo(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addRelation(Alquiler rel)
    {
        if (customerRelations == null)
        {
            customerRelations = new HashSet<Alquiler>();
        }
        customerRelations.add(rel);
    }

    public void removeRelation(Alquiler rel)
    {
        if (customerRelations == null)
        {
            return;
        }
        customerRelations.remove(rel);
    }

    public Set<Alquiler> getRelations()
    {
        if (customerRelations == null)
        {
            customerRelations = new HashSet<Alquiler>();
        }
        return customerRelations;
    }

    public int getNumberOfRelations()
    {
        if (customerRelations == null)
        {
            return 0;
        }
        return customerRelations.size();
    }

    public String toString()
    {
        return "Vehiculo : " + name + " - " + customerRelations.size() + " customers";
    }

    public static class PK implements Serializable
    {
        private static final long serialVersionUID = -4093751077746226151L;
        public long id;

        public PK()
        {
        }

        public PK(java.lang.String str)
        {
            java.util.StringTokenizer token = new java.util.StringTokenizer(str, "::");
            token.nextToken(); // Class name
            this.id = Long.valueOf(token.nextToken());
        }

        public java.lang.String toString()
        {
            return Vehiculo.class.getName() + "::" + java.lang.String.valueOf(this.id);
        }

        public int hashCode()
        {
            return (int) id;
        }

        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null)
            {
                return false;
            }
            if (o.getClass() != getClass())
            {
                return false;
            }
            PK objToCompare = (PK) o;
            return ((this.id == objToCompare.id));
        }
    }
	
}

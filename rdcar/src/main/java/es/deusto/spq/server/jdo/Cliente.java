package es.deusto.spq.server.jdo;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@PersistenceCapable
public class Cliente {

	 long id;

	    String name = null;
	    
	    

	    //@Persistent(mappedBy="Cliente")
	    Set<Alquiler> AAlquileres = new HashSet();

	    public Cliente(String name)
	    {
	        this.name = name;
	    }

	    public void addRelation(Alquiler rel)
	    {
	        AAlquileres.add(rel);
	    }

	    public void removeRelation(Alquiler rel)
	    {
	        AAlquileres.remove(rel);
	    }

	    public Set<Alquiler> getRelations()
	    {
	        return AAlquileres;
	    }

	    public int getNumberOfRelations()
	    {
	        return AAlquileres.size();
	    }

	    public String toString()
	    {
	        return "Cliente : " + name + " - " + AAlquileres.size() + " suppliers";
	    }

	    public static class PK implements Serializable
	    {
	        private static final long serialVersionUID = 7596143906460627568L;
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
	            return Cliente.class.getName() + "::" + java.lang.String.valueOf(this.id);
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

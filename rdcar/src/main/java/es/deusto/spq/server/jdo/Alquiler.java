package es.deusto.spq.server.jdo;


import java.io.Serializable;
import java.util.StringTokenizer;

//@PersistenceCapable
public class Alquiler {

	 //@PrimaryKey
    private Cliente Cliente;

    //@PrimaryKey
    private Vehiculo vehiculo;

    private String relationLevel;

    private String meetingLocation;

    public Alquiler(Cliente cli, Vehiculo vehi, String level, String meeting)
    {
        this.Cliente = cli;
        this.vehiculo = vehi;
        this.relationLevel = level;
        this.meetingLocation = meeting;
    }

    public Cliente getCliente()
    {
        return Cliente;
    }

    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }

    public String getRelationLevel()
    {
        return relationLevel;
    }

    public String getMeetingLocation()
    {
        return meetingLocation;
    }

    /**
     * Primary-Key for Alquiler.
     * Made up of Cliente and Vehiculo.
     */
    public static class PK implements Serializable
    {
        private static final long serialVersionUID = 6523985844759937342L;
        public Cliente.PK Cliente; // Use same name as field above
        public Vehiculo.PK vehiculo; // Use same name as field above

        public PK()
        {
        }

        public PK(String s)
        {
            StringTokenizer st = new StringTokenizer(s, "--");
            this.Cliente = new Cliente.PK(st.nextToken());
            this.vehiculo = new Vehiculo.PK(st.nextToken());
        }

        public String toString()
        {
            return (Cliente.toString() + "--" + vehiculo.toString());
        }

        public int hashCode()
        {
            return Cliente.hashCode() ^ vehiculo.hashCode();
        }

        public boolean equals(Object other)
        {
            if (other != null && (other instanceof PK))
            {
                PK otherPK = (PK)other;
                return this.Cliente.equals(otherPK.Cliente) && this.vehiculo.equals(otherPK.vehiculo);
            }
            return false;
        }
    }
	
}

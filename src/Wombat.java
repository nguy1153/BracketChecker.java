
public class Wombat implements Comparable<Wombat> {
    private String name;
    private int severity;
    private double time;

    public Wombat(String name, int severity, double time) throws SeverityOutOfBoundsException {
        this.setSeverity(severity);
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(Wombat wombat) {
        if (wombat.getSeverity() > this.getSeverity())
            return 1;
        if (wombat.getSeverity() == this.getSeverity())
            return Double.compare(this.getTime(), wombat.getTime());
        else
            return -1;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) throws SeverityOutOfBoundsException {
        if (severity > 10 | severity < 1)
            throw new SeverityOutOfBoundsException("Severity is not within 1-10");
        this.severity = severity;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return name + ", " + severity + ", " + time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

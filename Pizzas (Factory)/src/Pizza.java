public abstract class Pizza {
	protected String masa="no";
	protected String salsa="no";
	protected String queso="no";
	protected String pepperoni="no";
	protected String vegetales="no";
	protected String salchicha="no";

	public abstract void preparar();
	public abstract void hornear();
	public abstract void cortar();
	public abstract void empacar();

	@Override
	public String toString() {
	return "Pizza [masa=" + masa + ", salsa=" + salsa + ", queso=" + queso + ", pepperoni=" + pepperoni + ", vegetales=" + vegetales + ",salchicha=" + salchicha +"]";
	}
}
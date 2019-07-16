package Models;

public class CustomClass<T,U>
{
	private T first;
	private U second;
	
	

	public CustomClass()
	{
	}
	public CustomClass(T first, U second)
	{
		this.setFirst(first);
		this.setSecond(second);
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public U getSecond() {
		return second;
	}

	public void setSecond(U second) {
		this.second = second;
	}
	
	
}

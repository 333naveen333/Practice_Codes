package Codes;
interface i
{
	default void show()
	{
		System.out.print(false);
	}
}
interface j
{
	default void show()
	{
		System.out.print(true);
	}
}
public class example2 implements i,j
{ 
	public void show() {
    i.super.show();
  
    j.super.show();
 }
 public static void main(String args[]) {
	 example2 obj = new example2();
    obj.show();
 }
}


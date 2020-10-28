

public class C extends Common {

	B b;


public static void main(String args[])
{
	A a=new A();
	
	B b=new B();
	
	A c=new A();
	
	a.b.c=c.b.a;
}

}
